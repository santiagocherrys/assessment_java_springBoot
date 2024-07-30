package com.riwi.assessment.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riwi.assessment.domain.entities.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
    
}
