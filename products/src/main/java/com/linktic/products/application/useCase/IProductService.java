package com.linktic.products.application.useCase;

import com.linktic.products.domain.model.Product;
import com.linktic.products.infrastructure.dto.ProductDto;

import java.util.List;

public interface IProductService {

    ProductDto createProduct(Product product);
    ProductDto getProductById(Long id);
    ProductDto updateProduct(Product product, Long productId);
    String deleteProduct(Long id);
    List<Product> getAllProducts();

}
