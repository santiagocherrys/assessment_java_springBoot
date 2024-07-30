package com.riwi.assessment.infrastructure.helpers.mappers;

import com.riwi.assessment.api.dtos.response.ProductResponse;
import com.riwi.assessment.domain.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {

    public List<ProductResponse> toListResponse(List<Product> products);
}
