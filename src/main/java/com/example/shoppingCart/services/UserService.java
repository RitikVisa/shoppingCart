package com.example.shoppingCart.services;

import com.example.shoppingCart.Dtos.UserRequestDto;
import com.example.shoppingCart.models.User;
import com.example.shoppingCart.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;




    public ResponseEntity<UserRequestDto> createUser(@RequestBody User userRequest) {
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

    public ResponseEntity<UserRequestDto> deleteUser(Integer id) {
        // Check if the provided user ID is not null
        if (id == null || id < 0) {
            return ResponseEntity.badRequest().build();
        }

        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            UserRequestDto userRequestDto = userToDto(user);

            userRepository.deleteById(id);
            return new ResponseEntity<>(userRequestDto, HttpStatus.OK);
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Provided UserId Not Found");
    }



    public ResponseEntity<UserRequestDto> updateUser( Integer id, User user) {
        // Check if the provided user object is not null
        if (user == null) {
            return ResponseEntity.badRequest().build();
        }
        //check if the user is present or not
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()){
            User updatedUser = userOptional.get();
            updatedUser.setName(user.getName());
            updatedUser.setEmail(user.getEmail());
            updatedUser.setMobile(user.getMobile());
            updatedUser.setPassword(user.getPassword());

            userRepository.save(updatedUser);
            return new ResponseEntity<>(userToDto(updatedUser),HttpStatus.OK);
        }

        throw new RuntimeException("Given User Id Is Wrong Or User Not Present");
    }
    public UserRequestDto userToDto(User user){

        UserRequestDto userDto = new UserRequestDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setMobile(user.getMobile());

        return userDto;
    }


}
