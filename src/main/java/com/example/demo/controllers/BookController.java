package com.example.demo.controllers;

import com.example.demo.entities.Book;
import com.example.demo.services.BookService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/book")
@AllArgsConstructor
public class BookController {
    private BookService bookService;

    @GetMapping("/")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(
            this.bookService.findAll()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(
            this.bookService.findById(id)
        );
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Book payload) {
        return ResponseEntity.ok(
            this.bookService.save(payload)
        );
    }

    @PostMapping("/remove")
    public ResponseEntity<?> removeById(@RequestParam Long id) {
        return ResponseEntity.ok(
            this.bookService.removeById(id)
        );
    }
}