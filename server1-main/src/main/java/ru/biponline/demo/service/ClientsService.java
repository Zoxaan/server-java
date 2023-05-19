package ru.biponline.demo.service;

import org.springframework.stereotype.Service;
import ru.biponline.demo.entity.ClientsEntity;
import ru.biponline.demo.entity.ProductsEntity;
import ru.biponline.demo.repo.ClientsRepo;

@Service
public class ClientsService {
    private final ClientsRepo repo;
    public ClientsService(ClientsRepo repo) {
        this.repo = repo;
    }
    public void save(ClientsEntity clients) {repo.save(clients);}
    public void delete(Long id){repo.deleteById(id);}
    public Iterable<ClientsEntity> getAll(){return repo.findAll();}
    public Iterable<ClientsEntity> findByName (String  name) { return  repo.findByName(name); }
}
