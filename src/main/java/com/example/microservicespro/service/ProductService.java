package com.example.microservicespro.service;


import com.example.microservicespro.model.Product;
import com.example.microservicespro.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    final private ProductRepository productRepository;
    public List<Product> getProducts(){
        return productRepository.findAll();
    }
    public Product getProductById(long id) {
        return productRepository.findById(id).orElseThrow();
    }
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
    public Product updateProduct(long id, Product product) {
        Product old_product=getProductById(id);
        old_product.setPrice(product.getPrice());
        return productRepository.save(old_product);
    }
}
