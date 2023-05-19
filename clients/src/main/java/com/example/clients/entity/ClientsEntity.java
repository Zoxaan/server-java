package com.example.clients.entity;

import lombok.Data;

@Data
public class ClientsEntity {
private long id;
private String name;
private String surname;
private String lastname;
@Override
    public String toString(){
return surname +' '+ name.toUpperCase().charAt(0) + '.' + lastname.toUpperCase().charAt(0) +'.';
}
}
