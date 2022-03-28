package com.example.demo.services;

import java.util.List;
import java.util.NoSuchElementException;

import com.example.demo.entities.Book;
import com.example.demo.entities.Rent;
import com.example.demo.entities.User;
import com.example.demo.repositories.*;
import com.google.common.collect.Lists;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RentService {
    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final RentRepository rentRepository;
    
    public List<Rent> findAllByUserId(Long userId) {
        User user = this.userRepository.findById(userId).orElse(null);
        
        if (user == null)
            throw new NoSuchElementException("User does not exist." + userId);

        return Lists.newArrayList(
            this.rentRepository.findAllByUser(user)
        );
    }

    public List<Rent> findAll() {
        return Lists.newArrayList(
            this.rentRepository.findAll()
        );
    }

    public Rent save(Long userId, Long bookId) {
        User user = this.userRepository.findById(userId).orElse(null);
        Book book = this.bookRepository.findById(bookId).orElse(null);

        if (user == null || book == null)
            throw new NoSuchElementException("Invalid entity id(s)");

        Rent rent = Rent.builder()
            .user(user)
            .book(book)
            .build();

        return this.rentRepository.save(rent);
    }

    public boolean remove(Long userId, Long bookId) {
        return false;
    }
}
