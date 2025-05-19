package com.linktic.products.infrastructure.adapter;

import com.linktic.products.domain.model.Product;
import com.linktic.products.infrastructure.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductCrudRepository extends JpaRepository<ProductEntity,Long> {
}
