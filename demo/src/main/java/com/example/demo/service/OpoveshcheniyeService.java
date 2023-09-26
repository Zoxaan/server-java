package com.example.demo.service;

import com.example.demo.entity.Opoveshcheniye;
import com.example.demo.repo.OpoveshcheniyeRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class OpoveshcheniyeService {
        private final OpoveshcheniyeRepo opoveshcheniyeRepo;

        public OpoveshcheniyeService(OpoveshcheniyeRepo opoveshcheniyeRepo) {
            this.opoveshcheniyeRepo = opoveshcheniyeRepo;
        }

        public Opoveshcheniye save (Opoveshcheniye opoveshcheniye){
            return opoveshcheniyeRepo.save(opoveshcheniye);
        }
        public  void delete(Long id){
            this.opoveshcheniyeRepo.deleteById(id);
        }
        public Optional<Opoveshcheniye> getById(Long id){
            return opoveshcheniyeRepo.findById(id);
        }
        public List<Opoveshcheniye> getALLopoveshcheniye(){
            return opoveshcheniyeRepo.findAll();
        }
}
