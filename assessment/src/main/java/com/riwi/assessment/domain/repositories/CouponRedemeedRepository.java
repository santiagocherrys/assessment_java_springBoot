package com.riwi.assessment.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riwi.assessment.domain.entities.CouponReedemedEntity;

public interface CouponRedemeedRepository extends  JpaRepository<CouponReedemedEntity, Long>{
    
}
