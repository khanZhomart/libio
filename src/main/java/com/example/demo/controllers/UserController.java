package com.example.demo.controllers;

import com.example.demo.entities.User;
import com.example.demo.services.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    @GetMapping("/")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(
            this.userService.findAll()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(
            this.userService.findById(id)
        );
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody User payload) {
        return ResponseEntity.ok(
            this.userService.save(payload)
        );
    }

    @PostMapping("/remove")
    public ResponseEntity<?> removeById(@RequestParam Long id) {
        return ResponseEntity.ok(
            this.userService.removeById(id)
        );
    }

    @PostMapping("/rent")
    public ResponseEntity<?> rent(@RequestParam Long userId, @RequestParam Long bookId) {
        return null;
    }
}
