package com.example.productsampleapi.dto;

public record UpdateProductRequest(
        String name,
        String description,
        Float price
) {
}
