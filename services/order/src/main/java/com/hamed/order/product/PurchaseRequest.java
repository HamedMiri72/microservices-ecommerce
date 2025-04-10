package com.hamed.order.product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PurchaseRequest(

        @NotNull(message = "product is mendatory")
        Integer productId,

        @Positive(message = "quantity is mendatory")
        double quantity

) {
}
