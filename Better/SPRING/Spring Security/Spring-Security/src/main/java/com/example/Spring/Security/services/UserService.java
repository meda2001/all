package com.example.Spring.Security.services;


import com.example.Spring.Security.Config.SecurityConfig;
import com.example.Spring.Security.DTO.UserDTO;
import com.example.Spring.Security.Entites.UserEntity;
import com.example.Spring.Security.repo.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SecurityConfig securityConfig;


    public ResponseEntity<List<?>> getAllUsers() {
        return new ResponseEntity<>(userRepository.findAll(),HttpStatus.OK);
    }

    public UserEntity saveUser(UserDTO userDTO) {

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userDTO,userEntity);

        userEntity.setPassword(securityConfig.checkPassword().encode(userDTO.getPassword()));


        userRepository.save(userEntity);
        return userEntity;


    }
}
