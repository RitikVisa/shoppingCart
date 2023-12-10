package com.example.shoppingCart.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "\"cart\"")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<Product> productList;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    // ... constructors, getters, setters ...

    public Cart() {
        this.productList = new ArrayList<>();
    }

    public void addProduct(Product product) {
        productList.add(product);
        product.setCart(this);
    }

    public void setUser(User user) {
        this.user = user;
        user.setCart(this);
    }

    public List<Product> getProductList() {
        return productList;
    }

}
