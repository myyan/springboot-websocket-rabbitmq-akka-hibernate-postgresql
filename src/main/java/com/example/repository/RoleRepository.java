package com.example.repository;

import com.example.model.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by chenhao on 2016/9/19.
 */
public interface RoleRepository extends JpaRepository<Role,Long>{
    Role findByName(String name);
}
