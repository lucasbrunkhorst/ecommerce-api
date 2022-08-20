package com.lucasbrunkhorst.ecommerceapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CrudService<T> {

    T save(T entity);

    T read(String uuid);

    void delete(String uuid);

    Page<T> list(Pageable pageable);

}
