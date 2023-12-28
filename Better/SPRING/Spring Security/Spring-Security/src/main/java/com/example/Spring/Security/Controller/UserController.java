package com.example.Spring.Security.Controller;


import com.example.Spring.Security.DTO.UserDTO;
import com.example.Spring.Security.Entites.UserEntity;
import com.example.Spring.Security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity<List<?>> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/")
    public UserEntity saveUser(@RequestBody UserDTO userDTO){
        return userService.saveUser(userDTO);
    }
}
