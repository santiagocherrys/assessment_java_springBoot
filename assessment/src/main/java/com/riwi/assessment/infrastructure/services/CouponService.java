package com.riwi.assessment.infrastructure.services;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.assessment.api.dtos.request.CouponRequest;
import com.riwi.assessment.api.dtos.response.CouponResponse;
import com.riwi.assessment.domain.entities.Coupon;
import com.riwi.assessment.domain.repositories.CouponRepository;
import com.riwi.assessment.infrastructure.abstract_services.ICouponService;
import com.riwi.assessment.infrastructure.helpers.mappers.CouponMapper;

import com.riwi.assessment.utils.exceptions.BadRequestException;


import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class CouponService implements ICouponService{
    
    private final CouponRepository couponRepository;

    private final CouponMapper couponMapper;

    @Override
    public CouponResponse create(CouponRequest request) {
        Coupon coupon = couponMapper.couponRequestToCoupon(request);
        
        return couponMapper.couponToCouponResponse(this.couponRepository.save(coupon));
    }

    @Override
    public Page<CouponResponse> getAll(int page, int size) {
        
        if (page < 0) page = 0;
        PageRequest pagination = PageRequest.of(page, size);

        return this.couponRepository.findAll(pagination).map(couponMapper::couponToCouponResponse);
    }

    @Override
    public CouponResponse update(CouponRequest request, Long id) {

        Coupon coupon = this.couponRepository.findById(id).orElseThrow(() -> new BadRequestException("Coupon not found"));
   
        if (coupon.getState()) {
            throw new BadRequestException("Cannon modify a used coupon");
        }



        couponMapper.couponToUpdate(request, coupon);


        return couponMapper.couponToCouponResponse(this.couponRepository.save(coupon));
    }

    @Override
    public void delete(Long id) {

        Coupon coupon = this.couponRepository.findById(id).orElseThrow(() -> new BadRequestException("Coupon not found"));

        if (coupon.getState()) {
            throw new BadRequestException("Cannon modify a used coupon");
        }

        this.couponRepository.delete(coupon);
    } 
    
    @Override
    public Boolean isValid(Long id) {
        Coupon coupon = this.couponRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Coupon not found"));

        return !coupon.getState() && LocalDate.now().isBefore(coupon.getExpirationDate());
    }

        //Coupon coupon = this.couponRepository.findById(id).orElseThrow(() -> new RuntimeException("Coupon not found"));

        //coupon.setState(false);
    //}

}
