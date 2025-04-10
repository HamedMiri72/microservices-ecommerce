package com.hamed.product.product;

import jakarta.validation.constraints.NotNull;

public record ProductPurchaseRequest(
        @NotNull(message = "product id is required")
        Integer productId,
        @NotNull(message = "quantity is required")
        double quantity
) {
}
