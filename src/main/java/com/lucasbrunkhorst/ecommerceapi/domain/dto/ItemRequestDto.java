package com.lucasbrunkhorst.ecommerceapi.domain.dto;

import com.lucasbrunkhorst.ecommerceapi.domain.enumeration.ItemType;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
public class ItemRequestDto {

    @NotBlank
    private String description;

    @NotNull
    private BigDecimal value;

    @NotNull
    private ItemType type;
}
