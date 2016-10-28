package com.freeland.repository;

import com.freeland.model.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by chenhao on 2016/9/19.
 */
public interface RoleRepository extends JpaRepository<Role,Long>{
    Role findByName(String name);
}
