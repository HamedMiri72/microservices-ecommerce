package com.hamed.order.orderline;

import com.hamed.order.order.Order;

public class OrderlineMapper {


    public OrderLine toOrderLine(OrderLineRequest request) {

        return OrderLine.builder()
                .id(request.id())
                .quantity(request.quantity())
                .order(
                        Order.builder()
                                .id(request.id())
                                .build()
                )
                .productId(request.productId())
                .build();
    }
}
