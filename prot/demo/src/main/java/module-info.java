module com.example {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    // requires com.google.gson;

    opens com.example.view to javafx.fxml;
    opens com.example.model to javafx.fxml;
    opens com.example.controller to javafx.fxml;

    exports com.example;
    exports com.example.controller;
    exports com.example.model; // ⬅️ Esta línea soluciona tu problema
}

