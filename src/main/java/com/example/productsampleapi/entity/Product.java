package com.example.productsampleapi.entity;

import jakarta.persistence.*;
import lombok.*;
import java.nio.channels.FileLock;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "products_tbl")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private Float price;

    @Column(nullable = false)
    private Boolean isDeleted = false;

    private Integer userId; // user that create the product !
    // private Integer categoryId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;
}
