package com.example.microservicespro.repository;


import com.example.microservicespro.model.Product;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;
    @Test
    public void testExistsById() {
        Product product = new Product(null,"phone",1000);
        Product created=productRepository.save(product);
        boolean exists=productRepository.existsById(created.getId());
        assertThat(exists).isTrue();
    }























































}
