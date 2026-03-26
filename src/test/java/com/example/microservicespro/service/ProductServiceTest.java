package com.example.microservicespro.service;


import com.example.microservicespro.model.Product;
import com.example.microservicespro.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private ProductService productService;
    @Test
    void getAllProducts() {
        Product product1 = new Product(null,"phone1",1000);
        Product product2 = new Product(null,"phone2",1000);
        given(productRepository.findAll()).willReturn(Arrays.asList(product1,product2));
        List<Product> productList = productService.getProducts();
        assertThat(productList).isNotNull();
        assertThat(productList.size()).isEqualTo(2);
        verify(productRepository).findAll();
     }
}
