package com.travelcompany.eshop.repository;

import java.util.List;
import java.util.Set;

public interface JpaRepository<T> {
    T create(final T entity);

    void update(T entity);

    void delete(T entity);

    T getById(Long id);

    List<T> findAll();


}
