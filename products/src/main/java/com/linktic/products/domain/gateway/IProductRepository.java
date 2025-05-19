package com.linktic.products.domain.gateway;

import com.linktic.products.domain.model.Product;
import com.linktic.products.infrastructure.dto.ProductDto;

import java.util.List;

public interface IProductRepository {

    ProductDto createProduct(Product product);
    ProductDto getProductById(Long id);
    ProductDto updateProduct(Product product , Long productId);
    void deleteProduct(Long id);
    List<ProductDto> getAllProducts();

}
