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
@Table(name = "books")
@ToString
@Builder
@Data
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String title;

    private String description;

    @OneToMany(
        mappedBy = "book",
        fetch = FetchType.LAZY
    )
    @JsonIgnore
    private Collection<Rent> rents;

    public Book(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Book(String title, String description, Collection<Rent> rents) {
        this.title = title;
        this.description = description;
        this.rents = rents;
    }

    public Book(Long id, String title, String description, Collection<Rent> rents) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.rents = rents;
    }
}
