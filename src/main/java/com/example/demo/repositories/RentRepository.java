package com.example.demo.repositories;

import com.example.demo.entities.Rent;
import com.example.demo.entities.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentRepository extends CrudRepository<Rent, Long> {
    Iterable<Rent> findAllByUser(User renter);
}
