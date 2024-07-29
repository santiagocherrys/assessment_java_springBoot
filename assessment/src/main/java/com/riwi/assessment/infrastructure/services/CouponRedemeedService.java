package com.riwi.assessment.infrastructure.services;

import org.springframework.data.domain.Page;

import com.riwi.assessment.api.dtos.request.CouponRedemeedRequest;
import com.riwi.assessment.api.dtos.response.CoupenRedemeedResponse;
import com.riwi.assessment.infrastructure.abstract_services.ICouponRedemeedService;

public class CouponRedemeedService implements ICouponRedemeedService {

    @Override
    public CoupenRedemeedResponse create(CouponRedemeedRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public Page<CoupenRedemeedResponse> getAll(int page, int size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

}
