package com.linktic.products.application.service;

import com.linktic.products.application.useCase.IProductService;
import com.linktic.products.domain.gateway.IProductRepository;
import com.linktic.products.domain.model.Product;
import com.linktic.products.infrastructure.dto.ProductDto;

import java.util.List;


public class ProductService implements IProductService {


  private final IProductRepository productRepository;

    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto createProduct(Product product) {
        return this.productRepository.createProduct(product);

    }

    @Override
    public ProductDto getProductById(Long id) {
        return this.productRepository.getProductById(id);
    }

    @Override
    public ProductDto updateProduct(Product product, Long productId) {
        return productRepository.updateProduct(product, productId);
    }

    @Override
    public String deleteProduct(Long id) {
        productRepository.deleteProduct(id);
        return "product deleted successfully" + id;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }
}
