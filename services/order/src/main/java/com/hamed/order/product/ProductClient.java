package com.hamed.order.product;


import com.hamed.order.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.springframework.http.HttpMethod.POST;


@Service
@RequiredArgsConstructor
public class ProductClient {


    @Value("${application.config.product-url}")
    private String productUrl;

    private final RestTemplate restTemplate;



    public List<PurchareResponse> purchaseProducts(
            List<PurchaseRequest> requestBody
    ){
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

        HttpEntity<List<PurchaseRequest>> requestEntity = new HttpEntity<>(requestBody, headers);

        ParameterizedTypeReference<List<PurchareResponse>> responseType =
                new ParameterizedTypeReference<List<PurchareResponse>>() {};

        ResponseEntity<List<PurchareResponse>> responseEntity = restTemplate.exchange(
                productUrl+ "/purchase",
                POST,
                requestEntity,
                responseType
        );

        if(responseEntity.getStatusCode().isError()) {
            throw new BusinessException("An error occured while processing the products purchase!" + responseEntity.getStatusCode());
        }

        return responseEntity.getBody();

        }

}
