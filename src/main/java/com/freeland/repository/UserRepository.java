package com.freeland.repository;

import com.freeland.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by chenhao on 2016/9/13.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByUsernameAndPassword(String username, String password);
}
