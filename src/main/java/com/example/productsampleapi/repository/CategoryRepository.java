package com.example.productsampleapi.repository;

import com.example.productsampleapi.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Boolean existsByName(String name);

    // find by name method
    List<Category> findByNameContainingIgnoreCase(String name);
}
