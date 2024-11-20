import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    private static Student s;
    @BeforeAll
    static void beforeAll() {
        s = new Student("Ime", "Prezime", "Zmaja od Bosne bb", new Date(1998, 12, 13),
                "18709", 2, 6.65);
    }

    @Test
    void dajInformacije() {
        String ocekivano = "Student: Ime Prezime, broj indeksa: 18709";
        assertEquals(ocekivano, s.DajInformacije());
    }
}
