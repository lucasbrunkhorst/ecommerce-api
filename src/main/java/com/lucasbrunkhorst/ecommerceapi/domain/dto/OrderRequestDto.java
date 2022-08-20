package com.lucasbrunkhorst.ecommerceapi.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
public class OrderRequestDto {

    @NotNull
    private Integer number;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotNull
    private LocalDate date;

    @Min(0)
    @Max(100)
    @NotNull
    private BigDecimal percentualDiscount;
}
