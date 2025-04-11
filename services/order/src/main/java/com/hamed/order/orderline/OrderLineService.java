package com.hamed.order.orderline;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderLineService {


    private final orderLineRepository repository;

    private final OrderlineMapper mapper;

    public Integer saveOrderLine(OrderLineRequest request) {

        var order  = mapper.toOrderLine(request);

        return repository.save(order).getId();
    }
}
