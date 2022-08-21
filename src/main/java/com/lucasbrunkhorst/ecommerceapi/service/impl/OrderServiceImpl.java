package com.lucasbrunkhorst.ecommerceapi.service.impl;

import com.lucasbrunkhorst.ecommerceapi.entity.Order;
import com.lucasbrunkhorst.ecommerceapi.entity.OrderItem;
import com.lucasbrunkhorst.ecommerceapi.repository.OrderRepository;
import com.lucasbrunkhorst.ecommerceapi.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

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
}
