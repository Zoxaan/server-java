package ru.biponline.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Data
@Table(name = "products")
public class ProductsEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message =  "товар")
    private String products;
    @NotBlank(message =  "категория")
    private String category;
    @NotBlank(message =  "материал")
    private String material;
    @NotBlank(message =  "количество")
    private int qanitity;

    @JsonIgnore
    @OneToMany(cascade =  CascadeType.ALL,mappedBy = "products")
    private List<OrdersEntity> orders;
}
