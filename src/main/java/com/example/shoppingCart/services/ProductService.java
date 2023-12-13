package com.example.shoppingCart.services;
import com.example.shoppingCart.Dtos.ProductRequestDTO;
import com.example.shoppingCart.models.Feature;
import com.example.shoppingCart.models.Product;
import com.example.shoppingCart.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(ProductRequestDTO productRequest) {
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setPrice((int) productRequest.getPrice());
        product.setDetails(productRequest.getDetails());
        product.setImageUrl(productRequest.getImageUrl());
        product.setDetails(productRequest.getDetails());
        // Set other product attributes
        if (productRequest.getFeature() != null) {
            Feature feature = new Feature();
            feature.setWarranty(productRequest.getFeature().getWarranty());
            feature.setColor(productRequest.getFeature().getColor());
            feature.setRam(productRequest.getFeature().getRam());
            feature.setStorage(productRequest.getFeature().getStorage());
            feature.setDescription(productRequest.getFeature().getDescription());
            // Set other feature attributes
            product.setFeature(feature);
        }
        return productRepository.save(product);
    }



    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product updateProduct(int id, ProductRequestDTO updatedProduct) {
        Product existingProduct = getProductById(id);
        if (existingProduct == null) {
            return null; // Product not found
        }
        // Update existingProduct with data from updatedProduct
        existingProduct.setName(updatedProduct.getName());
        existingProduct.setPrice(updatedProduct.getPrice());
        existingProduct.setRating(updatedProduct.getRating());
        existingProduct.setImageUrl(updatedProduct.getImageUrl());
        existingProduct.setDetails(updatedProduct.getDetails());
        if (updatedProduct.getFeature() != null) {
            Feature feature = new Feature();
            feature.setWarranty(updatedProduct.getFeature().getWarranty());
            feature.setColor(updatedProduct.getFeature().getColor());
            feature.setRam(updatedProduct.getFeature().getRam());
            feature.setStorage(updatedProduct.getFeature().getStorage());
            feature.setDescription(updatedProduct.getFeature().getDescription());
            // Set other feature attributes
            existingProduct.setFeature(feature);
        }
        return productRepository.save(existingProduct);
    }

    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }
}
