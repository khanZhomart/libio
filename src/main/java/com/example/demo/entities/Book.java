package com.example.demo.entities;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "books")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Data
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long bookId;

    private String title;
    private String description;

    @ManyToMany(cascade = CascadeType.ALL)
    private Collection<User> renters;
}
