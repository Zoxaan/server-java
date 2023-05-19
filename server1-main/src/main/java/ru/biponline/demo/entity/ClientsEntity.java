package ru.biponline.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Data
@Table(name = "clients")
public class ClientsEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @NotBlank(message = "Имя")
    private String name;
    @NotBlank(message = "Фамилия не может быть пустым")
    private String lastname;
    @NotBlank(message = "Отчество не может быть пустым")
    private String surname;
    @JsonIgnore
   @OneToMany(cascade =  CascadeType.ALL,mappedBy = "clients")
    private List<OrdersEntity> orders;
}
