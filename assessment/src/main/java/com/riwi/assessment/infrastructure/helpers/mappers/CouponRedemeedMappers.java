package com.riwi.assessment.infrastructure.helpers.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import com.riwi.assessment.api.dtos.request.CouponRedemeedRequest;
import com.riwi.assessment.api.dtos.response.CouponRedemeedResponse;
import com.riwi.assessment.api.dtos.response.CouponResponse;
import com.riwi.assessment.domain.entities.CouponReedemedEntity;

@Mapper(componentModel =MappingConstants.ComponentModel.SPRING)
public interface CouponRedemeedMappers {
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "createdAt", ignore = true),
            @Mapping(target = "newPrecio", ignore = true),
            @Mapping(source="coupon", target="coupon.id"),
            @Mapping(source="product", target="product.id"),
            @Mapping(source="user", target="user.id")
    })
    CouponReedemedEntity reqEntity (CouponRedemeedRequest req);

    CouponRedemeedResponse resEntity (CouponReedemedEntity entity);

}
