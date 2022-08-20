package com.lucasbrunkhorst.ecommerceapi.entity;

import com.lucasbrunkhorst.ecommerceapi.domain.enumeration.ItemType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Item {

    @Id
    private String uuid;

    @Column(name = "description", nullable = false, unique = true)
    private String description;

    @Column(name = "value", nullable = false)
    private BigDecimal value;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private ItemType type;

    @PrePersist
    private void prePersist(){
        uuid = UUID.randomUUID().toString();
    }


}
