package com.hamed.product.product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductRequest(
        Integer id,
        @NotNull(message = "Product name is required")
        String name,
        @NotNull(message = "Product Description is required")
        String description,
        @NotNull(message = "Product price is required")
        @Positive(message = "Price should be positive")
        BigDecimal price,
        @Positive(message = "Product quantity should be positive")
        double availableQuantity,
        @NotNull(message = "Product category is required")
        Integer categoryId
) {
}
