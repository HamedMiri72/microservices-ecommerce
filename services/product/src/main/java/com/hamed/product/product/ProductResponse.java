package com.hamed.product.product;

import com.hamed.product.category.Category.Category;

import java.math.BigDecimal;

public record ProductResponse(
        Integer id,
        String name,
        String description,
        BigDecimal price,
        double availableQuantity,
        Category category
) {
}
