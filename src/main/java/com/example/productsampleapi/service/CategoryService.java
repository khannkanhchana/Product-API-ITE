package com.example.productsampleapi.service;

import com.example.productsampleapi.dto.CategoryRequest;
import com.example.productsampleapi.dto.CategoryResponse;
import com.example.productsampleapi.dto.UpdateCategoryRequest;

import java.util.List;

public interface CategoryService {
    CategoryResponse createCategory(CategoryRequest request);
    List<CategoryResponse> findAllCategory();
    CategoryResponse updateCategory(Integer id, UpdateCategoryRequest categoryRequest);
    CategoryResponse findCategoryById(Integer id);
    void deleteCategory(Integer id);
    List<CategoryResponse> findByName(String name);
}
