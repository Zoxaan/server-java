package com.example.demo.service;

import com.example.demo.entity.Opoves;
import com.example.demo.repo.OpovesRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class Opoveservice {
        private final OpovesRepo opovesRepo;

        public Opoveservice(OpovesRepo opovesRepo) {
            this.opovesRepo = opovesRepo;
        }

        public Opoves save (Opoves opoves){
            return opovesRepo.save(opoves);
        }
        public  void delete(Long id){
            this.opovesRepo.deleteById(id);
        }
        public Optional<Opoves> getById(Long id){
            return opovesRepo.findById(id);
        }
        public List<Opoves> getALLopoves(){
            return opovesRepo.findAll();
        }
}
