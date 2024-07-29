package com.riwi.assessment.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.riwi.assessment.api.dtos.request.CouponRedemeedRequest;
import com.riwi.assessment.api.dtos.response.CouponRedemeedResponse;
import com.riwi.assessment.domain.entities.Coupon;
import com.riwi.assessment.domain.entities.CouponReedemedEntity;
import com.riwi.assessment.domain.entities.Product;
import com.riwi.assessment.domain.entities.Users;
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
        System.out.println(request.getCoupon());
        CouponReedemedEntity entity = couponRedemeedMappers.reqEntity(request);
   
        Coupon coupon = this.couponRepository.findById(request.getCoupon()).orElseThrow(() -> new BadRequestException("ID NOT FOUND"));
        System.out.println(coupon);
        Users user = this.userRepository.findById(request.getUser()).orElseThrow(() -> new BadRequestException("ID NOT FOUND"));
        System.out.println(user);
        Product product = this.ProductRepository.findById(request.getProduct()).orElseThrow(() -> new BadRequestException("ID NOT FOUND"));
        System.out.println(product);
        
            entity.setNewPrecio(coupon.getDiscount().multiply(product.getPrice()));
            entity.setUser(user);
            entity.setProduct(product);
            entity.setCoupon(coupon);
            return couponRedemeedMappers.resEntity(couponReedemedRepository.save(entity));
        
         
        
      
    }

    @Override
    public Page<CouponRedemeedResponse> getAll(int page, int size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

}
