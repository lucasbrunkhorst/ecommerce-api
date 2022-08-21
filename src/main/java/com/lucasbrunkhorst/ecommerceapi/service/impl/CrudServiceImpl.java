package com.lucasbrunkhorst.ecommerceapi.service.impl;

import com.lucasbrunkhorst.ecommerceapi.service.CrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.NoResultException;

public abstract class CrudServiceImpl<T> implements CrudService<T> {

    public static final String NO_RESULT_MSG = "Nao encontrado registro com uuid ";

    public abstract JpaRepository<T, String> getRepository();

    @Override
    public T save(T entity) {
        preSave(entity);
        return getRepository().save(entity);
    }

    protected void preSave(T entity) {
    }

    @Override
    public T read(String uuid) {
        return getRepository().findById(uuid)
                .orElseThrow(() -> getNoResultException(uuid));
    }

    @Override
    public void delete(String uuid) {
        if (!getRepository().existsById(uuid)) {
           throw getNoResultException(uuid);
        }
        getRepository().deleteById(uuid);
    }

    @Override
    public Page<T> list(Pageable pageable) {
        return getRepository().findAll(pageable);
    }

    private static NoResultException getNoResultException(String uuid) {
        return new NoResultException(NO_RESULT_MSG + uuid);
    }
}
