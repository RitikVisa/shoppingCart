package com.example.shoppingCart.services;

import com.example.shoppingCart.Dtos.UserRequestDto;
import com.example.shoppingCart.models.User;
import com.example.shoppingCart.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;




    public ResponseEntity<UserRequestDto> createUser(@RequestBody UserRequestDto userRequest) {
        User user = new User();
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setMobile(userRequest.getMobile());
        user.setPassword(userRequest.getPassword());

        Optional<User> isEmailPresent = userRepository.findByEmail(user.getEmail());

        isEmailPresent.ifPresent(existingUser -> {
            throw new RuntimeException("User Email Already Present, try to login");
        });

        userRepository.save(user);

        // Return the converted DTO instead of the original userRequest
        UserRequestDto userDto = userToDto(user);
        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }

    public UserRequestDto userToDto(User user){

        UserRequestDto userDto = new UserRequestDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setMobile(user.getMobile());

        return userDto;
    }

    public List<UserRequestDto> getUser() {

        List<User> users = userRepository.findAll();
        if (users.isEmpty()) {
            throw new RuntimeException("Users list not found");
        }
        List<UserRequestDto> userDtoList = new ArrayList<>();

        for (User user : users) {
            UserRequestDto userDto = userToDto(user);
            userDtoList.add(userDto);
        }

        return userDtoList;
    }
}
