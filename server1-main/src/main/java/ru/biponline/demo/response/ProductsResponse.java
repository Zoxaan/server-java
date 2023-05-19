package ru.biponline.demo.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.biponline.demo.entity.ProductsEntity;
@Data
@EqualsAndHashCode(callSuper=false)
public class ProductsResponse extends BaseResponse
{
    public ProductsResponse(boolean success, String message, ProductsEntity products)
    {
        super(success,message);
        this.products = products;
    }
    public ProductsResponse(ProductsEntity products)
    {
        super(true,"products");
    }
    private ProductsEntity products;
}
