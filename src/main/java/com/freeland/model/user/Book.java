package com.freeland.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by chenhao on 2016/10/21.
 */
@Entity
@Table
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bookname;

    @ManyToMany
    @JsonIgnore
    private Set<Person> persons;


}
