package com.lucasbrunkhorst.ecommerceapi.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "ordering")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order {

    @Id
    private String uuid;

    @Column(name = "number", unique = true, nullable = false)
    private Integer number;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "percentual_discount", nullable = false)
    private BigDecimal percentualDiscount;

    @Column(name = "total_value", nullable = false)
    private BigDecimal totalValue;

    @JsonManagedReference
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> items = new ArrayList<>();

    @PrePersist
    private void prePersist() {
        uuid = UUID.randomUUID().toString();
    }

}
