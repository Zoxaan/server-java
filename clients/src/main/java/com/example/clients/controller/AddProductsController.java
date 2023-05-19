package com.example.clients.controller;

import com.example.clients.entity.ProductsEntity;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.clients.controller.HelloController.*;

public class AddProductsController {
    //@FXML
   // private TextField productsName_field;
    @FXML
    private TextField productsProducts_field;
    @FXML
    private TextField productsCategory_field;
    @FXML
    private TextField productsMaterial_field;
    @FXML
    private TextField productsQanitity_field;

    private Stage editProductsStage;
    private ProductsEntity products;
    private int productsID;
    private boolean okClicked = false;

    public void setDialogStage (Stage dialogStage) {this.editProductsStage = dialogStage;}
    @FXML
    private void handleCancel() {editProductsStage.close();}
    @FXML
    private void handleOk() throws IOException {
        if (isInputValid()) {
           // products.setName(productsName_field.getText());
            products.setProducts(productsProducts_field.getText());
            products.setCategory(productsCategory_field.getText());
            products.setMaterial(productsMaterial_field.getText());
            products.setQanitity(productsQanitity_field.getText());


            okClicked = true;
            editProductsStage.close();
            productsData.set(productsID, products);
            addProducts(products);
        }
    }
    public void setLabels(ProductsEntity productsIn, int products_id) {
        this.products = productsIn;
        this.productsID = products_id;

       // productsName_field.setText(products.getProducts());
        productsProducts_field.setText(products.getProducts());
        productsCategory_field.setText(products.getProducts());
        productsMaterial_field.setText(products.getProducts());
        productsQanitity_field.setText(products.getProducts());
    }
    private boolean isInputValid() {
        String errorMessage = "";
try {


      //  if (productsName_field.getText() == null || productsName_field.getText().length() == 0) errorMessage = "Не обнаружено наименование!\n";
   // if (!productsName_field.getText().matches("^[A-ЯЁ][а-яё]+$") ||productsName_field.getText() == null || productsName_field.getText().length() == 0) errorMessage += "Некорректное название!\n";
        if (productsProducts_field.getText() == null || productsProducts_field.getText().length() == 0) errorMessage = "Не обнаружен !\n";
    if (!productsProducts_field.getText().matches("^[A-ЯЁ][а-яё]+$") ||productsProducts_field.getText() == null || productsProducts_field.getText().length() == 0) errorMessage += "Некорректное товар!\n";
        if (productsCategory_field.getText() == null || productsCategory_field.getText().length() == 0) errorMessage = "Не обнаружен !\n";
    if (!productsCategory_field.getText().matches("^[A-ЯЁ][а-яё]+$") ||productsCategory_field.getText() == null || productsCategory_field.getText().length() == 0) errorMessage += "Некорректное категория!\n";
        if (productsMaterial_field.getText() == null || productsMaterial_field.getText().length() == 0) errorMessage = "Не обнаружен !\n";
    if (!productsMaterial_field.getText().matches("^[A-ЯЁ][а-яё]+$") ||productsMaterial_field.getText() == null || productsMaterial_field.getText().length() == 0) errorMessage += "Некорректное материал!\n";
        if (productsQanitity_field.getText() == null || productsQanitity_field.getText().length() == 0) errorMessage = "Не обнаружен !\n";
    if (!productsQanitity_field.getText().matches("[\\d0-9]{1,4}") ||productsQanitity_field.getText() == null || productsQanitity_field.getText().length() == 0) errorMessage += "Некорректное количество!\n";
}catch (Exception e){
    System.out.println(e);
    errorMessage += "Пустое поле!";
}
        if (errorMessage.length() == 0) return true;
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(editProductsStage);
            alert.setTitle("Ошибка заполнения");
            alert.setHeaderText("Пожалуйста, укажите корректные значения текстовых полей");
            alert.setContentText(errorMessage);
            alert.showAndWait();
            return false;
        }
    }
    public boolean isOkClicked(){return okClicked;}
    public static void addProducts(ProductsEntity products) throws IOException {
        System.out.println(products.toString());
        //products.setProducts(null);
        http.post(api+"products/add", gson.toJson(products).toString());
    }
}
