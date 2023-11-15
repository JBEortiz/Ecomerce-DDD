package com.ecommerce.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Builder
@Data
@AllArgsConstructor
public class Order {
    private OrderId id;
    private CustomerId customerId;
    private List<OrderLine> orderLines;
    private OrderStatus status;


    public void addOrderLine(OrderLine orderLine) {
        this.orderLines.add(orderLine);
    }
/*
    public boolean removeOrderLine(ProductId productId) {
        return orderLines.removeIf(line -> line.getProductId().equals(productId));
    }

    public BigDecimal calculateTotal() {
        return orderLines.stream()
                .map(OrderLine::calculateSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void markAsPaid() {
        if (this.status == OrderStatus.PENDING) {
            this.status = OrderStatus.PAID;
        } else {
            // Handle invalid state transition if necessary...
        }
    }

    public void shipOrder() {
        if (this.status == OrderStatus.PAID) {
            this.status = OrderStatus.SHIPPED;
        } else {
            // Exception
        }
    }

    public void deliverOrder() {
        if (this.status == OrderStatus.SHIPPED) {
            this.status = OrderStatus.DELIVERED;
        } else {
            // Exception
        }
    }

    public void cancelOrder() {
        if (this.status == OrderStatus.PENDING || this.status == OrderStatus.PAID) {
            this.status = OrderStatus.CANCELLED;
        } else {
            // Exception
        }
    }
*/

}

