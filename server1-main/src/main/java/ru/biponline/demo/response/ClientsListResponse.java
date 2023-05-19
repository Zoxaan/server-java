package ru.biponline.demo.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.biponline.demo.entity.ClientsEntity;

@Data
@EqualsAndHashCode(callSuper = false)
public class ClientsListResponse extends BaseResponse
{
    public ClientsListResponse(Iterable<ClientsEntity>data)
    {
        super(true,"клиенты");
        this.data= data;

    }
    private Iterable<ClientsEntity>data;
}
