package com.example.shoppingCart.controllers;

import com.example.shoppingCart.Dtos.UserRequestDto;
import com.example.shoppingCart.models.User;

import com.example.shoppingCart.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class userController {

    @Autowired
    UserService userService;
    @PostMapping
    public ResponseEntity<UserRequestDto> createUser(@RequestBody User userRequest) {

        return userService.createUser(userRequest);
    }

    @GetMapping
    public List<UserRequestDto> getUser() {
        return userService.getUser();
    }

    @DeleteMapping
    public ResponseEntity<UserRequestDto> deleteUser(@RequestParam(name = "id") Integer id){
        return userService.deleteUser(id);
    }

    @PutMapping
    public ResponseEntity<UserRequestDto> updateUser(@RequestParam(name = "id") Integer id, @RequestBody User user){
        return userService.updateUser(id,user);
    }


}