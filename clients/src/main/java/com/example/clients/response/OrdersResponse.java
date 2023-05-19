package com.example.clients.response;

import com.example.clients.entity.OrdersEntity;
import lombok.Data;

@Data
public class OrdersResponse extends BaseResponse     {
    public OrdersResponse(boolean success, String message, OrdersEntity orders) {
        super(success, message);
        this.orders = orders;
    }
    public OrdersResponse(OrdersEntity products){
        super(true,"Orders Data");
    }
    private OrdersEntity orders;
}