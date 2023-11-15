package com.ecommerce.domain.ports.in;

import com.ecommerce.domain.model.Product;
import com.ecommerce.domain.model.ProductId;

import java.util.Optional;

public interface ProductRepositoryPort {
    Product findByIdProduct(ProductId productId);
}
