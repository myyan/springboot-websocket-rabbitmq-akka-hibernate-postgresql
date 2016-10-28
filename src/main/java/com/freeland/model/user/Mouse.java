package com.freeland.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by chenhao on 2016/10/21.
 */
@Entity
@Data
@Table
public class Mouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne
    @JsonIgnore
    private KeyBoard keyBoard;

}
