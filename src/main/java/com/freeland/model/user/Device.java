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
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "device")
//    @JsonIgnore
    private Set<App> apps;
}
