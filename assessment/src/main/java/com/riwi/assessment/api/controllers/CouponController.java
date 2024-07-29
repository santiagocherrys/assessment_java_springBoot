package com.riwi.assessment.api.controllers;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.assessment.api.dtos.request.CouponRequest;
import com.riwi.assessment.api.dtos.response.CouponResponse;
import com.riwi.assessment.infrastructure.abstract_services.ICouponService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/coupons")
@AllArgsConstructor
@Tag(name = "Coupon")
public class CouponController {
    
    private final ICouponService couponService;

    @Operation(
        summary = "List all coupons with pagination",
        description = "You must submit the page and the page size to get all the corresponding coupons")
    @GetMapping
    public ResponseEntity<Page<CouponResponse>> getAll(
        @RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "5") Integer size
    ) {
        return ResponseEntity.ok(this.couponService.getAll(page -1, size));
    }

    @Operation(
        summary = "Create a coupon",
        description = "Create a coupon") 
    @PostMapping 
    public ResponseEntity<CouponResponse> create(@Validated @RequestBody CouponRequest request){
        return ResponseEntity.ok(this.couponService.create(request));
    }

    @ApiResponse(responseCode = "400", description = "When the request is invalid", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
    })
    @Operation(
        summary = "Update a coupon",
        description = "Update a coupon")  
    @PutMapping(path = "{id}")
    public ResponseEntity<CouponResponse> update(@Validated @RequestBody CouponRequest request, @PathVariable Long id) {
        return ResponseEntity.ok(this.couponService.update(request, id));
    }

    @ApiResponse(responseCode = "400", description = "When the id is invalid", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
    })
    @Operation(
        summary = "Delete a coupon by id",
        description = "Delete a coupon by id")  
    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.couponService.delete(id);;
        return ResponseEntity.noContent().build();
    }

    @ApiResponse(responseCode = "400", description = "When the id is invalid", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
    })
    @Operation(
        summary = "Check coupon validity",
        description = "Check if a coupon is valid by id")  
    @GetMapping(path = "{id}/validity")
    public ResponseEntity<Boolean> checkValidity(@PathVariable Long id){
        return ResponseEntity.ok(this.couponService.isValid(id));
    }
}
