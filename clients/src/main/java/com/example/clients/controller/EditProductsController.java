package com.example.clients.controller;

import com.example.clients.entity.ProductsEntity;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.clients.controller.HelloController.*;

public class EditProductsController {
    @FXML
    private TextField nameProducts_field;
    @FXML
    private TextField productsProducts_field;
    @FXML
    private TextField categoryProducts_field;
    @FXML
    private TextField materialProducts_field;
    @FXML
    private TextField qanitityProducts_field;

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
            //products.setName(nameProducts_field.getText());
            products.setProducts(productsProducts_field.getText());
            products.setCategory(categoryProducts_field.getText());
            products.setMaterial(materialProducts_field.getText());
            products.setQanitity(qanitityProducts_field.getText());


            okClicked = true;
            editProductsStage.close();
            productsData.set(productsID, products);
            updateProducts(products);
        }
    }

    public void setLabels(ProductsEntity productsIn, int products_id) {
        this.products = productsIn;
        this.productsID = products_id;

        //nameProducts_field.setText(products.getName());
        productsProducts_field.setText(products.getProducts());
        categoryProducts_field.setText(products.getCategory());
        materialProducts_field.setText(products.getMaterial());
        qanitityProducts_field.setText(products.getQanitity());
    }

    private boolean isInputValid() {
        String errorMessage = "";
try {



    if (productsProducts_field.getText() == null || productsProducts_field.getText().length() == 0)
        errorMessage = "Не обнаружен !\n";
    if (!productsProducts_field.getText().matches("^[A-ЯЁ][а-яё]+$") || productsProducts_field.getText() == null || productsProducts_field.getText().length() == 0)
        errorMessage += "Некорректно введено Название товара начинается с заглавной буквы и на русском!\n";
    if (categoryProducts_field.getText() == null || categoryProducts_field.getText().length() == 0)
        errorMessage = "Не обнаружен !\n";
    if (!categoryProducts_field.getText().matches("^[A-ЯЁ][а-яё]+$") || categoryProducts_field.getText() == null || categoryProducts_field.getText().length() == 0)
        errorMessage += "Некорректна введена категория, Она должна начинается с заглавной буквы и на русском!\n";
    if (materialProducts_field.getText() == null || materialProducts_field.getText().length() == 0)
        errorMessage = "Не обнаружен !\n";
    if (!materialProducts_field.getText().matches("^[A-ЯЁ][а-яё]+$") || materialProducts_field.getText() == null || materialProducts_field.getText().length() == 0)
        errorMessage += "Некорректно введен материал, Он должен начинается с заглавной буквы и на русском !\n";
    if (qanitityProducts_field.getText() == null || qanitityProducts_field.getText().length() == 0)
        errorMessage = "Не обнаружен !\n";
    if (!qanitityProducts_field.getText().matches("[\\d1-9]{1,4}") ||qanitityProducts_field.getText() == null || qanitityProducts_field.getText().length() == 0)
        errorMessage += "Некорректно введено количество, должно начинаться с заглавной буквы и на русском!\n";
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

    public static void updateProducts(ProductsEntity products) throws IOException {
        http.put(api+"products/update", gson.toJson(products).toString());
    }
}
