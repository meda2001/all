package com.fullstack.test1.Service;


import com.fullstack.test1.Dto.UserDto;
import com.fullstack.test1.Entity.User;
import com.fullstack.test1.Entity.UserLogin;
import com.fullstack.test1.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;


    public ResponseEntity<List<User>> getAllUsers() {
        try {
            return new ResponseEntity<>(userRepo.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<?> saveUser(User user) {
        try {
            Optional<User> userCheck = userRepo.findByEmail(user.getEmail());
            if (userCheck.isPresent() ) {
                return new ResponseEntity<>("User Already exsists",HttpStatus.NOT_ACCEPTABLE);


            }
            else {
                UserDto userDto = UserDto.builder().Email(user.getEmail()).build();
                userRepo.save(user);

                return new ResponseEntity<>(userDto, HttpStatus.CREATED);

            }



        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("user not added",HttpStatus.NOT_ACCEPTABLE);
    }

    public ResponseEntity<?> userLogin(UserLogin userLogin) {

        try {
            Optional<User> user = userRepo.findOneByEmailAndPassword(userLogin.getEmail(),userLogin.getPassword());

            if (user.isPresent()){
                if (user.get().getPassword().equals(userLogin.getPassword()) && user.get().getEmail().equalsIgnoreCase(userLogin.getEmail())){
                    return new ResponseEntity<>("user login Succesfully" ,HttpStatus.OK);
                }



            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return  new ResponseEntity<>("Please Re-check with email and password",HttpStatus.BAD_REQUEST);
    }
}
