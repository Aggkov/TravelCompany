package com.travelcompany.eshop.repository;

import com.travelcompany.eshop.exception.ResourceNotFoundException;
import com.travelcompany.eshop.model.BaseEntity;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public abstract class AbstractRepository <T extends BaseEntity> implements JpaRepository<T> {

    protected T entity;

    protected abstract Set<T> getEntitySet();
    protected abstract List<T> getEntityList();

    @Override
    public T create(T entity) {
        getEntitySet().add(entity);
        return entity;
    }

    @Override
    public void update(T entity) {
        getEntitySet().add(entity);
    }

    @Override
    public void delete(T entity) {
        getEntitySet().remove(entity);
    }

    @Override
    public T getById(Long id) {

        T foundEntity = getEntitySet().stream()
                .filter(T -> Objects.equals(T.getId(), id))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException(entity.getClass() + " with this Id was not found"));

        return foundEntity;
    }

    @Override
    public List<T> findAll() {
        return getEntityList();
    }

    public T getEntity() {
        return entity;
    }
}
