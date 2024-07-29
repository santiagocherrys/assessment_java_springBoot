package com.riwi.assessment.api.dtos.response;
import java.math.BigDecimal;

import java.time.LocalDateTime;

import com.riwi.assessment.domain.entities.Coupon;
import com.riwi.assessment.domain.entities.Product;
import com.riwi.assessment.domain.entities.Users;

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
public class CoupenRedemeedResponse {
    private Long id;
    private LocalDateTime createdAt;
    private BigDecimal newPrecio;
    private Users user;
    private Product product;
    private Coupon coupon;

}
