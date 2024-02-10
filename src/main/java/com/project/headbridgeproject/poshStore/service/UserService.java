package com.project.headbridgeproject.poshStore.service;

import com.project.headbridgeproject.poshStore.dto.UserCreateDto;
import com.project.headbridgeproject.poshStore.dto.UserDto;
import com.project.headbridgeproject.poshStore.entity.UserEntity;
import com.project.headbridgeproject.poshStore.exeption.NotFoundException;
import com.project.headbridgeproject.poshStore.repository.UserRepository;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    /*private final BCryptPasswordEncoder bCryptPasswordEncoder;
    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }*/

    @Transactional(readOnly = true)
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(this::convertUserEntity).toList();
    }

    @Transactional(readOnly = true)
    public UserDto getOne(final Long id) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new NotFoundException("There is no product with this id " + id));
        return convertUserEntity(userEntity);
    }

    @Transactional
    public UserDto create(final UserCreateDto newUser) {
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(newUser.getFirstName());
        userEntity.setLastName(newUser.getLastName());
        userEntity.setEmail(newUser.getEmail());
        //bCryptPasswordEncoder.matches("pass", "db");
        //userEntity.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
        userEntity.setPassword(newUser.getPassword());
        userEntity.setRole(newUser.getRole());
        userEntity.setPhoneNumber(newUser.getPhoneNumber());

        return convertUserEntity(userRepository.save(userEntity));
    }

    @Transactional
    public UserDto update(final Long id, final UserEntity updatedUser) {
        UserEntity user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("There is no user with this id " + id));

        user.setFirstName(updatedUser.getFirstName());
        user.setLastName(updatedUser.getLastName());
        user.setEmail(updatedUser.getEmail());
        user.setPhoneNumber(updatedUser.getPhoneNumber());
        user.setPassword(updatedUser.getPassword());

        return convertUserEntity(userRepository.save(user));
    }

    @Transactional
    public void delete(final Long id) {
        userRepository.deleteById(id);
    }

    private UserDto convertUserEntity(UserEntity entity) {
        UserDto userDto = new UserDto();
        userDto.setId(entity.getId());
        userDto.setFirstName(entity.getFirstName());
        userDto.setLastName(entity.getLastName());
        userDto.setEmail(entity.getEmail());
        userDto.setRole(entity.getRole());

        return userDto;
    }

}
