package com.riwi.assessment.api.dtos.request;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CouponRequest {
    @NotNull(message = "Discount is required")
    private BigDecimal discount;
    @NotNull(message = "Expiration date is required")
    private LocalDate expirationDate;
    @NotNull(message = "The state is required")
    private Boolean state;
}
