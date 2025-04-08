package com.hamed.product.product;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    public Integer createProduct(@Valid ProductRequest request) {
        return null;
    }

    public List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> request) {

        return null;
    }

    public ProductResponse findProductById(Integer productId) {
        return null;
    }

    public List<ProductResponse> findAllProducts() {
        return null;
    }
}
