package com.riwi.assessment.infrastructure.abstract_services;

import com.riwi.assessment.api.dtos.request.CouponRequest;
import com.riwi.assessment.api.dtos.response.CouponResponse;
import com.riwi.assessment.infrastructure.abstract_services.generic.Create;
import com.riwi.assessment.infrastructure.abstract_services.generic.Delete;
import com.riwi.assessment.infrastructure.abstract_services.generic.GetAll;
import com.riwi.assessment.infrastructure.abstract_services.generic.Update;

public interface ICouponService extends
                Create<CouponRequest, CouponResponse>,
                GetAll<CouponResponse>,
                Update<CouponRequest, CouponResponse, Long>,
                Delete<Long>{

        Boolean isValid(Long id);            
}
