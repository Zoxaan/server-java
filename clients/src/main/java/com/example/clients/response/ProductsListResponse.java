package com.example.clients.response;

import com.example.clients.entity.ProductsEntity;
import lombok.Data;

import java.util.List;

@Data

public class ProductsListResponse extends BaseResponse {
    public ProductsListResponse(List<ProductsEntity> data) {
        super(true, "Products");
        this.data = data;
    }
    private List<ProductsEntity> data;
}
