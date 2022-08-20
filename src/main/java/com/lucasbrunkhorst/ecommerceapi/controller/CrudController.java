package com.lucasbrunkhorst.ecommerceapi.controller;

import com.lucasbrunkhorst.ecommerceapi.entity.Item;
import com.lucasbrunkhorst.ecommerceapi.service.CrudService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.ParameterizedType;

@Component
public abstract class CrudController<T, X> {

    private final Class<T> persistentClass;

    @Autowired
    private ModelMapper modelMapper;

    public CrudController() {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public abstract CrudService<T> getService();

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public T create(@Valid @RequestBody X request) {
        T entity = modelMapper.map(request, persistentClass);
        return getService().save(entity);
    }

    @GetMapping("{uuid}")
    public T read(@PathVariable("uuid") String uuid) {
        return getService().read(uuid);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("{uuid}")
    public T update(@PathVariable("uuid") String uuid, @Valid @RequestBody X request) {
        T entity = getService().read(uuid);
        modelMapper.map(request, entity);
        return getService().save(entity);

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{uuid}")
    public void delete(@PathVariable("uuid") String uuid) {
        getService().delete(uuid);
    }

    @GetMapping
    public Page<T> list(Pageable pageable) {
        return getService().list(pageable);
    }

}
