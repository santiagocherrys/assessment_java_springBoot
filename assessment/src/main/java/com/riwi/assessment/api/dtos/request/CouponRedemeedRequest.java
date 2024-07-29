package com.riwi.assessment.api.dtos.request;

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
public class CouponRedemeedRequest {
    @NotNull(message = "Coupon is required")
    private Long coupon;
    @NotNull(message = "Product is required")
    private Long product;
    @NotNull(message = "User is required")
    private Long user;


}
