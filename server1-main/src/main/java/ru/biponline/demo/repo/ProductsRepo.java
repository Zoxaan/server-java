package ru.biponline.demo.repo;

import org.springframework.data.repository.CrudRepository;
import ru.biponline.demo.entity.ProductsEntity;

import java.util.Optional;

public interface ProductsRepo extends CrudRepository<ProductsEntity, Long> {
    Optional<ProductsEntity> findById (Long id);
    Iterable<ProductsEntity> findByCategory (String category);
    Iterable<ProductsEntity> findByProducts (String products);
    Iterable<ProductsEntity> findByMaterial (String material);
    Iterable<ProductsEntity> findByQanitity (int qanitity);
}