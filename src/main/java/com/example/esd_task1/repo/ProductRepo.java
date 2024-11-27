package com.example.esd_task1.repo;

import com.example.esd_task1.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Long> {
    @Query("SELECT DISTINCT p FROM Product p WHERE p.price BETWEEN :price1 AND :price2 ORDER BY p.price DESC LIMIT :limit")
    List<Product> findByPriceRange(Double price1, Double price2, Integer limit);
}
