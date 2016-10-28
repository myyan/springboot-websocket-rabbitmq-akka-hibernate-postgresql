package com.freeland.repository;

import com.freeland.model.user.Haozi;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by chenhao on 2016/10/19.
 */
public interface HaoziRepository extends JpaRepository<Haozi,String>{
    Haozi findByDeviceId(String deviceId);
}
