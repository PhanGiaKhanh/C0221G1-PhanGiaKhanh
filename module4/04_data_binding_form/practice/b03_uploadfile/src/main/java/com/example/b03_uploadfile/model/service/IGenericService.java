package com.example.b03_uploadfile.model.service;

import java.util.Optional;

public interface IGenericService<T>{
    Iterable<T> findAll();
    Optional<T> findById(Integer id);
    void save(T t);
    void remove(Integer id);
}
