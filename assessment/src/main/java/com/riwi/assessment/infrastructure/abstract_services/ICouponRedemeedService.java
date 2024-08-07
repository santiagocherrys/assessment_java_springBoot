package com.riwi.assessment.infrastructure.abstract_services;

import com.riwi.assessment.api.dtos.request.CouponRedemeedRequest;
import com.riwi.assessment.api.dtos.response.CouponRedemeedResponse;
import com.riwi.assessment.infrastructure.abstract_services.generic.Create;
import com.riwi.assessment.infrastructure.abstract_services.generic.GetAll;

public interface ICouponRedemeedService extends Create<CouponRedemeedRequest, CouponRedemeedResponse>,GetAll<CouponRedemeedResponse>{
    



}
