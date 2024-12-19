package com.example.lv07_3.controller;

import com.example.lv07_3.model.Predmet;
import com.example.lv07_3.model.PredmetModel;
import com.example.lv07_3.view.PredmetView;

import java.util.ArrayList;
import java.util.List;

public class PredmetController {
    private PredmetModel model;
    private PredmetView view;

    public PredmetController(PredmetModel model, PredmetView view) {
        this.model = model;
        this.view = view;
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
}
