package com.lucasbrunkhorst.ecommerceapi.controller;

import com.lucasbrunkhorst.ecommerceapi.domain.dto.OrderItemRequestDto;
import com.lucasbrunkhorst.ecommerceapi.domain.dto.OrderRequestDto;
import com.lucasbrunkhorst.ecommerceapi.entity.Order;
import com.lucasbrunkhorst.ecommerceapi.entity.OrderItem;
import com.lucasbrunkhorst.ecommerceapi.service.CrudService;
import com.lucasbrunkhorst.ecommerceapi.service.ItemService;
import com.lucasbrunkhorst.ecommerceapi.service.OrderItemService;
import com.lucasbrunkhorst.ecommerceapi.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/orders")
@RequiredArgsConstructor
public class OrderController extends CrudController<Order, OrderRequestDto> {

    private final OrderService orderService;
    private final ItemService itemService;
    private final OrderItemService orderItemService;

    @Override
    public CrudService<Order> getService() {
        return orderService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("{uuid}/items")
    public OrderItem createItem(@PathVariable("uuid") String uuid,
                                @Valid @RequestBody OrderItemRequestDto orderItemRequest) {

        Order order = orderService.read(uuid);
        OrderItem orderItem = OrderItem.builder()
                .order(order)
                .item(itemService.read(orderItemRequest.getItemUuid()))
                .quantity(orderItemRequest.getQuantity())
                .build();

        orderItemService.save(orderItem);
        orderService.save(order);

        return orderItem;
    }

    @GetMapping("{uuid}/items/{orderItemUuid}")
    public OrderItem readItem(@PathVariable("uuid") String uuid,
                              @PathVariable("orderItemUuid") String orderItemUuid) {
        return orderItemService.findByUuidAndOrderUuid(orderItemUuid, uuid);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("{uuid}/items/{orderItemUuid}")
    public OrderItem updateItem(@PathVariable("uuid") String uuid,
                                @PathVariable("orderItemUuid") String orderItemUuid,
                                @Valid @RequestBody OrderItemRequestDto orderItemRequest) {

        OrderItem orderItem = readItem(uuid, orderItemUuid);
        orderItem.setItem(itemService.read(orderItemRequest.getItemUuid()));
        orderItem.setQuantity(orderItemRequest.getQuantity());

        orderItemService.save(orderItem);
        orderService.save(orderItem.getOrder());

        return orderItem;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{uuid}/items/{orderItemUuid}")
    public void deleteItem(@PathVariable("uuid") String uuid,
                           @PathVariable("orderItemUuid") String orderItemUuid) {

        orderItemService.delete(orderItemUuid);
        Order order = orderService.read(uuid);
        orderService.save(order);
    }

    @GetMapping("{uuid}/items")
    public List<OrderItem> listItems(@PathVariable("uuid") String uuid) {
        Order order = orderService.read(uuid);
        return order.getItems();
    }

    @PutMapping("{uuid}/close")
    public Order close(@PathVariable("uuid") String uuid) {
        return orderService.close(uuid);
    }

}
