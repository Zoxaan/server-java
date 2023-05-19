package com.example.clients.response;

import com.example.clients.entity.OrdersEntity;
import lombok.Data;

import java.util.List;
@Data
public class OrdersListResponse extends BaseResponse {
    public OrdersListResponse(List<OrdersEntity> data) {
        super(true, "Orders");
        this.data = data;
    }
        private List<OrdersEntity> data;

}
