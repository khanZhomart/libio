package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "rents")
@ToString
@Builder
@Data
public class Rent {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(
        name = "user_id",
        nullable = false
    )
    private User user;

    @ManyToOne
    @JoinColumn(
        name = "book_id",
        nullable = false
    )
    private Book book;

    public Rent(User user, Book book) {
        this.user = user;
        this.book = book;
    }

    public Rent(Long id, User user, Book book) {
        this.id = id;
        this.user = user;
        this.book = book;
    }
}
