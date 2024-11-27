package com.example.esd_task1.mapper;

import com.example.esd_task1.dto.ProductRequest;
import com.example.esd_task1.dto.ProductResponse;
import com.example.esd_task1.entity.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {
    public Product requestToEntity(ProductRequest productRequest) {
        return Product.builder()
                .name(productRequest.productName())
                .price(productRequest.price())
                .build();
    }

    public ProductResponse entityToResponse(Product product) {
        return new ProductResponse(product.getName(), product.getPrice());
    }
}
