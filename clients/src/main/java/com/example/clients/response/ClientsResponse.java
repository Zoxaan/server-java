package com.example.clients.response;

import com.example.clients.entity.ClientsEntity;
import lombok.Data;

@Data

public class ClientsResponse extends BaseResponse {
    public ClientsResponse(boolean success, String message, ClientsEntity clients) {
        super(success, message);
        this.clients = clients;
    }
    public ClientsResponse(ClientsEntity clients) {
        super(true,"Author Data");
    }
    private ClientsEntity clients;
}
