package com.example.productsampleapi.dto;

import java.util.List;

public record CategoryResponse(
        Integer id,
        String name,
        String description,
//        Boolean isDeleted,
        // just added
        List<CategoryResponse> subCategories
) {
}
