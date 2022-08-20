package com.lucasbrunkhorst.ecommerceapi.controller;

import com.lucasbrunkhorst.ecommerceapi.domain.dto.OrderRequestDto;
import com.lucasbrunkhorst.ecommerceapi.entity.Order;
import com.lucasbrunkhorst.ecommerceapi.service.CrudService;
import com.lucasbrunkhorst.ecommerceapi.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/orders")
@RequiredArgsConstructor
public class OrderController extends CrudController<Order, OrderRequestDto> {

    private final OrderService orderService;

    @Override
    public CrudService<Order> getService() {
        return orderService;
    }
}
