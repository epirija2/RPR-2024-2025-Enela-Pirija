package com.example.lv08_2.controller;

import com.example.lv08_2.model.Predmet;
import com.example.lv08_2.model.PredmetModel;
import com.example.lv08_2.view.PredmetView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
    private Button dodajPredmetButton;
    @FXML
    private Label porukaLabel;
    private ObservableList<Predmet> predmetiObservableList =
            FXCollections.observableArrayList();

    public PredmetController(PredmetModel model) {
        this.model = model;
    }

    public void azurirajECTS(String naziv) {
        try {
            model.azurirajPredmet(naziv, view.getUlazniTekst());
            view.setPoruka("ECTS bodovi su uspjesno azurirani!");
        }
        catch (Exception e) {
            view.setPoruka("Greska: " + e.getMessage());
        }
    }

    public Predmet dajPredmetPoNazivu(String naziv){
        Predmet predmet = model.dajPredmetPoNazivu(naziv);
        if (predmet == null) view.setPoruka("Predmet nije pronadjen!");
        return predmet;
    }

    public void dajOsobeIzTxtDatoteke(String putanjaDoDatoteke) {
        try {
            List<Predmet> predmeti = PredmetModel.napuniPodatkeIzTxtDatoteke(putanjaDoDatoteke);
            String poruka = "Predmeti ucitani iz txt datoteke su:\n";
            for (Predmet predmet : predmeti) {
                poruka += predmet.toString() + "\n";
            }
            view.setPoruka(poruka);
        }
        catch(Exception e) {
            view.setPoruka("Greska: " + e.getMessage());
        }
    }

    @FXML
    public void initialize() {

        // Event handler za dugme "Dodaj Predmet"
        dodajPredmetButton.setOnAction(event -> {
            // Dohvat unesenih podataka
            String naziv = nazivField.getText();
            String ectsText = ECTSField.getText();

            // Validacija
            if (naziv.isEmpty() || ectsText.isEmpty()) {
                porukaLabel.setVisible(true);
                porukaLabel.setText("Sva polja moraju biti popunjena!");
                return;
            }
            // Pretvaranje ECTS-a u broj
            double ECTS = Double.parseDouble(ectsText);

            // Kreiranje novog predmeta i dodavanje u listu (iz modela)
            porukaLabel.setVisible(true);
            porukaLabel.setText(model.dodajPredmet(naziv, ECTS));

            // Ispis svih predmeta u konzolu
            for(Predmet predmet : model.dajSvePredmete())
                System.out.println(predmet.toString());

            // Očistiti polja za unos
            nazivField.clear();
            ECTSField.clear();

        });
    }


}