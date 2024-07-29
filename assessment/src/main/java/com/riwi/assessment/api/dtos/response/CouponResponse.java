package com.riwi.assessment.api.dtos.response;

import java.math.BigDecimal;
import java.time.LocalDate;

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
public class CouponResponse {
    private String id;
    private BigDecimal discount;
    private LocalDate expirationDate;
    private Boolean state;
}
