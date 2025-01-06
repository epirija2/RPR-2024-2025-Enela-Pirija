package com.example.lv08_2.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class PredmetModel {
    private ObservableList<Predmet> predmeti;


    public PredmetModel() {
        predmeti = FXCollections.observableArrayList();
    }

    public String dodajPredmet(String naziv, Double ECTS) {
        try {
            Predmet predmet = new Predmet(naziv, ECTS);
            predmeti.add(predmet);
            return "Predmet je uspjesno dodan!";
        }
        catch(IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    public ObservableList<Predmet> dajSvePredmete() {
        return predmeti;
    }

    public Predmet dajPredmetPoNazivu(String naziv) {
        for (Predmet predmet : predmeti) {
            if (predmet.getNaziv().equals(naziv))
                return predmet;
        }
        return null;
    }

    public String azurirajPredmet(String naziv, Double ECTS) {
        Predmet trazeniPredmet = dajPredmetPoNazivu(naziv);
        if (trazeniPredmet != null) {
            try {
                trazeniPredmet.setECTS(ECTS);
                return "Predmet je uspjesno azuriran!";
            }
            catch(IllegalArgumentException e) {
                return e.getMessage();
            }
        }
        return "Predmet nije pronadjen!";
    }

    public void obrisiPredmet(String naziv) {
        predmeti.removeIf(predmet -> Objects.equals(predmet.getNaziv(), naziv));
    }

    public void napuni() {
        predmeti.add(new Predmet("Razvoj programskih rjesenja", 5.0));
        predmeti.add(new Predmet("Osnove baza podataka", 5.0));
    }

    public static List<Predmet> napuniPodatkeIzTxtDatoteke(String putanjaDoDatoteke) throws IOException {
        List<Predmet> predmeti = FXCollections.observableArrayList();
        BufferedReader reader = new BufferedReader(new FileReader(putanjaDoDatoteke));
        String linija;
        while ( (linija = reader.readLine()) != null) {
            String[] polja = linija.split(",");
            if (polja.length == 2) {
                String naziv = polja[0];
                Double ECTS = Double.parseDouble(polja[1]);
                Predmet predmet = new Predmet(naziv, ECTS);
                predmeti.add(predmet);
            }
        }
        reader.close();
        return predmeti;
    }
}