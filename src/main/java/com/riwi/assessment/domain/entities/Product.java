package com.riwi.assessment.domain.entities;

import jakarta.persistence.*;

import lombok.*;

import java.math.BigDecimal;

@Entity(name = "product_entity")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, columnDefinition = "DECIMAL(10,2)")
    private BigDecimal price;
   
    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    private CouponReedemedEntity couponReedemed;
   

}
