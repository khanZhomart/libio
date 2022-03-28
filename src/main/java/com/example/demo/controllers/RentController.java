package com.example.demo.controllers;

import com.example.demo.services.RentService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/rent")
@AllArgsConstructor
public class RentController {
    private final RentService rentService;

    @GetMapping("/")
    public ResponseEntity<?> findAllBooks() {
        return null;   
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestParam Long userId, @RequestParam Long bookId) {
        return ResponseEntity.ok(
            this.rentService.save(userId, bookId)
        );
    }
}
