package com.lucasbrunkhorst.ecommerceapi.service.impl;

import com.lucasbrunkhorst.ecommerceapi.entity.Item;
import com.lucasbrunkhorst.ecommerceapi.repository.ItemRepository;
import com.lucasbrunkhorst.ecommerceapi.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl extends CrudServiceImpl<Item> implements ItemService {

    private final ItemRepository itemRepository;

    @Override
    public JpaRepository<Item, String> getRepository() {
        return itemRepository;
    }
}
