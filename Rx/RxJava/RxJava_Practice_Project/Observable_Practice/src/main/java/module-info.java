module com.example.observable_practice {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.observable_practice to javafx.fxml;
    exports com.example.observable_practice;
}