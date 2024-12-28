package com.example.lv08.model;

import javafx.beans.property.*;

import java.util.Date;

public class Osoba {
    private IntegerProperty id;
    private StringProperty ime, prezime, adresa;
    private ObjectProperty<Date> datumRodjenja;
    private StringProperty maticniBroj;
    private ObjectProperty<Uloga> uloga;

    public Osoba(Integer id, String ime, String prezime, String adresa, Date datumRodjenja, String maticniBroj, Uloga uloga) {
        // inicijalizacija polja
        this.id = new SimpleIntegerProperty(id);
        this.ime = new SimpleStringProperty();
        this.prezime = new SimpleStringProperty(prezime);
        this.adresa = new SimpleStringProperty(adresa);
        this.datumRodjenja = new SimpleObjectProperty<>(datumRodjenja);
        this.maticniBroj = new SimpleStringProperty();
        this.uloga = new SimpleObjectProperty<>(uloga);
        // validacija polja
        setIme(ime);
        setMaticniBroj(maticniBroj);
    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getIme() {
        return ime.get();
    }

    public StringProperty imeProperty() {
        return ime;
    }

    public void setIme(String ime) {
        if (ime == null || ime.length() < 2 || ime.length() > 50) {
            throw new IllegalArgumentException("Ime mora imati izmedju 2 i 50 znakova.");
        }
        this.ime.set(ime);
    }

    public String getPrezime() {
        return prezime.get();
    }

    public StringProperty prezimeProperty() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime.set(prezime);
    }

    public String getAdresa() {
        return adresa.get();
    }

    public StringProperty adresaProperty() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa.set(adresa);
    }

    public Date getDatumRodjenja() {
        return datumRodjenja.get();
    }

    public ObjectProperty<Date> datumRodjenjaProperty() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja.set(datumRodjenja);
    }

    public String getMaticniBroj() {
        return maticniBroj.get();
    }

    public StringProperty maticniBrojProperty() {
        return maticniBroj;
    }

    public void setMaticniBroj(String maticniBroj) {
        if (maticniBroj == null || maticniBroj.trim().isEmpty() || maticniBroj.length() != 13) {
            throw new IllegalArgumentException("Maticni broj mora imati tacno 13 karaktera");
        }
        else if(!ProvjeriMaticniBroj(maticniBroj)){
            throw new IllegalArgumentException("Maticni broj se ne poklapa sa datumom rodjenja!");
        }
        this.maticniBroj.set(maticniBroj);
    }

    public Uloga getUloga() {
        return uloga.get();
    }

    public ObjectProperty<Uloga> ulogaProperty() {
        return uloga;
    }

    public void setUloga(Uloga uloga) {
        this.uloga.set(uloga);
    }

    public boolean ProvjeriMaticniBroj(String maticniBroj) {
        Date date = datumRodjenja.get();
        boolean danIsti = date.getDate() == Integer.parseInt(maticniBroj.substring(0, 2)), mjesecIsti = date.getMonth() + 1 == Integer.parseInt(maticniBroj.substring(2, 4)), godinaIsta = date.getYear() + 900 == Integer.parseInt(maticniBroj.substring(4, 7));
        return (danIsti && mjesecIsti && godinaIsta);
    }

    @Override
    public String toString () {
        return "Osoba{" +
                "id=" + id.get() +
                ", ime=" + ime.get() +
                ", prezime=" + prezime.get() +
                ", adresa=" + adresa.get() +
                ", datumRodjenja=" + datumRodjenja.get() +
                ", maticniBroj=" + maticniBroj.get() +
                ", uloga=" + uloga.get() +
                '}';
    }
}
