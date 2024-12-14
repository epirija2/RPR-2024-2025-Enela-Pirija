package controller;

import model.Predmet;
import view.PredmetView;

import java.util.List;

public class PredmetController {
    private Predmet model;
    private PredmetView view;

    public PredmetController(Predmet model, PredmetView view) {
        setModel(model);
        setView(view);
    }

    public Predmet getModel() {
        return model;
    }

    public void setModel(Predmet model) {
        this.model = model;
    }

    public PredmetView getView() {
        return view;
    }

    public void setView(PredmetView view) {
        this.view = view;
    }

    public void azurirajNazivPredmeta() {
        try {
            model.setNaziv(view.getUlazniTekstZaNaziv());
            view.setPoruka("Naziv predmeta je uspjesno azuriran!");
        }
        catch (Exception e) {
            view.setPoruka("Greska: " + e.getMessage());
        }
    }

    public void azurirajECTS() {
        try {
            model.setECTS(view.getUlazniTekstZaECTS());
            view.setPoruka("ECTS bodovi su uspjesno azurirani!");
        }
        catch (Exception e) {
            view.setPoruka("Greska: " + e.getMessage());
        }
    }

    public void dajOsobeIzDatoteke(String filePath) {
        try {
            List<Predmet> predmeti = Predmet.ucitajPredmeteIzTxtDatoteke(filePath);
            String poruka = "Predmeti ucitani iz datoteke su:\n";
            for (Predmet p : predmeti) {
                poruka += p.toString() + "\n";
            }
            view.setPoruka(poruka);
        }
        catch(Exception e) {
            view.setPoruka("Greska: " + e.getMessage());
        }
    }
}
