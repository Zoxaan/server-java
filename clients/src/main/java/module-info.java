module com.example.clients {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.dlsc.formsfx;
    requires lombok;
    requires com.google.gson;
    requires okhttp3;
    requires annotations;


    opens com.example.clients to javafx.fxml;
    exports com.example.clients;
exports com.example.clients.entity;

opens com.example.clients.entity to com.google.gson;
exports com.example.clients.controller;
    opens com.example.clients.controller to javafx.fxml;

    exports com.example.clients.response;
    opens com.example.clients.response to com.google.gson;
}