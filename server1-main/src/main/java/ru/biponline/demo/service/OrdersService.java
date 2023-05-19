package ru.biponline.demo.service;

import org.springframework.stereotype.Service;

import ru.biponline.demo.entity.ClientsEntity;
import ru.biponline.demo.entity.OrdersEntity;
import ru.biponline.demo.entity.ProductsEntity;
import ru.biponline.demo.repo.OrdersRepo;

import java.util.Date;

@Service
public class OrdersService {
    private final OrdersRepo repo;
    public OrdersService(OrdersRepo repo) {
        this.repo = repo;
    }
    public Iterable<OrdersEntity> findByData (String data) { return  repo.findByData(data); }
    public void save(OrdersEntity orders) {repo.save(orders);}
    public void delete(Long id){repo.deleteById(id);}
    public Iterable<OrdersEntity> getAll(){return repo.findAll();}
    public Iterable<OrdersEntity> getName(String name){
        return repo.findByClients_name(name); }
    public Iterable<OrdersEntity> findByOrders (String  orders) { return  repo.findByOrders(orders); }
}
