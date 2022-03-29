package com.libio.repositories;

import com.libio.entities.Rent;
import com.libio.entities.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentRepository extends CrudRepository<Rent, Long> {
    Iterable<Rent> findAllByUser(User renter);
}
