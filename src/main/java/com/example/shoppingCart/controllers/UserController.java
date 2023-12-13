package com.example.shoppingCart.controllers;

import com.example.shoppingCart.Dtos.UserRequestDto;
import com.example.shoppingCart.models.Cart;
import com.example.shoppingCart.models.Order;
import com.example.shoppingCart.models.User;

import com.example.shoppingCart.services.OrderService;
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

    @Autowired
    OrderService orderService;
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

    @PostMapping("/addtocart")
    public List<Cart> addToCart(@RequestParam(name = "uid") int uid, @RequestParam(name = "pid") int pid, @RequestParam(name = "quantity") int quantity){
        return orderService.addToCart(uid,pid,quantity);
    }

    @DeleteMapping("/removeItem")
    public List<Cart> removeItemFromCart(@RequestParam(name = "uid") int uid, @RequestParam(name = "pid") int pid, @RequestParam(name = "quantity") int quantity){
        return orderService.removeItemFromCart(uid,pid,quantity);
    }

    @GetMapping("/orders")
    public List<Order> getOrderList(){
        return orderService.getOrderList();
    }

}