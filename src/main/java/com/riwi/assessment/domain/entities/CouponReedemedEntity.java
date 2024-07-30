package com.riwi.assessment.domain.entities;

import java.math.BigDecimal;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name ="coupon_reedemed")
public class CouponReedemedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;


    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false, columnDefinition = "DECIMAL(10,2)")
    private BigDecimal newPrecio;

     @ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name = "user_id", referencedColumnName = "id")
     private Users user;

       
     @OneToOne
     @JoinColumn(name = "coupon_id")
     private Coupon coupon;
       
     @OneToOne
     @JoinColumn(name = "product_id")
     private Product product;


}
