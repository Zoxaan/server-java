package com.example.clients.response;

import com.example.clients.entity.ProductsEntity;
import lombok.Data;

import java.util.Optional;
@Data
public class ProductsResponse extends BaseResponse {
    public ProductsResponse(boolean success, String message, ProductsEntity products) {
        super(success, message);
        this.products = products;
    }
    public ProductsResponse(ProductsEntity products){
        super(true,"Products Data");
    }

    public ProductsResponse(Optional<ProductsEntity> products){
        super(true,"Products Data");
    }
    private ProductsEntity products;
    private Optional<ProductsEntity> products1;
}
