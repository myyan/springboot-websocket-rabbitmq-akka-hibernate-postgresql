package com.example.model.user;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by chenhao on 2016/10/21.
 */
@Entity
@Table
@Data
public class KeyBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne
    private Mouse mouse;

}
