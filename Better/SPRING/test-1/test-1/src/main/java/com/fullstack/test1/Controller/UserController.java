package com.fullstack.test1.Controller;


import com.fullstack.test1.Entity.User;
import com.fullstack.test1.Entity.UserLogin;
import com.fullstack.test1.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers(){
        return userService.getAllUsers();
    }


    @PostMapping("/save")
    public ResponseEntity<?> saveUser(@RequestBody User user){
        return  userService.saveUser(user);
    }

    @PostMapping("/userLogin")

    public  ResponseEntity<?> userLogin(@RequestBody UserLogin userLogin){
        return  userService.userLogin(userLogin);
    }
}
