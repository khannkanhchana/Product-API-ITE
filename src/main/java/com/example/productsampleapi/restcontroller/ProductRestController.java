package com.example.productsampleapi.restcontroller;

import com.example.productsampleapi.dto.ProductRequest;
import com.example.productsampleapi.dto.ProductResponse;
import com.example.productsampleapi.dto.UpdateProductRequest;
import com.example.productsampleapi.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductRestController {
    private final ProductService productService;

    @GetMapping
    public List<ProductResponse> getProducts() {
        return productService.findAllProducts();
    }

    //find product by id
    // localhost:8080/api/v1/products/1001
    @GetMapping("/{id}")
    public ProductResponse getProductById(@PathVariable Integer id) {
        return productService.findProductById(id);
    }

    @PostMapping
    public ProductResponse createProduct(@Valid @RequestBody ProductRequest request) {
        return productService.createProduct(request);
    }

    //update product by id
    // Content-Type JSON
    @PatchMapping("/{id}")
    public ProductResponse updateProduct(@PathVariable Integer id, @RequestBody UpdateProductRequest request) {
        return productService.updateProduct(id, request);
    }

    //delete product by ID
    @DeleteMapping("/{id}")
    public Boolean deleteProduct(@PathVariable Integer id){
        return productService.deleteProduct(id);
    }
}
