package com.lucasbrunkhorst.ecommerceapi.service.impl;

import com.lucasbrunkhorst.ecommerceapi.entity.OrderItem;
import com.lucasbrunkhorst.ecommerceapi.repository.OrderItemRepository;
import com.lucasbrunkhorst.ecommerceapi.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl extends CrudServiceImpl<OrderItem> implements OrderItemService {

    private final OrderItemRepository orderItemRepository;

    @Override
    public JpaRepository<OrderItem, String> getRepository() {
        return orderItemRepository;
    }

    @Override
    protected void preSave(OrderItem entity) {
        BigDecimal value = entity.getItem().getValue().multiply(entity.getQuantity());
        entity.setValue(value);
    }

    @Override
    public OrderItem findByUuidAndOrderUuid(String orderUuid, String orderItemUuid) {
        return orderItemRepository.findByUuidAndOrderUuid(orderUuid, orderItemUuid);
    }
}
