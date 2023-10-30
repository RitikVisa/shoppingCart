package com.example.shoppingCart;
import jakarta.persistence.*;

@Entity
public class Feature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String warranty;
    private String color;
    private String storage;
    private String ram;
    private String description;


    // Constructors, getters, and setters
    public Feature(Long id, String warranty, String color, String storage, String ram, String description) {
        this.id = id;
        this.warranty = warranty;
        this.color = color;
        this.storage = storage;
        this.ram = ram;
        this.description = description;
    }

    public Feature() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


}
