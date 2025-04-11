package com.hamed.order.product;

import java.math.BigDecimal;

public record PurchareResponse(

        Integer productId,
        String name,
        String description,
        BigDecimal price,
        double quantity

) {
}
