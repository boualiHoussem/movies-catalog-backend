package com.hbo.movies.services;

import java.util.List;

/**
 * @author Houssem BOUALI
 * date: 24/12/2021
 */
public interface GenericService<T> {

    void saveOrUpdate(T object);

    void deleteById(Long id);

    T findById(Long id);

    List<T> findAll();
}
