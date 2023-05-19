package ru.biponline.demo.service;

import org.springframework.stereotype.Service;
import ru.biponline.demo.entity.ProductsEntity;
import ru.biponline.demo.repo.ProductsRepo;

import java.util.Optional;

@Service
public class ProductsService {
    private final ProductsRepo repo;
    public ProductsService(ProductsRepo repo) {
        this.repo = repo;
    }
    public void save(ProductsEntity products) {repo.save(products);}
    public void delete(Long id) { repo.deleteById(id); }
    public Iterable<ProductsEntity> getAll(){return repo.findAll();}
    public Iterable<ProductsEntity> findByProducts (String  products) { return  repo.findByProducts(products); }
    public Iterable<ProductsEntity> findByCategory (String  category) { return  repo.findByCategory(category); }
    public Iterable<ProductsEntity> findByMaterial (String  material) { return  repo.findByMaterial(material); }
    public Iterable<ProductsEntity> findByQanitity (int  qanitity) { return  repo.findByQanitity(qanitity); }
}
