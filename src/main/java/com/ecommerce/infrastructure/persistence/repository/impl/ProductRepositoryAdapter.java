package com.ecommerce.infrastructure.persistence.repository.impl;

import com.ecommerce.domain.model.Product;
import com.ecommerce.domain.model.ProductId;
import com.ecommerce.domain.ports.in.ProductRepositoryPort;
import com.ecommerce.infrastructure.persistence.entity.ProductEntity;
import com.ecommerce.infrastructure.persistence.repository.ProductJpaReposiroty;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class ProductRepositoryAdapter implements ProductRepositoryPort {
    private final ProductJpaReposiroty productJpaReposiroty;

    @Override
    public Product findByIdProduct(ProductId productId) {
        ProductEntity productEntity = productJpaReposiroty.findById(productId.getValue())
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado: " + productId));

        return Product.builder().id(new ProductId(productEntity.getId())).name(productEntity.getName()).price(productEntity.getPrice()).build();

    }
}
