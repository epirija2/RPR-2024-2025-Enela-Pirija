module com.example.lv09_2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.lv09_2.controller to javafx.fxml;
    exports com.example.lv09_2;
}