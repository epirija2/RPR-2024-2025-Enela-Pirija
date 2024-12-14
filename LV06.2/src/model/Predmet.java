package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Predmet {
    private String naziv;
    private Double ECTS;

    public Predmet(String naziv, Double ECTS) throws IllegalArgumentException {
        setNaziv(naziv);
        setECTS(ECTS);
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) throws IllegalArgumentException {
        if (naziv == null || naziv.length() < 5 || naziv.length() > 100)
            throw new IllegalArgumentException("Naziv mora imati izmedju 5 i 100 znakova.");
        this.naziv = naziv;
    }

    public Double getECTS() {
        return ECTS;
    }

    public void setECTS(Double ECTS) throws IllegalArgumentException {
        if (ECTS < 5.0 || ECTS > 20.0 ||
                ( (int)((ECTS - ECTS.intValue()) * 10) != 5 && (int)((ECTS - ECTS.intValue()) * 10) != 0) )
            throw new IllegalArgumentException("ECTS mora biti izmedju 5.0 i 20.0 i može imati samo 0 ili 5 kao vrijednost prve decimale");
        this.ECTS = ECTS;
    }

    public static List<Predmet> ucitajPredmeteIzTxtDatoteke(String putanjaDoDatoteke) throws IOException {
        List<Predmet> predmeti = new ArrayList<>();
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

    @Override
    public String toString() {
        return "Naziv predmeta: " + getNaziv() + ", ECTS: " + getECTS();
    }
}
