package com.lucasbrunkhorst.ecommerceapi.domain.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
public class OrderItemRequestDto {

    @NotBlank
    private String itemUuid;

    @NotNull
    private BigDecimal quantity;
}
