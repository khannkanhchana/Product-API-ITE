package com.example.productsampleapi.dto;

import java.util.Set;

public record ProductResponse(
        Integer id,
        String name,
        String description,
        Float price,
        Boolean isDeleted,
        CategoryResponse category,
        Set<TagResponse> tags
) {
}
