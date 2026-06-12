package com.example.productsampleapi.service;

import com.example.productsampleapi.dto.ProductRequest;
import com.example.productsampleapi.dto.ProductResponse;
import com.example.productsampleapi.dto.UpdateProductRequest;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface ProductService {
    ProductResponse createProduct(ProductRequest request);
//    List<ProductResponse> findAllProducts();
    // for the pagination support when get all products
    Page<ProductResponse> findAllProducts(Pageable pageable);



    // Page<ProductResponse> name(String keywords, Pageable page);
    ProductResponse findProductById(Integer id);

    ProductResponse updateProduct(Integer id, UpdateProductRequest updateProductRequest);

    // soft delete but show only database when delete=true(the same category)
    void deleteProduct(Integer id);
}
