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

//    @Override
//    public CategoryResponse createCategory(CategoryRequest request) {
////        Category category = categoryMapper.toEntity(request);
////        var newCategory = categoryRepository.save(category);
////        return categoryMapper.toResponse(newCategory);
////        return null;
//        Category category = categoryMapper.toEntity(request);
//
//        if(categoryRepository.existsByName(request.name())){
//            // throw exception handler
////            throw new RuntimeException("category already exists");
//            throw new ResourceAlreadyExistException("Category with name= " + request.name() + "Already exists");
//        }
//        var newCategory = categoryRepository.save(category);
//        return categoryMapper.toResponse(newCategory);
//    }
@Override
public CategoryResponse createCategory(CategoryRequest request) {

    Category category = categoryMapper.toEntity(request);

    if (categoryRepository.existsByName(request.name())) {
        throw new ResourceAlreadyExistException(
                "Category with name= " + request.name() + " already exists"
        );
    }

    category.setIsDeleted(false);

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
    public CategoryResponse updateCategory(Integer id, UpdateCategoryRequest request) {

        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Category with id = " + id + " not found"));

        if (request.name() != null) {
            category.setName(request.name());
        }

        if (request.description() != null) {
            category.setDescription(request.description());
        }


        Category updated = categoryRepository.save(category);

        return categoryMapper.toResponse(updated);
    }

    @Override
    public CategoryResponse findCategoryById(Integer id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Category with id = " + id + " not found"));

        return categoryMapper.toResponse(category);
    }


    // do with sort delete
//    @Override
//    public void deleteCategory(Integer id) {
//        Category category = new Category();
//        if (!categoryRepository.existsById(id)) {
//            throw new NoSuchElementException("Category with id = " + id + "does not exist");
//        }
//        category.setIsDeleted(true);
//        categoryRepository.save(category);
////        categoryRepository.deleteById(id);
////        if(categoryRepository.existsById(id)) {
////            categoryRepository.deleteById(id);
////            return true;
////        }
////        return false;
//    }

@Override
public void deleteCategory(Integer id) {

    Category category = categoryRepository.findById(id)
            .orElseThrow(() ->
                    new NoSuchElementException("Category with id = " + id + " does not exist")
            );

    category.setIsDeleted(true);

    categoryRepository.save(category);
}

    @Override
    public List<CategoryResponse> findByName(String name) {
        return categoryRepository.findByNameContainingIgnoreCase(name)
                .stream()
                .map(categoryMapper::toResponse)
                .toList();
    }
}
