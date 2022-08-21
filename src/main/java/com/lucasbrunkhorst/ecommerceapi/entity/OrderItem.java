package com.lucasbrunkhorst.ecommerceapi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {

    @Id
    private String uuid;

    @JsonBackReference
    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Order order;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Item item;

    @Column(name = "quantity", nullable = false)
    private BigDecimal quantity;

    @Column(name = "value", nullable = false)
    private BigDecimal value;

    @PrePersist
    private void prePersist() {
        uuid = UUID.randomUUID().toString();
    }
}
