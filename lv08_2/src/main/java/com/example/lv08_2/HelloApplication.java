package com.example.lv08_2;

import com.example.lv08_2.controller.PredmetController;
import com.example.lv08_2.model.PredmetModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException
    {
        PredmetModel predmetModel = new PredmetModel();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        fxmlLoader.setController(new PredmetController(predmetModel));
        Scene scene = new Scene(fxmlLoader.load(), 500, 300);
        stage.setTitle("Dodaj predmet!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}