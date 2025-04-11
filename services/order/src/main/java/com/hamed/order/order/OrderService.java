package com.hamed.order.order;

import com.hamed.order.customer.CustomerClient;
import com.hamed.order.exception.BusinessException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final CustomerClient customerClient;

    private final ProductClient productClient;

    public Integer createOrder(@Valid OrderRequest request) {

        //check the customer --> OpenFeign

        var customer = customerClient.findCustomerById(request.customerId())
                .orElseThrow(() -> new BusinessException("Can not create order:: no customer exists with the provided ID:: " + request.customerId()));


        //Purchase the products --> product-ms (RestTemplate)



        //persist order

        //persist order lines

        //start payment process

        // send the order confirmation ==> notification-ms (kafka)
        return null;
    }
}
