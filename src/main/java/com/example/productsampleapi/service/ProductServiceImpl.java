package com.example.productsampleapi.service;


import com.example.productsampleapi.dto.ProductRequest;
import com.example.productsampleapi.dto.ProductResponse;
import com.example.productsampleapi.dto.UpdateProductRequest;
import com.example.productsampleapi.entity.Product;
import com.example.productsampleapi.mapper.ProductMapper;
import com.example.productsampleapi.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

//import java.awt.print.Pageable;
import org.springframework.data.domain.Pageable;
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
    private final ProductMapper productMapper;
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
                product.getPrice(),
                product.getIsDeleted() // IMPORTANT FIX
        );
    }

    @Override
    public ProductResponse createProduct(ProductRequest request) {

        Product product = productMapper.mapToProduct(request);

        product.setUserId(1);
        product.setIsDeleted(false);

        return productMapper.mapToResponse(productRepository.save(product));
    }

//    @Override
//    public List<ProductResponse> findAllProducts() {
//        return productRepository.findAll()
//                .stream()
//                .map(this::mapToResponse)
//                .toList();
//    }

//    @Override
//    public Page<ProductResponse> findAllProducts(Pageable pageable) {
//        return productRepository.findByIsDeletedFalse(pageable)
//                .map(productMapper::mapToResponse);
//    }
//@Override
//public List<ProductResponse> findAllProducts() {
//    // repository.findAll()
//    return productRepository.findAll()
//            .stream()
//            .map(productMapper::mapToResponse)
//            .toList();
//}


    @Override
    public Page<ProductResponse> findAllProducts(Pageable pageable) {
        return productRepository.findByIsDeletedFalse(pageable)
                .map(productMapper::mapToResponse);
    }

    @Override
    public ProductResponse findProductById(Integer id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() ->
                        new NoSuchElementException("Product with ID = " + id + " not found")
                );

        return productMapper.mapToResponse(product);
    }

    @Override
    public ProductResponse updateProduct(Integer id, UpdateProductRequest request) {

        Product product = productRepository.findById(id)
                .orElseThrow(() ->
                        new NoSuchElementException("Product with ID = " + id + " not found")
                );

        if (request.name() != null)
            product.setName(request.name());

        if (request.description() != null)
            product.setDescription(request.description());

        if (request.price() != null)
            product.setPrice(request.price());

        return productMapper.mapToResponse(productRepository.save(product));
    }


    // soft delete the same category
    @Override
    public void deleteProduct(Integer id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() ->
                        new NoSuchElementException("Product with ID = " + id + " does not exist")
                );

        product.setIsDeleted(true);

        productRepository.save(product);
    }
}
