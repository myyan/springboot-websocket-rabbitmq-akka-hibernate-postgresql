package com.example.repository;

import com.example.model.user.Device;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by chenhao on 2016/10/21.
 */
public interface DeviceRepository extends JpaRepository<Device,Long> {
    Device findByname(String name);
}
