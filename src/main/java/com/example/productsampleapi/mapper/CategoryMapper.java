package com.example.productsampleapi.mapper;

import com.example.productsampleapi.dto.CategoryRequest;
import com.example.productsampleapi.dto.CategoryResponse;
import com.example.productsampleapi.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryResponse toResponse(Category category);
    Category toEntity(CategoryRequest request);
}
