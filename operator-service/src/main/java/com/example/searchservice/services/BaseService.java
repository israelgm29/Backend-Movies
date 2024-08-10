package com.example.searchservice.services;

import com.example.searchservice.model.entities.Rent;

import java.util.List;

public interface BaseService<E> {
    List<E> findAll() throws Exception;
    Rent findById(Integer id) throws  Exception;
    E save(E entity) throws  Exception;
    E updateOne(E entity, Integer id) throws Exception;
    boolean deleteById(Integer id) throws Exception;
}
