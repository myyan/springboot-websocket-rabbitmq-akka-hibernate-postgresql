package com.example.repository;

import com.example.model.user.KeyBoard;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by chenhao on 2016/10/21.
 */
public interface KeyBoardRepository extends JpaRepository<KeyBoard, Long> {
    KeyBoard findByname(String name);
}
