package com.example.demo.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "users")
@ToString
@Builder
@Data
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String username;

    private String password;

    @OneToMany(
        mappedBy = "user",
        fetch = FetchType.LAZY
    )
    @JsonIgnore
    private Collection<Rent> rents;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, Collection<Rent> rents) {
        this.username = username;
        this.password = password;
        this.rents = rents;
    }

    public User(Long id, String username, String password, Collection<Rent> rents) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.rents = rents;
    }
}
