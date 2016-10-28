package com.freeland.repository;

import com.freeland.model.user.App;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by chenhao on 2016/10/21.
 */
public interface AppRepository extends JpaRepository<App, Long> {
    App findByname(String name);
}
