package com.libio.controllers;

import com.libio.services.RentService;

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

    @GetMapping
    public ResponseEntity<?> findAllBooksByUserId(@RequestParam Long userId) {
        return ResponseEntity.ok(
            rentService.findAllByUserId(userId)
        );
    }

    @GetMapping("/")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(
            rentService.findAll()
        );
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestParam Long userId, @RequestParam Long bookId) {
        return ResponseEntity.ok(
            rentService.save(userId, bookId)
        );
    }

    @PostMapping("/remove")
    public ResponseEntity<?> remove(@RequestParam Long userId, @RequestParam Long bookId) {
        return ResponseEntity.ok(
            null
        );
    }
}
