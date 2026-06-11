package com.example.productsampleapi.service;

import com.example.productsampleapi.advisor.ResourceAlreadyExistException;
import com.example.productsampleapi.dto.CategoryRequest;
import com.example.productsampleapi.dto.CategoryResponse;
import com.example.productsampleapi.dto.UpdateCategoryRequest;
import com.example.productsampleapi.entity.Category;
import com.example.productsampleapi.mapper.CategoryMapper;
import com.example.productsampleapi.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Slf4j
@Primary
public class CategoryServiceImpl implements CategoryService {
    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;

    @Override
    public CategoryResponse createCategory(CategoryRequest request) {
//        Category category = categoryMapper.toEntity(request);
//        var newCategory = categoryRepository.save(category);
//        return categoryMapper.toResponse(newCategory);
//        return null;
        Category category = categoryMapper.toEntity(request);

        if(categoryRepository.existsByName(request.name())){
            // throw exception handler
//            throw new RuntimeException("category already exists");
            throw new ResourceAlreadyExistException("Category with name= " + request.name() + "Already exists");
        }
        var newCategory = categoryRepository.save(category);
        return categoryMapper.toResponse(newCategory);
    }

    @Override
    public List<CategoryResponse> findAllCategory() {
//        return List.of();
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::toResponse)
                .toList();
    }

    @Override
    public CategoryResponse updateCategory(Integer id, UpdateCategoryRequest categoryRequest) {
        return null;
    }

    @Override
    public CategoryResponse findCategoryById(Integer id) {
        return null;
    }

    @Override
    public void deleteCategory(Integer id) {
        if (!categoryRepository.existsById(id)) {
            throw new NoSuchElementException("Category with id = " + id + "does not exist");
        }
        categoryRepository.deleteById(id);
//        if(categoryRepository.existsById(id)) {
//            categoryRepository.deleteById(id);
//            return true;
//        }
//        return false;
    }

    @Override
    public List<CategoryResponse> findByName(String name) {
        return List.of();
    }
}
