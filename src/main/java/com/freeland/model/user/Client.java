package com.freeland.model.user;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

/**
 * Created by chenhao on 2016/9/18.
 */
@Entity
@Table(name = "client")
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",columnDefinition = "TEXT")
    private String name;

    @Column
    LocalDate date;

    @Column(name = "usage",columnDefinition = "Decimal(5,2)")
    private Double usage;

    private Date datee;

    private String[]arr;



}
