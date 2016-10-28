package com.freeland.repository;

import com.freeland.model.user.KeyBoard;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by chenhao on 2016/10/21.
 */
public interface KeyBoardRepository extends JpaRepository<KeyBoard, Long> {
    KeyBoard findByname(String name);
}
