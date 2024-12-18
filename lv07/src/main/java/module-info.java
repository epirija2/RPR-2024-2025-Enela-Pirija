module com.example.lv07 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.xml;

    opens com.example.lv07 to javafx.fxml;
    exports com.example.lv07;
    exports com.example.lv07.model;
}
