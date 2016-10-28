package com.freeland.service;


import com.freeland.model.user.User;
import com.freeland.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by chenhao on 2016/9/14.
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public boolean verify(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username,password);
        if (user==null){
            return false;
        }
        return true;
    }

    @Transactional
    public Integer getAuthorityByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return 0;
    }

    public User getUserByUsernameAndPassword(String username,String password){
        return userRepository.findByUsernameAndPassword(username,password);
    }
}
