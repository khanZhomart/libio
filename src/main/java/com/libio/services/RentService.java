package com.libio.services;

import java.util.List;
import java.util.NoSuchElementException;

import com.google.common.collect.Lists;
import com.libio.entities.Book;
import com.libio.entities.Rent;
import com.libio.entities.User;
import com.libio.repositories.*;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RentService {
    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final RentRepository rentRepository;
    
    public List<Rent> findAllByUserId(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        
        if (user == null)
            throw new NoSuchElementException("User does not exist." + userId);

        return Lists.newArrayList(
            rentRepository.findAllByUser(user)
        );
    }

    public List<Rent> findAll() {
        return Lists.newArrayList(
            rentRepository.findAll()
        );
    }

    public Rent save(Long userId, Long bookId) {
        User user = userRepository.findById(userId).orElse(null);
        Book book = bookRepository.findById(bookId).orElse(null);

        if (user == null || book == null)
            throw new NoSuchElementException("Invalid entity id(s)");

        Rent rent = Rent.builder()
            .user(user)
            .book(book)
            .build();

        return rentRepository.save(rent);
    }

    public boolean remove(Long userId, Long bookId) {
        return false;
    }
}
