package com.riwi.assessment.infrastructure.abstract_services;

import com.riwi.assessment.api.dtos.response.ProductResponse;
import com.riwi.assessment.infrastructure.abstract_services.generic.GetAll;

public interface IProductService extends GetAll<ProductResponse> {
}
