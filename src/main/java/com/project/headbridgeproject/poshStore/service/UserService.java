package com.project.headbridgeproject.poshStore.service;

import com.project.headbridgeproject.poshStore.entity.UserEntity;
import com.project.headbridgeproject.poshStore.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /*
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }*/
}
