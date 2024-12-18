package com.example.lv07.model;

import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
class OsobaModelTest {

    @Test
    void napuni() {
        OsobaModel osobaModel = new OsobaModel();
        osobaModel.napuni();
        ObservableList<Osoba> osobe = osobaModel.dajSveOsobe();
        Date d = new Date(97,8,25);

        assertEquals(1, osobe.get(0).getId());
        assertEquals("Neko", osobe.get(0).getIme());
        assertEquals("Nekic", osobe.get(0).getPrezime());
        assertEquals("Neka adresa", osobe.get(0).getAdresa());
        assertEquals(d, osobe.get(0).getDatumRodjenja());
        assertEquals("2509997123456", osobe.get(0).getMaticniBroj());
        assertEquals(Uloga.STUDENT, osobe.get(0).getUloga());

        assertEquals(2, osobe.get(1).getId());
        assertEquals("Neko 2", osobe.get(1).getIme());
        assertEquals("Nekic 2", osobe.get(1).getPrezime());
        assertEquals("Neka adresa 2", osobe.get(1).getAdresa());
        assertEquals(d, osobe.get(1).getDatumRodjenja());
        assertEquals("2509997123456", osobe.get(1).getMaticniBroj());
        assertEquals(Uloga.NASTAVNO_OSOBLJE, osobe.get(1).getUloga());
    }

    @Test
    void azurirajOsobu() {
        OsobaModel osobaModel = new OsobaModel();
        osobaModel.napuni();

        //kada id ne postoji
        assertEquals("Osoba nije pronadjena!", osobaModel.azurirajOsobu(3, "Neko","Nekic","Neka adresa", new Date(97,8,25), "2509997123456", Uloga.NASTAVNO_OSOBLJE));

        // azuriranje uloge na nastavno osoblje
        assertEquals("Osoba je uspjesno azurirana!", osobaModel.azurirajOsobu(1, null,null,null, null, null, Uloga.NASTAVNO_OSOBLJE));

        // kada ime nije ispravno
        assertEquals("Ime mora imati izmedju 2 i 50 znakova.", osobaModel.azurirajOsobu(1, "A",null,null, null, null, null));
    }
}