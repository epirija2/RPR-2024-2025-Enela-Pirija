package com.example.lv07_3;

import com.example.lv07_3.controller.PredmetController;
import com.example.lv07_3.model.PredmetModel;
import com.example.lv07_3.view.PredmetView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        //launch();
        PredmetModel predmetModel = new PredmetModel();
        predmetModel.napuni();

        PredmetView predmetView = new PredmetView();
        predmetView.setUlazniTekst(7.0);

        PredmetController predmetController = new PredmetController(predmetModel, predmetView);
        predmetController.azurirajECTS("Razvoj programskih rjesenja");

        System.out.println("1) View ispisuje: " + predmetView.getPoruka());
        System.out.println("   Azurirani predmet je: " + predmetController.dajPredmetPoNazivu("Razvoj programskih rjesenja").toString());


        predmetController.dajOsobeIzTxtDatoteke("src/data/predmeti.txt");
        System.out.println("2) View ispisuje: " + predmetView.getPoruka());

    }
}