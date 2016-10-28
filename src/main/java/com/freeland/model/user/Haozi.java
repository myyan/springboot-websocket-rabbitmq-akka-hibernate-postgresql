package com.freeland.model.user;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by chenhao on 2016/10/9.
 */



@Data
@Entity
@Table
public class Haozi {

    @Id
    @Column(name = "device_id")
    private String deviceId;


}
