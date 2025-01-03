module com.example.lv09 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.lv09.controller to javafx.fxml;
    exports com.example.lv09;
}