import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
class ProfesorTest {
    private static Profesor prof;
    @org.junit.jupiter.api.BeforeAll
    static void beforeAll()
    {
        prof = new Profesor("Ime", "Prezime", "", new Date(1988, 12, 21), 150, 2000, "3-00", "red. prof. dr", 50);
    }
    @Test
    void dajInformacije() {
        String ocekivano = "Profesor: red. prof. dr Ime Prezime";
        assertEquals(ocekivano, prof.DajInformacije());
    }
}
