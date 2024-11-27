package com.example.esd_task1.service;

import lombok.RequiredArgsConstructor;
import com.example.esd_task1.dto.ProductRequest;
import com.example.esd_task1.dto.ProductResponse;
import com.example.esd_task1.entity.Product;
import com.example.esd_task1.exception.ProductNotFoundException;
import com.example.esd_task1.mapper.ProductMapper;
import com.example.esd_task1.repo.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepo repo;
    private final ProductMapper mapper;

    public String createProduct(ProductRequest request) {
        Product product = mapper.requestToEntity(request);
        repo.save(product);
        return "Product created";
    }

    public List<ProductResponse> getAllProducts(Double lowPrice, Double highPrice, Integer limit) {
        return repo.findByPriceRange(lowPrice, highPrice, limit)
                .stream()
                .map(mapper::entityToResponse)
                .toList();
    }

    public ProductResponse updateProduct(Long productId, ProductRequest request) {
        Product selectedProduct = repo.findById(productId).orElse(null);
        if (selectedProduct == null) throw new ProductNotFoundException("product id");
        selectedProduct.setName(request.productName());
        selectedProduct.setPrice(request.price());

        Product updatedProduct = repo.save(selectedProduct);

        return mapper.entityToResponse(updatedProduct);
    }

    public void deleteProduct(Long productId) {
        Product selectedProduct = repo.findById(productId).orElse(null);
        if (selectedProduct == null) throw new ProductNotFoundException("product id");
        repo.delete(selectedProduct);
    }

    public ProductResponse getProduct(Long productId) {
        Product selectedProduct = repo.findById(productId).orElse(null);
        if (selectedProduct == null) throw new ProductNotFoundException("product id");
        return mapper.entityToResponse(selectedProduct);
    }
}
