package com.libio.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "book")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Data
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    private String title;

    private String author;

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

    public Book(String title, String author, String description, Collection<Rent> rents) {
        this.title = title;
        this.description = description;
        this.rents = rents;
    }
}
