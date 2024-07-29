package com.riwi.assessment.api.dtos.response;

import jakarta.persistence.Column;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private Long id;

    private String name;

    private BigDecimal price;
}
