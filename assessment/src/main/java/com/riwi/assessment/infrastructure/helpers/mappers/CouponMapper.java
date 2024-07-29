package com.riwi.assessment.infrastructure.helpers.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.riwi.assessment.api.dtos.request.CouponRequest;
import com.riwi.assessment.api.dtos.response.CouponResponse;
import com.riwi.assessment.domain.entities.Coupon;

@Mapper(componentModel = "spring")
public interface CouponMapper {
    
    @Mapping(target = "id", ignore = true)
    Coupon couponRequestToCoupon(CouponRequest request);

    CouponResponse couponToCouponResponse(Coupon coupon);

    @Mapping(target = "id", ignore = true)
    void couponToUpdate(CouponRequest request, @MappingTarget Coupon coupon);
}
