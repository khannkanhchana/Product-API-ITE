package com.example.productsampleapi.restcontroller;

import com.example.productsampleapi.dto.CategoryRequest;
import com.example.productsampleapi.dto.CategoryResponse;
import com.example.productsampleapi.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
public class CategoryRestController {
//    private final CategoryService categoryService;
//    // clode doysa tae brer @RequiredArgsConstructor
//    public CategoryRestControllerOld(CategoryServic categoryServic) {
//        this.categoryService = categoryServic;
//    }
//
//    @GetMapping
//    public List<CategoryResponse> getCategory(){
//        return categoryService.findAllCategory();
//    }
//
//    @PostMapping
//    public CategoryResponse createCategory(@Valid @RequestBody CategoryRequest request){
//        return categoryService.createCategory(request);
//    }
//
//    @GetMapping("/{id}")
//    public CategoryResponse getCategoryById(@PathVariable Integer id){
//        return categoryService.findCategoryById(id);
//    }
//
//    @PatchMapping
//    public CategoryResponse updateCategory(@PathVariable Integer id, @RequestBody UpdateCategoryRequest categoryRequest){
//        return categoryService.updateCategory(id, categoryRequest);
//    }
//
//    @DeleteMapping("/{id}")
//    public Boolean deleteCategoryById(@PathVariable Integer id){
//        return categoryService.deleteCategory(id);
//    }

    // New One
    private final CategoryService categoryService;

    @GetMapping
    List<CategoryResponse> getCategories() {
        return categoryService.findAllCategory();
    }

    @PostMapping
    public CategoryResponse createCategory(@Valid @RequestBody CategoryRequest request){
        return categoryService.createCategory(request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable Integer id) {
        categoryService.deleteCategory(id);

    }
}
