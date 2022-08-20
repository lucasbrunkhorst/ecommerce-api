package com.lucasbrunkhorst.ecommerceapi.repository;

import com.lucasbrunkhorst.ecommerceapi.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {
}
