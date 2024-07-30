package com.riwi.assessment.infrastructure.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.assessment.api.dtos.request.CouponRedemeedRequest;
import com.riwi.assessment.api.dtos.response.CouponRedemeedResponse;
import com.riwi.assessment.domain.entities.Coupon;
import com.riwi.assessment.domain.entities.CouponReedemedEntity;

import com.riwi.assessment.domain.repositories.CouponRedemeedRepository;
import com.riwi.assessment.domain.repositories.CouponRepository;
import com.riwi.assessment.domain.repositories.UserRepository;
import com.riwi.assessment.infrastructure.abstract_services.ICouponRedemeedService;
import com.riwi.assessment.infrastructure.helpers.mappers.CouponRedemeedMappers;
import com.riwi.assessment.utils.exceptions.BadRequestException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class CouponRedemeedService implements ICouponRedemeedService {
    @Autowired
    private final CouponRedemeedMappers couponRedemeedMappers;
    @Autowired
    private final CouponRedemeedRepository couponReedemedRepository;
    @Autowired
    private final CouponRepository couponRepository;
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final com.riwi.assessment.domain.repositories.ProductRepository ProductRepository;

    @Override
    public CouponRedemeedResponse create(CouponRedemeedRequest request) {
        // System.out.println(request.getCoupon());
        // System.out.println(request.getProduct());
        // System.out.println(request.getUser());
        CouponReedemedEntity entity = couponRedemeedMappers.reqEntity(request);
        entity.setUser(this.userRepository.findById(request.getUser())
                .orElseThrow(() -> new BadRequestException("ID NOT FOUND")));
        entity.setProduct(this.ProductRepository.findById(request.getProduct())
                .orElseThrow(() -> new BadRequestException("ID NOT FOUND")));

        Coupon coupon = this.couponRepository.findById(request.getCoupon())
                .orElseThrow(() -> new BadRequestException("ID NOT FOUND"));
        coupon.setState(false);
        coupon.setDiscount(coupon.getDiscount().divide(new BigDecimal(100)));
        entity.setNewPrecio(coupon.getDiscount().multiply(entity.getProduct().getPrice()));
        entity.setCoupon(coupon);
        this.couponRepository.save(coupon);

        return couponRedemeedMappers.resEntity(couponReedemedRepository.save(entity));

    }

    @Override
    public Page<CouponRedemeedResponse> getAll(int page, int size) {
        if(page <0) page = 1;
        PageRequest pageRequest = PageRequest.of(page, size);
        return couponReedemedRepository.findAll(pageRequest).map(couponRedemeedMappers::resEntity);
    }

}
