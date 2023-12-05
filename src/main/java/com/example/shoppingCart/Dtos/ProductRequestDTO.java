package com.example.shoppingCart.Dtos;

import com.example.shoppingCart.models.Feature;

public class ProductRequestDTO {
    private String name;
    private double price;
    private double rating;
    private String imageUrl;
    private String details;

    // Feature attributes
    private String warranty;
    private String color;
    private String storage;
    private String ram;
    private String description;
    private Feature feature;

    // Constructors, getters, and setters

    // Default constructor
    public ProductRequestDTO() {
    }

    public ProductRequestDTO(String name, double price, double rating, String imageUrl, String details,Feature feature) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.imageUrl = imageUrl;
        this.details = details;
        this.feature = feature;

    }

    // Getters and setters for the fields

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
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

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Feature getFeature() {
       return this.feature;
    }
}
