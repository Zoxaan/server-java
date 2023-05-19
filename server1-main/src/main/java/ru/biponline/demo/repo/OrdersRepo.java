package ru.biponline.demo.repo;

import org.springframework.data.repository.CrudRepository;
import ru.biponline.demo.entity.ClientsEntity;
import ru.biponline.demo.entity.OrdersEntity;
import ru.biponline.demo.entity.ProductsEntity;

import java.util.Date;

public interface OrdersRepo extends CrudRepository<OrdersEntity, Long> {
    Iterable<OrdersEntity> findByClients_name(String name);
    Iterable<OrdersEntity> findByData (String data);
    Iterable<OrdersEntity> findByOrders (String orders);

}
