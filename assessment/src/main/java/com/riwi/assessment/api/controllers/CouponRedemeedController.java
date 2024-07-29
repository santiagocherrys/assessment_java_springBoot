package com.riwi.assessment.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.assessment.api.dtos.request.CouponRedemeedRequest;
import com.riwi.assessment.api.dtos.response.CouponRedemeedResponse;
import com.riwi.assessment.infrastructure.abstract_services.ICouponRedemeedService;


import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
@RestController
@RequestMapping(path ="couponRedemeed")
@AllArgsConstructor
@Tag(name = "CouponRedemeed")
public class CouponRedemeedController {

    @Autowired
    private final ICouponRedemeedService couponRedemeedService;

    @PostMapping 
    public ResponseEntity<CouponRedemeedResponse> create(@Validated @RequestBody CouponRedemeedRequest request){
        return ResponseEntity.ok(this.couponRedemeedService.create(request));


    }


}
