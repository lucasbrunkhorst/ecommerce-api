package com.lucasbrunkhorst.ecommerceapi.repository;

import com.lucasbrunkhorst.ecommerceapi.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, String> {

    OrderItem findByUuidAndOrderUuid(String uuid, String orderUuid);
}
