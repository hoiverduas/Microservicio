package com.linktic.products.infrastructure.config;


import com.linktic.products.application.service.ProductService;
import com.linktic.products.domain.gateway.IProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigBean {


    @Bean
    public ProductService productService(IProductRepository productRepository) {
        return new ProductService(productRepository);
    }
}
