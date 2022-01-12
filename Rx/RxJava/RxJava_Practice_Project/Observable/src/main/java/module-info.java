odule com.example.observable {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.observable to javafx.fxml;
    exports com.example.observable;
}