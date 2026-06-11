//package com.example.productsampleapi.service;
//
//
//import com.example.productsampleapi.dto.CategoryRequest;
//import com.example.productsampleapi.dto.CategoryResponse;
//import com.example.productsampleapi.dto.UpdateCategoryRequest;
//import com.example.productsampleapi.entity.Category;
//import com.example.productsampleapi.repository.CategoryRepository;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.annotation.Primary;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.NoSuchElementException;
//
//@Service
//@RequiredArgsConstructor
//@Slf4j
//public class CategoryServiceImplOld implements CategoryService{
////    private final CategoryRepositoryOld categoryRepositoryOld;
////    private Integer nextId = 1007;
//    private final CategoryRepository categoryRepository;
//
//    private CategoryResponse mapToResponse(Category category){
//        return new CategoryResponse(
//                category.getId(),
//                category.getName(),
//                category.getDescription(),
//                category.getIsActive()
//        );
//    }
//
//    private Category mapToEntity(CategoryRequest request){
//        Category category = new Category();
//        category.setName(request.name());
//        category.setDescription(request.description());
//        category.setIsActive(request.isActive());
//        return category;
//    }
//
//
//    @Override
//    public CategoryResponse createCategory(CategoryRequest request) {
//        var category = mapToEntity(request);
////        category.setId(nextId++);
////        return mapToResponse(categoryRepositoryOld.createCategory(category));
//        category.setId(1);
//        return mapToResponse(categoryRepository.save(category));
//    }
//
//    @Override
//    public List<CategoryResponse> findAllCategory() {
//        return categoryRepository.findAll()
//                .stream()
//                .map(this::mapToResponse)
//                .toList();
//    }
//
//    @Override
//    public CategoryResponse updateCategory(Integer id, UpdateCategoryRequest request) {
////        var existingCategory = categoryRepository.findCategoryById(id);
//        var existingCategory =  categoryRepository.findById(id)
//                .orElseThrow(()-> new NoSuchElementException("Product with ID = "+id+" not found"));
//        if (request.name() != null)
//            existingCategory.setName(request.name());
//        if (request.description() != null)
//            existingCategory.setDescription(request.description());
//        if (request.isActive() != null)
//            existingCategory.setIsActive(request.isActive());
////        categoryRepository.updateCategoryById(existingCategory);
//        //update
//        categoryRepository.save(existingCategory);
//        return mapToResponse(existingCategory);
//    }
//
//    @Override
//    public CategoryResponse findCategoryById(Integer id) {
////        return mapToResponse(
////                categoryRepository.findById(id)
////        );
//        var existingCategory =  categoryRepository.findById(id)
//                .orElseThrow(()-> new NoSuchElementException("Product with ID = "+id+" not found"));
//        return mapToResponse(existingCategory);
//    }
//
////    @Override
////    public void deleteCategory(Integer id) {
//////        categoryRepositoryOld.findCategoryById(id);
//////        return categoryRepositoryOld.deleteCategoryById(id);
////        // find if the product exist
////        // if it's we delete it and return true
////        // else return false
////
////        if(categoryRepository.existsById(id)) {
////            categoryRepository.deleteById(id);
////            return true;
////        }
////        return false;
////    }
//    @Override
//    public void deleteCategory(Integer id) {
//        if (!categoryRepository.existsById(id)) {
//            throw new NoSuchElementException(
//                    "Category with ID = " + id + " not found");
//        }
//
//        categoryRepository.deleteById(id);
//    }
//
//    @Override
//    public List<CategoryResponse> findByName(String name) {
//        return List.of();
//    }
//}
