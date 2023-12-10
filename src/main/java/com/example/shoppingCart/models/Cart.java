package com.example.shoppingCart.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "\"cart\"")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<Product> productList;

    @OneToOne(mappedBy = "cart")
    private User user;

    public Cart() {
        // default constructor
    }

    public Cart(List<Product> productList, User user) {
        this.productList = productList;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
