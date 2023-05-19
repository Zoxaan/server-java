package com.example.clients.controller;

import com.example.clients.entity.ClientsEntity;

import com.example.clients.entity.OrdersEntity;
import com.example.clients.entity.ProductsEntity;
import javafx.collections.FXCollections;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.clients.controller.HelloController.*;


public class EditOrdersController {
    @FXML
    private TextField ordersName_field;
    @FXML
    private ComboBox<ClientsEntity> ordersNameClient_field;
    @FXML
    private ComboBox<ProductsEntity> ordersNameProducts_field;
    @FXML
    private TextField orderData_field;

    private Stage editOrderStage;
    private OrdersEntity orders;
    private int ordersID;
    private boolean okClicked = false;
    private ObservableList<ClientsEntity> clientsOrderData = FXCollections.observableArrayList();
    private ObservableList<ProductsEntity> productsOrderData = FXCollections.observableArrayList();

    public void setDialogStage (Stage dialogStage) {this.editOrderStage = dialogStage;}

    @FXML
    private void handleCancel() {editOrderStage.close();}

    @FXML
    private void handleOk() throws IOException {
        if (isInputValid()) {
            orders.setOrders(ordersName_field.getText());
            orders.setClients(ordersNameClient_field.getValue());
            orders.setProducts(ordersNameProducts_field.getValue());
            orders.setData(orderData_field.getText());

            okClicked = true;
            editOrderStage.close();
            ordersData.set(ordersID, orders);
            updateOrders(orders);
        }
    }
    private void updateMap(){
        clientsOrderData.addAll(clientsData);
        productsOrderData.addAll(productsData);
    }
    @FXML
    void initialize() throws Exception {
        if (clientsOrderData.size() != clientsData.size() || productsOrderData.size() != productsData.size()){
            updateMap();
        }
        updateComboBox();
    }

    private void updateComboBox() throws Exception {
        ordersNameClient_field.getItems().addAll(clientsOrderData);
        ordersNameProducts_field.getItems().addAll(productsOrderData);
    }
    private boolean isInputValid() {

        String errorMessage = "";
        if (!ordersName_field.getText().matches("^[A-ЯЁ][а-яё]+$") ||ordersName_field.getText() == null || ordersName_field.getText().length() == 0) errorMessage += "Некорректное значение названия заказа!\n";
        if (ordersNameClient_field.getValue() == null || ordersNameClient_field.getValue().hashCode() == 0) errorMessage += "Не обнаружено Имя клиента!\n";
        if (ordersNameProducts_field.getValue() == null || ordersNameProducts_field.getValue().hashCode() == 0) errorMessage += "Не обнаружен Товар!\n";
        if (orderData_field.getText() == null || orderData_field.getText().length() == 0) errorMessage += "Не обнаружена дата заказа!\n";

        if (!orderData_field.getText().matches("[0-9]{4}-[0-9]{2}-[0-9]{2}") || orderData_field.getText() == null) errorMessage += "Дата  введенна некорректно! \n";
        if (errorMessage.length() == 0) return true;
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(editOrderStage);
            alert.setTitle("Oops!");
            alert.setHeaderText("Пожалуйста, укажите корректные значения текстовых полей");
            alert.setContentText(errorMessage);

            alert.showAndWait();
            return false;
        }
    }
    public void setLabels(OrdersEntity ordersIn, int orders_id) {
        this.orders = ordersIn;
        this.ordersID = orders_id;

        ordersName_field.setText(orders.getOrders());
        ordersNameClient_field.setValue(orders.getClients());
        ordersNameProducts_field.setValue(orders.getProducts());
        orderData_field.setText(String.valueOf(orders.getData()));
    }
    public boolean isOkClicked(){return okClicked;}
}
