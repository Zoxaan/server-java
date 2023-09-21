module com.example.practic {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.practic to javafx.fxml;
    exports com.example.practic;
}