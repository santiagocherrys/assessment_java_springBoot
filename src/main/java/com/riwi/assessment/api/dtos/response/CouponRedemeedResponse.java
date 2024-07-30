package com.riwi.assessment.api.dtos.response;
import java.math.BigDecimal;

import java.time.LocalDateTime;


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
public class CouponRedemeedResponse {
    private Long id;
    private LocalDateTime createdAt;
    private BigDecimal newPrecio;
    private UserResp user;
    private ProductResponse product;
    private CouponResponse coupon;

}
