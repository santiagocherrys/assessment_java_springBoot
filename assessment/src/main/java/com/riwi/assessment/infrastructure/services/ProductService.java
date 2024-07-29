package com.riwi.assessment.infrastructure.services;

import com.riwi.assessment.api.dtos.response.ProductResponse;
import com.riwi.assessment.domain.entities.Product;
import com.riwi.assessment.domain.repositories.ProductRepository;
import com.riwi.assessment.infrastructure.abstract_services.IProductService;
import com.riwi.assessment.infrastructure.helpers.mappers.ProductMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService implements IProductService {

    @Autowired
    private final ProductRepository productRepository;

    @Autowired
    private final ProductMapper productMapper;

    @Override
    public Page<ProductResponse> getAll(int page, int size) {

        PageRequest pageRequest = PageRequest.of(page-1, size);

        Page<Product> products = this.productRepository.findAll(pageRequest);

        List<ProductResponse> productResponses = this.productMapper.toListResponse(products.getContent());

        return new PageImpl<>(productResponses, pageRequest, products.getTotalElements());
    }
}
