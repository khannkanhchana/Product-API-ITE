package com.example.productsampleapi.dto;


import lombok.Builder;

@Builder
public record TagRequest(
        String name
) {
}
