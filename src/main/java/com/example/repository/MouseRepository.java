package com.example.repository;

import com.example.model.user.Mouse;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by chenhao on 2016/10/21.
 */
public interface MouseRepository extends JpaRepository<Mouse,Long> {
    Mouse findByname(String name);
}
