package com.example.model.user;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by chenhao on 2016/9/18.
 */
@Entity
@Table(name = "role")
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "authority")
    private Integer authority;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id")
    private Set<Client> clients = new HashSet<>();

    @Column(name = "name")
    private String name;

    @Column(name = "parent")
    private Integer parent;
}
