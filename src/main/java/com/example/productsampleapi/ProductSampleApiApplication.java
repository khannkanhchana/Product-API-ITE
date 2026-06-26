package com.example.productsampleapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

// Customize thee metadata of JPA pagination
@EnableSpringDataWebSupport(pageSerializationMode = EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO)
@SpringBootApplication
public class ProductSampleApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductSampleApiApplication.class, args);
    }

}
