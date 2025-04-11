package com.hamed.order.order;

import com.hamed.order.customer.CustomerClient;
import com.hamed.order.exception.BusinessException;
import com.hamed.order.orderline.OrderLineRequest;
import com.hamed.order.orderline.OrderLineService;
import com.hamed.order.product.ProductClient;
import com.hamed.order.product.PurchaseRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final CustomerClient customerClient;

    private final ProductClient productClient;

    private final OrderRepository repository;

    private final OrderMapper mapper;

    private final OrderLineService orderLineService;

    public Integer createOrder(@Valid OrderRequest request) {

        //check the customer --> OpenFeign

        var customer = customerClient.findCustomerById(request.customerId())
                .orElseThrow(() -> new BusinessException("Can not create order:: no customer exists with the provided ID:: " + request.customerId()));


        //Purchase the products --> product-ms (RestTemplate)

        this.productClient.purchaseProducts(request.products());

        //persist order
        var order = this.repository.save(mapper.toOrder(request));

        //persist order lines for saving order lines

        for(PurchaseRequest purchaseRequest: request.products()){
            orderLineService.saveOrderLine(
                    new OrderLineRequest(
                            null,
                            order.getId(),
                            purchaseRequest.productId(),
                            purchaseRequest.quantity()
                    )
            );
        }

        //start payment process



        // send the order confirmation ==> notification-ms (kafka)
        return null;
    }
}
