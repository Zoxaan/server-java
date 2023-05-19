package ru.biponline.demo.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.biponline.demo.entity.ProductsEntity;
import ru.biponline.demo.response.BaseResponse;
import ru.biponline.demo.response.ProductsListResponse;
import ru.biponline.demo.service.ProductsService;
import ru.biponline.demo.utils.ValidationUtils;

import java.util.Optional;

import static ru.biponline.demo.utils.ProductsValidationUtils.validationProducts;

@RestController
@RequestMapping("api/v1/products")
public class ProductsController {

    private final ProductsService service;
    public ProductsController(ProductsService service) {this.service = service;}

    @PostMapping("/add")
    public ResponseEntity<BaseResponse> add(@RequestBody ProductsEntity data){
        try {
            validationProducts(data);
            service.save(data);
            return ResponseEntity.ok(new BaseResponse(true, "Товар добавлен") );
        }catch (Exception e){
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        }
    }

    @PostMapping("/update")
    public ResponseEntity<BaseResponse> update(@RequestBody ProductsEntity data){
        try {
            validationProducts(data);
            service.save(data);
            return ResponseEntity.ok(new BaseResponse(true, "Товар изминен"));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        }
    }
    @DeleteMapping("/delete")
    public ResponseEntity<BaseResponse> delete(@RequestParam Long id) {
        try {
                service.delete(id);
            return ResponseEntity.ok(new BaseResponse(true,"Удалено"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, "не найдено"));
        }
    }


    @GetMapping("/all")
    public ResponseEntity<BaseResponse> getAll(){return ResponseEntity.ok(new ProductsListResponse(service.getAll())); }

    @GetMapping("/products")
    public ResponseEntity<BaseResponse> findByProducts(@RequestParam String products) {
        try {
            Iterable<ProductsEntity> product = service.findByProducts(products);
            if (product.iterator().hasNext())
                return ResponseEntity.ok(new ProductsListResponse(service.findByProducts(products)));
            else
                return ResponseEntity.ok(new BaseResponse(true,"Данные не найдены"));
        }catch (Exception e){
            return ResponseEntity.ok(new ProductsListResponse(service.findByProducts(products)));
        }
    }
    @GetMapping("/category")
    public ResponseEntity<BaseResponse> findByCategory(@RequestParam String category) {
        try {
            Iterable<ProductsEntity> prod = service.findByCategory(category);
            if (prod.iterator().hasNext())
                return ResponseEntity.ok(new ProductsListResponse(service.findByCategory(category)));
            else
                return ResponseEntity.ok(new BaseResponse(true, "Данные не найдены"));
        } catch (Exception e) {
            return ResponseEntity.ok(new ProductsListResponse(service.findByCategory(category)));
        }
    }
    @GetMapping("/material")
    public ResponseEntity<BaseResponse> findByMaterial(@RequestParam String material) {
        try {
            Iterable<ProductsEntity> produ = service.findByMaterial(material);
            if (produ.iterator().hasNext())
                return ResponseEntity.ok(new ProductsListResponse(service.findByMaterial(material)));
            else
                return ResponseEntity.ok(new BaseResponse(true, "Данные не найдены"));
        } catch (Exception e) {
            return ResponseEntity.ok(new ProductsListResponse(service.findByMaterial(material)));
        }
    }
    @GetMapping("/qanitity")
    public ResponseEntity<BaseResponse> findByQanitity(@RequestParam int qanitity) {
        try {
            Iterable<ProductsEntity> prodc = service.findByQanitity(qanitity);
            if (prodc.iterator().hasNext())
                return ResponseEntity.ok(new ProductsListResponse(service.findByQanitity(qanitity)));
            else
                return ResponseEntity.ok(new BaseResponse(true, "Данные не найдены"));
        } catch (Exception e) {
            return ResponseEntity.ok(new ProductsListResponse(service.findByQanitity(qanitity)));
        }
    }
}
