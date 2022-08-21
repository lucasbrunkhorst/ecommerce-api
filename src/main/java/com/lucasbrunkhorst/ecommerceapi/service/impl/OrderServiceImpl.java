package com.lucasbrunkhorst.ecommerceapi.service.impl;

import com.lucasbrunkhorst.ecommerceapi.domain.enumeration.ItemType;
import com.lucasbrunkhorst.ecommerceapi.entity.Order;
import com.lucasbrunkhorst.ecommerceapi.entity.OrderItem;
import com.lucasbrunkhorst.ecommerceapi.repository.OrderRepository;
import com.lucasbrunkhorst.ecommerceapi.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl extends CrudServiceImpl<Order> implements OrderService  {

    private final OrderRepository orderRepository;

    @Override
    public JpaRepository<Order, String> getRepository() {
        return orderRepository;
    }

    @Override
    protected void preSave(Order entity) {
        BigDecimal totalValue = entity.getItems().stream()
                .map(OrderItem::getValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        entity.setTotalValue(totalValue);
    }

    @Override
    public Order close(String uuid) {
        Order order = read(uuid);
        BigDecimal totalProductValues = order.getItems().stream()
                .filter(orderItem -> ItemType.P.equals(orderItem.getItem().getType()))
                .map(OrderItem::getValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal discountValue = totalProductValues.multiply(order.getPercentualDiscount()
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP));

        order.setTotalValue(order.getTotalValue().subtract(discountValue));
        return orderRepository.save(order);
    }
}
