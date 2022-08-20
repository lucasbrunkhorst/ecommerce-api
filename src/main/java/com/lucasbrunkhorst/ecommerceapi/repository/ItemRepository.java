package com.lucasbrunkhorst.ecommerceapi.repository;

import com.lucasbrunkhorst.ecommerceapi.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, String> {
}
