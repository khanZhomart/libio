package com.example.demo.entities;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Data
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long userId;

    private String username;

    @JsonIgnore
    private String password;

    @ManyToMany(
        mappedBy = "renters",
        cascade = CascadeType.ALL
    )
    @JsonManagedReference(value = "user-books")
    private Collection<Book> books;
}
