package com.pedidos.androidapp.service;

import java.util.List;

public interface ICRUD<T> {

    List<T> getAll();
    T findById(Long id);
    T register(T obj);
    T modify(T obj);
    boolean delete(Long id);
}
