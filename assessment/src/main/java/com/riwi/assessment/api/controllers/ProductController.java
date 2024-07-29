package com.riwi.assessment.api.controllers;

import com.riwi.assessment.api.dtos.response.ProductResponse;
import com.riwi.assessment.infrastructure.abstract_services.IProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path ="products")
@AllArgsConstructor
@Tag(name = "products")
public class ProductController {

    @Autowired
    private final IProductService productService;

    @GetMapping
    public ResponseEntity<Page<ProductResponse>> getAll(@RequestParam(defaultValue = "1") int page,
                                                        @RequestParam(defaultValue = "5")int size){
        return ResponseEntity.ok(this.productService.getAll(page, size));
    }
}
