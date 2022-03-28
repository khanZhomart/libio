package com.example.demo.services;

import java.util.List;

public interface Servable<T> {
    
    List<T> findAll();
    T findById(Long id);
    T save(T payload);
    boolean removeById(Long id);
}
