package ru.biponline.demo.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.biponline.demo.entity.ProductsEntity;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProductsListResponse extends BaseResponse
{
    public ProductsListResponse(Iterable<ProductsEntity>data)
    {
        super(true,"товар");
        this.data = data;
    }
    private Iterable<ProductsEntity>data;
}
