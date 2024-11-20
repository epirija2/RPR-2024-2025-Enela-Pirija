import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
class AsistentTest {
    private static Asistent a;

    @BeforeAll
    static void beforeAll() {
        a = new Asistent("Ime", "Prezime", "Adresa bb", new Date(2001, 12, 12), 150, 2020, "1-01", "2-02", "Ponedjeljak 15:00");
    }

    @Test
    void TestDajInformacijeZaAsistent() {
        String ocekivano = "Ime i prezime: Ime Prezime";
        assertEquals(ocekivano, a.DajInformacije());
    }

    @Test
    void TestProvjeriMaticniBrojZaAsistent() {
        assertTrue(a.ProvjeriMaticniBroj("0101999123456"));
        assertFalse(a.ProvjeriMaticniBroj("3112991123456"));
    }
}

