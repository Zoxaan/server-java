package ru.biponline.demo.entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Table (name = "orders")
public class OrdersEntity {
    @Column (name = "orders_id")
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String orders;
    @NotBlank
    private String data;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "clients_id")
    private ClientsEntity clients;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "products_id")
    private ProductsEntity products;
}
