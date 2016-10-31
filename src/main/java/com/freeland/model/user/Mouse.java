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


    /**
     * one to one 双向的 不加ignore 序列化的时候出问题
     *
     * 这是测试从 keyboard拿数据的情况
     * 因为  这端维护了keyboard的引用
     * 所以这端 要ignore
     * ingnore是可以的
     * 结果
     * {
     "id": 1,
     "name": "key_board",
     "mouse": {
     "id": 1,
     "name": "mouse"
     }
     }
     * */
    @OneToOne
    @JoinColumn(name = "key_board_id")
//    @JsonIgnore
    private KeyBoard keyBoard;

}
