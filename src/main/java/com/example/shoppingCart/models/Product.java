package com.example.shoppingCart.models;


import jakarta.persistence.*;




@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private int price;
    private double rating;
    private String imageUrl;
    private String details;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "feature_id")
    private Feature feature; // One-to-one relationship with Feature

//    @ManyToOne
//    @JoinColumn(name = "cart_id")
//    Cart cart;
//
//    @JsonBackReference
//    public Cart getCart() {
//        return cart;
//    }

//    public void setCart(Cart cart) {
//        this.cart = cart;
//    }

    // Default constructor
    public Product() {
    }

    public Product(String name, int price, double rating, String imageUrl, String details, Feature feature) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.imageUrl = imageUrl;
        this.details = details;
        this.feature = feature;
    }

    // Getters and setters for the fields

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Feature getFeature() {
        return feature;
    }

    public void setFeature(Feature feature) {
        this.feature = feature;
    }



    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                ", imageUrl='" + imageUrl + '\'' +
                ", details='" + details + '\'' +
                ", feature=" + feature +

                '}';
    }
}



