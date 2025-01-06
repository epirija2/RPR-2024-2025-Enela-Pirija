package com.example.lv09_2.controller;

import com.example.lv09_2.model.Predmet;
import com.example.lv09_2.model.PredmetModel;
import com.example.lv09_2.view.PredmetView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class PredmetController {
    private PredmetModel model;
    private PredmetView view;
    @FXML
    private TextField nazivField;
    @FXML
    private TextField ECTSField;
    @FXML
    private Button prikaziPredmetButton;
    @FXML
    private ChoiceBox<Integer> idChoiceBox;


    public PredmetController(PredmetModel model) {
        this.model = model;
    }

    @FXML
    public void initialize() {
        PredmetModel.kreirajTabeluAkoNePostoji();
        PredmetModel.isprazniTabeluPredmeta();
        PredmetModel.napuniInicijalnimPodacima();

        idChoiceBox.getItems().addAll(1, 2, 3);

        idChoiceBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dajPredmet();
            }});

    }

    private void dajPredmet() {
        Integer id = idChoiceBox.getValue();
        Predmet predmet = PredmetModel.dajPredmetPoId(id);
        nazivField.setText(predmet.getNaziv());
        ECTSField.setText(String.valueOf(predmet.getECTS()));
    }


}