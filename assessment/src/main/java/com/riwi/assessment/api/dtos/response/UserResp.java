package com.riwi.assessment.api.dtos.response;

import java.util.List;

import com.riwi.assessment.domain.entities.Coupon;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResp {
    private String userName;
    private String name;
    private String email;

    private List<Coupon> coupons;
    private List<CouponRedeemed> CouponRedeemed;
}
