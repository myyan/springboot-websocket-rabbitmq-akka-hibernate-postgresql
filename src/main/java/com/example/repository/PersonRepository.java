package com.example.repository;

import com.example.model.user.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by chenhao on 2016/10/21.
 */

public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByusername(String name);
}
