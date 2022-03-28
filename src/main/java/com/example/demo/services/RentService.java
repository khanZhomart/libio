package com.example.demo.services;

import java.util.List;
import java.util.NoSuchElementException;

import com.example.demo.entities.Book;
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
    
    public boolean save(Long userId, Long bookId) {
        User user = this.userRepository.findById(userId).orElse(null);
        Book book = this.bookRepository.findById(bookId).orElse(null);

        if (user == null || book == null)
            throw new NoSuchElementException("Invalid entity id(s)");

        if (user.getBooks().contains(book))
            throw new IllegalArgumentException("Provided book is already assigned to user. " + bookId);

        user.getBooks().add(book);
        return true;
    }

    public boolean remove(Long userId, Long bookId) {
        User user = this.userRepository.findById(userId).orElse(null);
        Book book = this.bookRepository.findById(bookId).orElse(null);

        if (user == null || book == null)
            throw new NoSuchElementException("Invalid entity id(s)");

        if (!user.getBooks().contains(book))
            throw new IllegalArgumentException("Provided book is never assigned to user. " + bookId);

        user.getBooks().remove(book);
        return true;
    }

    public List<Book> findAllBooksByUserId(Long userId) {
        User user = this.userRepository.findById(userId).orElse(null);

        if (user == null)
            throw new NoSuchElementException("User does not exist. " + userId);

        return Lists.newArrayList(  
            user.getBooks()
        );
    }
}
