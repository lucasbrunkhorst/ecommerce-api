package com.lucasbrunkhorst.ecommerceapi.controller;

import com.lucasbrunkhorst.ecommerceapi.domain.dto.ItemRequestDto;
import com.lucasbrunkhorst.ecommerceapi.entity.Item;
import com.lucasbrunkhorst.ecommerceapi.service.CrudService;
import com.lucasbrunkhorst.ecommerceapi.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/items")
@RequiredArgsConstructor
public class ItemController extends CrudController<Item, ItemRequestDto> {

   private final ItemService itemService;

    @Override
    public CrudService<Item> getService() {
        return itemService;
    }
}
