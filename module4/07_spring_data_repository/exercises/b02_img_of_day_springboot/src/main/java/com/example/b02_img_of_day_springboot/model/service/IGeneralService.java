package com.example.b02_img_of_day_springboot.model.service;

import java.util.List;
import java.util.Optional;


public interface IGeneralService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    void save(T t);

    void remove(Long id);

    void like(Long id);
}