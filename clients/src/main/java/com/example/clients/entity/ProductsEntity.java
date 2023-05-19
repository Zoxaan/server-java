package com.example.clients.entity;

import lombok.Data;

@Data
public class ProductsEntity {
    private Long id;
    private String name;
    private String products;
    private String category;
    private String material;
    private String qanitity;
    @Override
    public String toString() {
        return products;
    }
}
