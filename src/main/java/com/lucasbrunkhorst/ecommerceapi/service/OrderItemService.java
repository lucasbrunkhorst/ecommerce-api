package com.lucasbrunkhorst.ecommerceapi.service;

import com.lucasbrunkhorst.ecommerceapi.entity.OrderItem;

public interface OrderItemService extends CrudService<OrderItem> {

    OrderItem findByUuidAndOrderUuid(String orderUuid, String orderItemUuid);
}
