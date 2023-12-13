package com.example.shoppingCart.Dtos;

import com.example.shoppingCart.models.Cart;
import com.example.shoppingCart.models.User;

import java.util.Optional;

public class UserRequestDto {

    public UserRequestDto() {
    }

    private Integer id;
    private String name;

    private String email;
    private String mobile;

    private String password ;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRequestDto(Optional<User> user) {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }









    public UserRequestDto(Integer id, String name, String email, String mobile) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobile = mobile;


    }
    public UserRequestDto(String name, String email, String mobile,String password) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


}
