package com.example.productsampleapi.service;


import com.example.productsampleapi.dto.ProductRequest;
import com.example.productsampleapi.dto.ProductResponse;
import com.example.productsampleapi.dto.UpdateProductRequest;
import com.example.productsampleapi.entity.Product;
import com.example.productsampleapi.repository.ProductRepository;
import com.example.productsampleapi.repository.ProductRepositoryOld;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService{
    // inject repository
//    private final ProductRepositoryOld productRepositoryOld;
//    private Integer nextId = 1007;

    private final ProductRepository productRepository;
    //mapToEntity
    private Product mapToEntity(ProductRequest request) {
        Product product = new Product();
        product.setName(request.name());
        product.setDescription(request.description());
        product.setPrice(request.price());

        return product;
    }

    //mapToEntity
    //mapToResponse -> convert Entity to Response
    private ProductResponse mapToResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice()
        );
    }

    @Override
    public ProductResponse createProduct(ProductRequest request) {
        //create entity product from the request
        var product = mapToEntity(request);
        //set static userID
        product.setUserId(1);
//        product.setId(nextId++);
//        return mapToResponse(productRepositoryOld.createProduct(product));
        // insert the data to the table only need to
        // repository.save(entity) = insert
        return mapToResponse(productRepository.save(product));
    }

    @Override
    public List<ProductResponse> findAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public ProductResponse findProductById(Integer id) {
        var product = productRepository.findById(id)
                .orElseThrow(()-> new NoSuchElementException("Product with ID = "+id+" not found"));
        return mapToResponse(product);
    }

    @Override
    public ProductResponse updateProduct(Integer id, UpdateProductRequest request) {
        //find existing product
//        var existingProduct = productRepository.findById(id);
//        if(existingProduct == null) {
//            log.info("Product with id {} not found", id);
//            return null;
//        }
        var existingProduct = productRepository.findById(id).orElseThrow(()-> new NoSuchElementException("Product with ID = "+id+" not found"));
        if (request.name() != null)
            existingProduct.setName(request.name());
        if (request.description() != null)
            existingProduct.setDescription(request.description());
        if (request.price() != null)
            existingProduct.setPrice(request.price());
        productRepository.save(existingProduct);
        //Product product = mapToEntity(request);
        return mapToResponse(existingProduct);
    }

    @Override
    public boolean deleteProduct(int id) {
        var product = productRepository.findById(id);
//        if (product == null) {
//            log.info("Product with id {} not found", id);
//            return false;
//        }

//        productRepository.deleteById(id);
//        return true;
        if(productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
