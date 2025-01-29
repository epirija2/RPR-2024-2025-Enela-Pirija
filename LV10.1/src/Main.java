import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {

    private static final int VELICINA_KOLEKCIJE = 100_000_000;
    private static final int BROJ_NITI = 16;

    public static void main(String[] args) {
        int[] kolekcija = new int[VELICINA_KOLEKCIJE];
        Random random = new Random();

        // Popunjavanje kolekcije nasumičnim vrijednostima
        for (int i = 0; i < VELICINA_KOLEKCIJE; i++) {
            kolekcija[i] = random.nextInt(VELICINA_KOLEKCIJE);
        }

        int element = kolekcija[random.nextInt(VELICINA_KOLEKCIJE)];
        System.out.println("Traženi broj: " + element);

        paralelnaPretraga(kolekcija, element);
    }

    public static void paralelnaPretraga(int[] kolekcija, int element) {
        ExecutorService executorService = Executors.newFixedThreadPool(BROJ_NITI);
        AtomicBoolean pronadjen = new AtomicBoolean(false);
        int partSize = kolekcija.length / BROJ_NITI;

        for (int i = 0; i < BROJ_NITI; i++) {
            int pocetak = i * partSize;
            int kraj = (i == BROJ_NITI - 1) ? kolekcija.length : pocetak + partSize;

            int nitIndex = i; // Za ispis koji dio nit pretražuje

            executorService.submit(() -> {

                for (int j = pocetak; j < kraj && !pronadjen.get(); j++) {
                    if (kolekcija[j] == element) {
                        pronadjen.set(true);
                        System.out.println("Broj pronađen na indeksu " + j +
                                " u opsegu [" + pocetak + ", " + kraj + ").");
                        executorService.shutdownNow(); // Zaustavljanje svih niti
                        break;
                    }
                }
            });
        }

        executorService.shutdown();
    }
}
