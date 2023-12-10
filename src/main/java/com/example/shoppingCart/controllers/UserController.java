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
public class UserController {

    @Autowired
    UserService userService;
    @PostMapping
    public ResponseEntity<UserRequestDto> createUser(@RequestBody User userRequest) {

        return userService.createUser(userRequest);
    }

    @GetMapping
    public ResponseEntity<List<UserRequestDto>> getAllUsers() {
        List<UserRequestDto> users = userService.getUser();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<UserRequestDto> deleteUser(@RequestParam(name = "id") Integer id){
        return userService.deleteUser(id);
    }

    @PutMapping
    public ResponseEntity<UserRequestDto> updateUser(@RequestParam(name = "id") Integer id, @RequestBody User user){
        return userService.updateUser(id,user);
    }

    @GetMapping("/addToCart")
    public ResponseEntity<Integer> addToCart(
            @RequestParam(name = "pid") Long productId,
            @RequestParam(name = "uid") Integer userID) {
        Integer result = userService.addToCart(productId, userID);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


}