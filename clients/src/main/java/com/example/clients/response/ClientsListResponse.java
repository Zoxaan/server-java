package com.example.clients.response;

import com.example.clients.entity.ClientsEntity;
import lombok.Data;

import java.util.List;

@Data

public class ClientsListResponse extends BaseResponse {
    public ClientsListResponse(List<ClientsEntity> data) {
        super(true, "Clients");
        this.data = data;
    }
    private List<ClientsEntity> data;
}
