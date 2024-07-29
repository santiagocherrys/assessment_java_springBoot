package com.riwi.assessment.seeder;

import com.riwi.assessment.domain.entities.Product;
import com.riwi.assessment.domain.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@AllArgsConstructor
@Slf4j
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    private final ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        //check if data already exists
        if(this.productRepository.count() > 0){
            return;
        }

        Product product1 = Product.builder().name("Watch").price(new BigDecimal(Double.toString(100.2))).build();
        Product product2 = Product.builder().name("Notebook").price(new BigDecimal(Double.toString(10.0))).build();
        Product product3 = Product.builder().name("Pencil").price(new BigDecimal(Double.toString(2.0))).build();
        Product product4 = Product.builder().name("Pen").price(new BigDecimal(Double.toString(2.5))).build();
        Product product5 = Product.builder().name("Erase").price(new BigDecimal(Double.toString(3.0))).build();
        Product product6 = Product.builder().name("Computer").price(new BigDecimal(Double.toString(700.0))).build();
        Product product7 = Product.builder().name("Shirt").price(new BigDecimal(Double.toString(50.0))).build();
        Product product8 = Product.builder().name("Shorts").price(new BigDecimal(Double.toString(40.0))).build();
        Product product9 = Product.builder().name("Mouse").price(new BigDecimal(Double.toString(25.0))).build();
        Product product10 = Product.builder().name("Keyboard").price(new BigDecimal(Double.toString(30.0))).build();
        this.productRepository.save(product1);
        this.productRepository.save(product2);
        this.productRepository.save(product3);
        this.productRepository.save(product4);
        this.productRepository.save(product5);
        this.productRepository.save(product6);
        this.productRepository.save(product7);
        this.productRepository.save(product8);
        this.productRepository.save(product9);
        this.productRepository.save(product10);
        log.info("Database seeded Product completed");
    }
}
