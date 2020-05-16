package com.innova.et.common.service;

import java.io.Serializable;
import java.util.List;

public interface GenericService<T, ID extends Serializable> {
    T create(T item);

    T findById(ID id);

    List<T> findAll();

    T update(ID id, T item);

    void remove(ID id);

    void remove(T item);

    void remove();
}
