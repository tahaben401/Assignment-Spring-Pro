package com.example.microservicespro.controller;


import com.example.microservicespro.dto.ProductDTO;
import com.example.microservicespro.model.Product;
import com.example.microservicespro.service.ProductService;
import com.netflix.appinfo.InstanceInfo;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin("http://127.0.0.1:5500")
@RequiredArgsConstructor
public class ProductController {
    private final DiscoveryClient discoveryClient;
    private final ProductService productService;
    private final RestTemplate restTemplate;
    String url = "http://localhost:8081/api/stock";


    @GetMapping()
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        ServiceInstance serviceInstance=discoveryClient.getInstances("Stock-service").get(0);

        ProductDTO[] products = restTemplate.getForObject(url, ProductDTO[].class);
        return new ResponseEntity<>(Arrays.asList(products),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") long id) {
        return new ResponseEntity<>(productService.getProductById(id),HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.createProduct(product),HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") long id, @RequestBody Product product) {
        return new ResponseEntity<>(productService.updateProduct(id, product),HttpStatus.OK);
    }


}
