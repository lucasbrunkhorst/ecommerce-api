package com.lucasbrunkhorst.ecommerceapi.service;

import com.lucasbrunkhorst.ecommerceapi.entity.Order;

public interface OrderService extends CrudService<Order> {
    Order close(String uuid);
}
