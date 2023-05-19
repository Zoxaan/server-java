package ru.biponline.demo.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.biponline.demo.entity.OrdersEntity;

@Data
@EqualsAndHashCode(callSuper = false)
public class OrdersResponse extends BaseResponse
{
    public OrdersResponse(boolean success, String message, OrdersEntity products)
    {
        super(success,message);
        this.products = products;
    }
    public OrdersResponse(OrdersEntity products)
    {
        super(true,"products data");

    }
    private OrdersEntity products;
}
