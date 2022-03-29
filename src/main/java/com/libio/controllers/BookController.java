package com.libio.controllers;

import com.libio.entities.Book;
import com.libio.services.BookService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/book")
@AllArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("/")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(
            bookService.findAll()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(
            bookService.findById(id)
        );
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Book payload) {
        return ResponseEntity.ok(
            bookService.save(payload)
        );
    }

    @PostMapping("/remove")
    public ResponseEntity<?> removeById(@RequestParam Long id) {
        return ResponseEntity.ok(
            bookService.removeById(id)
        );
    }
}
