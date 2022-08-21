package com.lucasbrunkhorst.ecommerceapi.controller;

import com.lucasbrunkhorst.ecommerceapi.domain.dto.OrderItemRequestDto;
import com.lucasbrunkhorst.ecommerceapi.domain.dto.OrderRequestDto;
import com.lucasbrunkhorst.ecommerceapi.entity.Order;
import com.lucasbrunkhorst.ecommerceapi.entity.OrderItem;
import com.lucasbrunkhorst.ecommerceapi.service.CrudService;
import com.lucasbrunkhorst.ecommerceapi.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/orders")
@RequiredArgsConstructor
public class OrderController extends CrudController<Order, OrderRequestDto> {

    private final OrderService orderService;

    private final ModelMapper modelMapper;

    @Override
    public CrudService<Order> getService() {
        return orderService;
    }

    @PostMapping("{uuid}/items")
    public Order createItem(@PathVariable("uuid") String uuid,
                            @Valid @RequestBody OrderItemRequestDto orderItemRequest) {

        Order order = getService().read(uuid);
        OrderItem orderItem = modelMapper.map(orderItemRequest, OrderItem.class);
        order.getItems().add(orderItem);
        return getService().save(order);
    }
}
