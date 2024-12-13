package model;

import org.junit.jupiter.api.BeforeAll;

import java.io.IOException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class OsobaTest {
    private static Osoba o;

    @BeforeAll
    static void beforeAll() {
        Date d = new Date(99, 0, 1);
        o = new Osoba(1, "Ime", "Prezime", "Negdje bb", d,
                "0101999123456", Uloga.STUDENT);
    }

    @org.junit.jupiter.api.Test
    void DaLiJeOsobaIspravnoKreirana() {
        Date d = new Date(99, 0, 1);
        assertEquals(1, o.getId());
        assertEquals("Ime", o.getIme());
        assertEquals("Prezime", o.getPrezime());
        assertEquals("Negdje bb", o.getAdresa());
        assertEquals(d, o.getDatumRodjenja());
        assertEquals("0101999123456", o.getMaticniBroj());
        assertEquals(Uloga.STUDENT, o.getUloga());
    }


    @org.junit.jupiter.api.Test
    void setIme() {
        assertThrows(IllegalArgumentException.class,
                () -> {
            o.setIme("M");
                });
        assertThrows(IllegalArgumentException.class,
                () -> {
            o.setIme("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
                });
        assertThrows(IllegalArgumentException.class,
                () -> {
            o.setIme(null);
                });
    }

    @org.junit.jupiter.api.Test
    void provjeriMaticniBroj() {
        assertTrue(o.ProvjeriMaticniBroj("0101999123456"));
        assertFalse(o.ProvjeriMaticniBroj("121200523456"));
    }

    @org.junit.jupiter.api.Test
    void ucitajOsobeIzTxtDatoteke() {
        assertThrows(IOException.class, () -> {
            Osoba.ucitajOsobeIzTxtDatoteke("nepostojecaPutanja.txt");
        });
    }
}