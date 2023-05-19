package com.example.clients.controller;

import com.example.clients.entity.ClientsEntity;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.clients.controller.AddClientsController.addClients;
import static com.example.clients.controller.HelloController.*;
import static com.example.clients.controller.HelloController.gson;

public class EditClientsController {
    @FXML
    private TextField clientsLastname_field;
    @FXML
    private TextField clientsName_field;
    @FXML
    private TextField clientsSurname_field;
    private Stage editClientsStage;
    private ClientsEntity clients;
    private int clientsID;
    private boolean okClicked = false;

    public void setDialogStage (Stage dialogStage) {this.editClientsStage = dialogStage;}
    @FXML
    private void handleCancel() {editClientsStage.close();}
    @FXML
    private void handleOk() throws IOException {
        if (isInputValid()) {
            clients.setLastname(clientsLastname_field.getText());
            clients.setName(clientsName_field.getText());
            clients.setSurname(clientsSurname_field.getText());

            okClicked = true;
            editClientsStage.close();
            clientsData.set(clientsID, clients);
            updateClients(clients);
        }
    }
    public void setLabels(ClientsEntity clientsIn, int clients_id) {
        this.clients = clientsIn;
        this.clientsID = clients_id;

        clientsLastname_field.setText(clients.getLastname());
        clientsName_field.setText(clients.getName());
        clientsSurname_field.setText(clients.getSurname());
    }
    private boolean isInputValid() {
        String errorMessage = "";

        try {
            if (clientsName_field.getText() == null || clientsName_field.getText().length() == 0) errorMessage = "Не обнаружена Имя клиента!\n";
            if (!clientsName_field.getText().matches("^[A-ЯЁ][а-яё]+$") ||clientsName_field.getText() == null || clientsName_field.getText().length() == 0) errorMessage += "Некорректное Имя!\n";
            if (clientsLastname_field.getText() == null || clientsLastname_field.getText().length() == 0) errorMessage = "Не обнаружено Фамилия клиента!\n";
            if (!clientsLastname_field.getText().matches("^[A-ЯЁ][а-яё]+$") ||clientsLastname_field.getText() == null || clientsLastname_field.getText().length() == 0) errorMessage += "Некорректная Фамилия!\n";
            if (clientsSurname_field.getText() == null || clientsSurname_field.getText().length() == 0) errorMessage = "Не обнаружено Отчество клиента !\n";
            if (!clientsSurname_field.getText().matches("^[A-ЯЁ][а-яё]+$") ||clientsSurname_field.getText() == null || clientsSurname_field.getText().length() == 0) errorMessage += "Некорректное Отчество!\n";
        }catch (Exception e) {
            System.out.println(e);
            errorMessage += "Пустое поле!";
        }

        if (errorMessage.length() == 0) return true;
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(editClientsStage);
            alert.setTitle("Ошибка заполнения");
            alert.setHeaderText("Пожалуйста, укажите корректные значения текстовых полей");
            alert.setContentText(errorMessage);
            alert.showAndWait();
            return false;
        }
    }
    public boolean isOkClicked(){return okClicked;}
    public static void updateClients(ClientsEntity clients) throws IOException {
        System.out.println(clients.toString());
//        clients.setId(null);
        http.post(api+"clients/update", gson.toJson(clients).toString());
    }
}
