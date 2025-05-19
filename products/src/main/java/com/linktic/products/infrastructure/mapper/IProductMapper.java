package com.linktic.products.infrastructure.mapper;


import com.linktic.products.domain.model.Product;
import com.linktic.products.infrastructure.dto.ProductDto;
import com.linktic.products.infrastructure.entities.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface IProductMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "price", target = "price")
    })

    ProductEntity toEntity(Product product);

    Product toDomain(ProductEntity entity);

    ProductDto toDto(Product product);

    Product toDomain(ProductDto dto);

}
