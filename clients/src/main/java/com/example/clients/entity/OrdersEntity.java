package com.example.clients.entity;

import lombok.Data;

@Data
public class OrdersEntity {
private Long id;
private String orders;
private String data;
private ClientsEntity clients;
private ProductsEntity products;
}
