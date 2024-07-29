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
    
    private Long coupon;
   
    private Long product;
   
    private Long user;


}
