package com.libio.services;

import java.util.List;
import java.util.NoSuchElementException;

import com.google.common.collect.Lists;
import com.libio.entities.User;
import com.libio.repositories.UserRepository;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService implements Servable<User> {
    private final UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return Lists.newArrayList(
            userRepository.findAll()
        );
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User save(User payload) {
        if (userRepository.existsByUsername(payload.getUsername()))
            throw new IllegalArgumentException("Username {" + payload.getUsername() + "} is already reserved.");
        
        if (payload.getPassword() == null || payload.getUsername() == null)
            throw new IllegalArgumentException("Invalid fields.");

        return userRepository.save(payload);
    }

    @Override
    public boolean removeById(Long id) {
        if (!userRepository.existsById(id))
            throw new NoSuchElementException("Invalid user was provided. " + id);

        userRepository.deleteById(id);
        return true;
    }
    
}
