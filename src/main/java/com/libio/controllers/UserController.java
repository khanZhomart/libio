package com.libio.controllers;

import com.libio.entities.User;
import com.libio.services.UserService;

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
@RequestMapping("/api/user")
@AllArgsConstructor
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
