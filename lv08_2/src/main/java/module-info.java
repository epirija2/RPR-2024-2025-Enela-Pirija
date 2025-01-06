module com.example.lv08_2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.lv08_2.controller to javafx.fxml;
    exports com.example.lv08_2;
}