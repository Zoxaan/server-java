package ru.biponline.demo.response;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import ru.biponline.demo.entity.OrdersEntity;

@Data
@RequiredArgsConstructor
public class OrdersListResponse extends BaseResponse {
    public OrdersListResponse(Iterable<OrdersEntity> data) {
        super(true, "Список заказов:");
        this.data=data;


    }
    private Iterable<OrdersEntity> data;
}
