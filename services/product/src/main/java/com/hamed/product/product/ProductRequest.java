package com.hamed.product.product;

import java.math.BigDecimal;

public record ProductRequest(
        Integer id,
        String name,
        String Description,
        BigDecimal price,
        double availableQuantity
) {
}
