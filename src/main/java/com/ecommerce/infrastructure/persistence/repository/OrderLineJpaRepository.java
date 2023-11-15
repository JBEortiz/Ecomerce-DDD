package com.ecommerce.infrastructure.persistence.repository;

import com.ecommerce.infrastructure.persistence.entity.OrderLineEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineJpaRepository extends JpaRepository<OrderLineEntity,Long> {
}
