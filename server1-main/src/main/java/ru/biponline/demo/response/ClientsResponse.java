package ru.biponline.demo.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.biponline.demo.entity.ClientsEntity;

@Data
@EqualsAndHashCode(callSuper = false)
public class ClientsResponse extends BaseResponse
{
    public ClientsResponse(boolean success, String message, ClientsEntity clients)
    {
        super(success,message);
        this.clients = clients ;
    }
    public ClientsResponse(ClientsEntity clients)
    {
        super(true,"Clients data");
    }
    private ClientsEntity clients;
}
