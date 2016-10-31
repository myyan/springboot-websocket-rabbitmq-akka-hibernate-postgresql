package com.freeland.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    /**
     * 此端不是主控端
     * 但是此端维护了主控端的引用
     * Ignore掉
     *
     * 然后在主控端里面不加Ignore  发现是可以的
     * 没有出现异常
     *
     * result:
     *
     * {
     "id": 1,
     "name": "mouse",
     "keyBoard": {
     "id": 1,
     "name": "key_board"
     }
     }
     * */
//    @OneToOne(mappedBy = "keyBoard")
//    @JsonIgnore
//    private Mouse mouse;

    @OneToOne(mappedBy = "keyBoard")
    @JsonIgnore
    private Mouse mouse;

}
