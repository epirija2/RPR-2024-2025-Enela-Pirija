package com.example.lv09;

import com.example.lv09.controller.OsobaController;
import com.example.lv09.model.OsobaModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException
    {
        OsobaModel osobaModel = OsobaModel.getInstance();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        fxmlLoader.setController(new OsobaController(osobaModel));
        Scene scene = new Scene(fxmlLoader.load(), 300, 500);
        stage.setTitle("Dodaj osobu!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
       launch();
    }
}