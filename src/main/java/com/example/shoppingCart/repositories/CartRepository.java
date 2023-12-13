package com.example.shoppingCart.repositories;

import com.example.shoppingCart.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Integer> {
}
