package com.example.model.user;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by chenhao on 2016/9/13.
 */
@Entity
@Data
@Table(name = "user_info")
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "roleId")
    private Role roleId;

    @Column(name = "salt")
    private String salt="sadkj2340900-23ksdf";


}
