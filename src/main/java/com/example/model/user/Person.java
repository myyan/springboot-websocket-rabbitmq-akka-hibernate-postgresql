package com.example.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by chenhao on 2016/10/21.
 */
@Entity
@Data
@Table
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Book> books;
}
