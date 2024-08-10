package com.example.searchservice.services;

import com.example.searchservice.model.dtos.MovieDTO;
import com.example.searchservice.model.entities.Rent;
import com.example.searchservice.repositories.RentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RentService implements BaseService<Rent> {

    @Autowired
    private RentRepository rentRepository;




    @Override
    public List<Rent> findAll() throws Exception {
        return this.rentRepository.findAll();
    }

    @Override
    public Rent findById(Integer id) throws Exception {
        Optional<Rent> rent = this.rentRepository.findById(id);
        return rent.get();
    }

    @Override
    public Rent save(Rent entity) throws Exception {
        Rent rent = this.rentRepository.save(entity);
        return rent;
    }

    @Override
    public Rent updateOne(Rent entity, Integer id) throws Exception {
        Optional<Rent> Rent = this.rentRepository.findById(id);
        Rent rentUpdate = Rent.get();
        rentUpdate = this.rentRepository.save(rentUpdate);
        return rentUpdate;
    }

    @Override
    public boolean deleteById(Integer id) throws Exception {
        this.rentRepository.deleteById(id);
        return true;
    }
}
