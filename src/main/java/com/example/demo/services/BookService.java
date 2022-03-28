package com.example.demo.services;

import java.util.List;
import java.util.NoSuchElementException;

import com.example.demo.entities.Book;
import com.example.demo.repositories.BookRepository;
import com.google.common.collect.Lists;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookService implements Servable<Book> {
    private final BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return Lists.newArrayList(
            this.bookRepository.findAll()
        );
    }

    @Override
    public Book findById(Long id) {
        return this.bookRepository.findById(id).orElse(null);
    }

    @Override
    public Book save(Book payload) {
        return this.bookRepository.save(payload);
    }

    @Override
    public boolean removeById(Long id) {
        if (!this.bookRepository.existsById(id))
            throw new NoSuchElementException("Invalid book was provided. " + id);

        this.bookRepository.deleteById(id);
        return true;
    }
    
}