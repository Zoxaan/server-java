package ru.biponline.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.biponline.demo.entity.ClientsEntity;
import ru.biponline.demo.entity.OrdersEntity;
import ru.biponline.demo.entity.ProductsEntity;
import ru.biponline.demo.response.BaseResponse;
import ru.biponline.demo.response.ClientsListResponse;
import ru.biponline.demo.response.OrdersListResponse;
import ru.biponline.demo.response.ProductsListResponse;
import ru.biponline.demo.service.OrdersService;
import ru.biponline.demo.utils.OrdersValidationUtils;

import javax.validation.executable.ValidateOnExecution;
import javax.xml.crypto.Data;
import java.sql.Date;

@RestController
@RequestMapping("api/v1/orders")
public class OrdersController {
    private OrdersService service;


    private OrdersController(OrdersService service){ this.service = service; }

    @GetMapping("/all")
    public ResponseEntity<BaseResponse> getAll(){
        return ResponseEntity.ok(new OrdersListResponse(service.getAll()));
    }


    @ValidateOnExecution
    @PostMapping("/add")
    public ResponseEntity<BaseResponse> add(@RequestBody OrdersEntity data){
        try {
            OrdersValidationUtils.ordersValidationUtils(data);
            service.save(data);
            return ResponseEntity.ok(new BaseResponse(true,"Заказ добавлен"));
        } catch (Exception e){
            return ResponseEntity. badRequest().body(new BaseResponse(false,e.getMessage()));
        }
    }


    @PostMapping("/update")
    public ResponseEntity <BaseResponse> update(@RequestBody OrdersEntity data){
        try {
            service.save(data);
            return ResponseEntity.ok(new BaseResponse(true, "В заказ внесены изменения"));
        } catch (Exception e) {
            return ResponseEntity. badRequest().body(new BaseResponse(false,e.getMessage()));
        }
    }


    @DeleteMapping("/delete")
    public ResponseEntity <BaseResponse> delete(@RequestParam Long id){
        try {
            service.delete(id);
            return ResponseEntity.ok(new BaseResponse(true, "Заказ успешно удален"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, "не найдено"));
        }
    }
    @GetMapping()
    public ResponseEntity<BaseResponse> getProducts(@RequestParam String name){
        return ResponseEntity.ok(new OrdersListResponse(service.getName(name)));
    }
    @GetMapping("/datetime")
    public ResponseEntity<BaseResponse> findByData(@RequestParam String data) {
        try {
            Iterable<OrdersEntity> dat = service.findByData(data);
            if (dat.iterator().hasNext())
                return ResponseEntity.ok(new OrdersListResponse(service.findByData(data)));
            else
                return ResponseEntity.ok(new BaseResponse(false, "По такой дате, заказа не существует"));
        } catch (Exception e) {
            return ResponseEntity.ok(new OrdersListResponse(service.findByData(data)));
        }
    }
    @GetMapping("/orders")
    public ResponseEntity<BaseResponse> findByOrders(@RequestParam String orders) {
        try {
            Iterable<OrdersEntity> productc = service.findByOrders(orders);
            if (productc.iterator().hasNext())
                return ResponseEntity.ok(new OrdersListResponse(service.findByOrders(orders)));
            else
                return ResponseEntity.ok(new BaseResponse(true,"Данные не найдены"));
        }catch (Exception e){
            return ResponseEntity.ok(new OrdersListResponse(service.findByOrders(orders)));
        }
    }
}
