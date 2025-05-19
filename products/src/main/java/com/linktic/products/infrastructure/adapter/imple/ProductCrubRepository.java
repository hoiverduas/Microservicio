package com.linktic.products.infrastructure.adapter.imple;

import com.linktic.products.domain.gateway.IProductRepository;
import com.linktic.products.domain.model.Product;
import com.linktic.products.infrastructure.adapter.IProductCrudRepository;
import com.linktic.products.infrastructure.dto.ProductDto;
import com.linktic.products.infrastructure.entities.ProductEntity;
import com.linktic.products.infrastructure.mapper.IProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
@RequiredArgsConstructor
public class ProductCrubRepository implements IProductRepository {


    private final IProductCrudRepository productCrubRepository;
    private final IProductMapper productMapper;

    @Override
    public ProductDto createProduct(Product product) {

        ProductEntity entity = productMapper.toEntity(product);
        ProductEntity savedEntity = productCrubRepository.save(entity);
        Product domain = productMapper.toDomain(savedEntity);

        return productMapper.toDto(domain);
    }

    @Override
    public ProductDto getProductById(Long id) {
        ProductEntity entity = productCrubRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        Product domain = productMapper.toDomain(entity);
        return productMapper.toDto(domain);
    }

    @Override
    public ProductDto updateProduct(Product product, Long productId) {

        Optional<ProductEntity> entity = productCrubRepository.findById(productId);
        if (entity.isPresent()) {
            ProductEntity existingEntity = entity.get();
            existingEntity.setName(product.getName());
            existingEntity.setPrice(product.getPrice());

            ProductEntity savedEntity = productCrubRepository.save(existingEntity);
            Product domain = productMapper.toDomain(savedEntity);
            return productMapper.toDto(domain);
        }else  {
            throw new RuntimeException("Product not found");
        }
    }

    @Override
    public String deleteProduct(Long id) {
        return "";
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return List.of();
    }
}
