package ru.biponline.demo.utils;

import lombok.Data;
import ru.biponline.demo.entity.OrdersEntity;
import ru.biponline.demo.exception.ValidationExceptionOrders;

import java.util.Date;

public class OrdersValidationUtils {
    public static void ordersValidationUtils(OrdersEntity orders) throws ValidationExceptionOrders {
        String title = orders.getOrders();
        if (title == null || title.isBlank()) {
            throw new ValidationExceptionOrders("Поле название заказа не должно быть пустым");
        } else if (title.length() < 3 || title.length() > 20){
   throw new ValidationExceptionOrders("Имя должно быть в диапозоне от 3 до 20");
        }
        if (!title.matches("^[A-ЯЁ][а-яё]+$")){
        throw new ValidationExceptionOrders("Название заказа должно начинаться с заглавной буквы и на русском языке");
        }
        if (orders.getClients() == null) {
            throw new ValidationExceptionOrders("нужно выбрать клиента");
        }
        if (orders.getProducts() == null) {
            throw new ValidationExceptionOrders("нужно выбрать товар");
        }

       String date = orders.getData();
            if (date == null || !(date.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}"))) {
               throw new ValidationExceptionOrders("Поле time не соответствует формату (2023-05-05)");
           }
        }

    }

