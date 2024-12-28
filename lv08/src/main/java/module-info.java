module com.example.lv08 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.xml;

    opens com.example.lv08.controller to javafx.fxml;
    exports com.example.lv08;
}