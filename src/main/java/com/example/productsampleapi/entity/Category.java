package com.example.productsampleapi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "category_tbl")
@Table(name = "category_tbl")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private Boolean isDeleted = false;
    private String icon; // store icon url


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_category_id")
    private Category parentCategory;

    // one category can have many products
    @OneToMany(mappedBy = "category")
    private List<Product> products;


    @OneToMany(mappedBy = "parentCategory")
    private List<Category> subCategories = new ArrayList<>();
}
