package com.example.seachservice.services;



import com.example.seachservice.entities.Movie;

import java.util.List;
import java.util.Optional;

public interface BaseService <E>{
    List<E> findAll() throws Exception;
    Movie findById(Integer id) throws  Exception;
    E save(E entity) throws  Exception;
    E updateOne(E entity, Integer id) throws Exception;
    boolean deleteById(Integer id) throws Exception;
}
