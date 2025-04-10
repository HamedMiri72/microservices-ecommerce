package com.hamed.product.product;

import com.hamed.product.category.Category;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {
    public Product toProduct(@Valid ProductRequest request) {

        return Product.builder()
                .id(request.id())
                .price(request.price())
                .availableQuantity(request.availableQuantity())
                .name(request.name())
                .description(request.description())
                .category(Category.builder().id(request.categoryId()).build())
                .build();
    }


    public ProductResponse toProductResponse(Product product) {

        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getAvailableQuantity(),
                product.getCategory()
                );
    }


    public ProductPurchaseResponse toProductPurchaseResponse(Product product, @NotNull(message = "quantity is required") double quantity) {
        return new ProductPurchaseResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                quantity
        );
    }
}
