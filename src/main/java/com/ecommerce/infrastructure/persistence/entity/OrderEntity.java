package com.ecommerce.infrastructure.persistence.entity;

import com.ecommerce.domain.model.OrderStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@Builder
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_id")
    private Long customerId;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderLineEntity> orderLines;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private OrderStatus status;

    // Constructores, getters y setters
}
