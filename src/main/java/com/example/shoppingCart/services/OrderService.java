package com.example.shoppingCart.services;

import com.example.shoppingCart.models.Cart;
import com.example.shoppingCart.models.Order;
import com.example.shoppingCart.models.Product;
import com.example.shoppingCart.models.User;
import com.example.shoppingCart.repositories.OrderRepository;
import com.example.shoppingCart.repositories.ProductRepository;
import com.example.shoppingCart.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class OrderService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderRepository orderRepository;


    public OrderService(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public Order getOrderDetail(int orderId) {
        Optional<Order> order = this.orderRepository.findById(orderId);
        return order.isPresent() ? order.get() : null;
    }



    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<Cart> addToCart(int uid,int pid, int quantity) {

        if(userRepository.findById(uid).isPresent() && productRepository.findById(pid).isPresent()){
            User user;
            user = userRepository.findById(uid).get();

            if(user.getOrder()!=null){
                Cart cart = new Cart();
                cart.setProductId(pid);
                cart.setProductName(productRepository.findById(pid).get().getName());
                cart.setQuantity(quantity);
                cart.setAmount(productRepository.findById(pid).get().getPrice());
                List<Cart> cartItems = user.getOrder().getCartItems();
                cartItems.add(cart);

                Order order = user.getOrder();
                order.setCartItems(cartItems);
                user.setOrder(order);
                orderRepository.save(order);
                return order.getCartItems();
            }

            Order order = new Order();

            order.setUser(user);

            Cart cart = new Cart();
            cart.setProductId(pid);
            cart.setQuantity(quantity);
            cart.setAmount(productRepository.findById(pid).get().getPrice());
            List<Cart> cartItems = new ArrayList<>();
            cartItems.add(cart);

            order.setCartItems(cartItems);
            user.setOrder(order);
            orderRepository.save(order);
            return order.getCartItems();

        }else{
            throw new RuntimeException("User Id wrong or Product id wrong");
        }





    }

    public List<Cart> removeItemFromCart(int uid, int pid, int quantity) {

        User user;
        user = userRepository.findById(uid).get();

        if(user.getOrder()==null){
           return null;
        }

        Order order = user.getOrder();
        List<Cart> cartItems  = order.getCartItems();

        for(Cart cart : cartItems){
            if(cart.getProductId() == pid){
                cartItems.remove(cart);
                order.setCartItems(cartItems);
                orderRepository.save(order);
                return order.getCartItems();
            }
        }

        throw new RuntimeException("productId is wrong");
    }

    public List<Order> getOrderList() {

        return orderRepository.findAll();
    }
}
