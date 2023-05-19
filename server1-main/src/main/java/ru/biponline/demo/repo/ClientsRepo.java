package ru.biponline.demo.repo;

import org.springframework.data.repository.CrudRepository;
import ru.biponline.demo.entity.ClientsEntity;
import ru.biponline.demo.entity.ProductsEntity;

public interface ClientsRepo extends CrudRepository<ClientsEntity, Long> {
    Iterable<ClientsEntity> findByName (String name);
}