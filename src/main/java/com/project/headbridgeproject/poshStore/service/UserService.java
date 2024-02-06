package com.project.headbridgeproject.poshStore.service;

import com.project.headbridgeproject.poshStore.entity.UserEntity;
import com.project.headbridgeproject.poshStore.exeption.NotFoundException;
import com.project.headbridgeproject.poshStore.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public UserEntity getOne(final Long id) {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("There is no product with this id "+ id));
    }

    @Transactional
    public UserEntity create(final UserEntity newUser) {
        return userRepository.save(newUser);
    }

    @Transactional
    public UserEntity update(final Long id, final UserEntity updatedUser) {
        UserEntity user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("There is no user with this id "+ id));

        user.setFirstName(updatedUser.getFirstName());
        user.setLastName(updatedUser.getLastName());
        user.setEmail(updatedUser.getEmail());
        user.setPhoneNumber(updatedUser.getPhoneNumber());
        user.setPassword(updatedUser.getPassword());

        return userRepository.save(user);
    }

    @Transactional
    public void delete(final Long id ) {
        userRepository.deleteById(id);
    }

}
