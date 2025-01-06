package com.example.lv09_2.model;

import javafx.beans.property.*;


public class Predmet {
    private IntegerProperty id;
    private StringProperty naziv;
    private DoubleProperty ECTS;

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public Predmet(Integer id, String naziv, Double ECTS) throws IllegalArgumentException {
        this.id = new SimpleIntegerProperty(id);
        this.naziv = new SimpleStringProperty(naziv);
        this.ECTS = new SimpleDoubleProperty(ECTS);

        setNaziv(naziv);
        setECTS(ECTS);
    }

    public String getNaziv() {
        return naziv.get();
    }

    public StringProperty nazivProperty() {
        return naziv;
    }

    public void setNaziv(String naziv) throws IllegalArgumentException {
        if (naziv == null || naziv.length() < 5 || naziv.length() > 100)
            throw new IllegalArgumentException("Naziv mora imati izmedju 5 i 100 znakova.");
        this.naziv.set(naziv);
    }

    public double getECTS() {
        return ECTS.get();
    }

    public DoubleProperty ECTSProperty() {
        return ECTS;
    }

    public void setECTS(Double ECTS) throws IllegalArgumentException {
        if (ECTS < 5.0 || ECTS > 20.0 ||
                ( (int)((ECTS - ECTS.intValue()) * 10) != 5 && (int)((ECTS - ECTS.intValue()) * 10) != 0) )
            throw new IllegalArgumentException("ECTS mora biti izmedju 5.0 i 20.0 i može imati samo 0 ili 5 kao vrijednost prve decimale");
        this.ECTS.set(ECTS);
    }



    @Override
    public String toString() {
        return "Naziv predmeta: " + getNaziv() + ", ECTS: " + getECTS();
    }
}