import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {

    private static final int VELICINA_KOLEKCIJE = 100;
    private static final int BROJ_NITI = 50;

    public static void main(String[] args) {
        int[] kolekcija = new int[VELICINA_KOLEKCIJE];
        Random random = new Random();

        for (int i = 0; i < VELICINA_KOLEKCIJE; i++) {
            kolekcija[i] = random.nextInt(1000);
        }

        System.out.println("Nesortirana kolekcija:");
        ispisiNiz(kolekcija);

        paralelnoSortiranje(kolekcija);

        System.out.println("\nSortirana kolekcija:");
        ispisiNiz(kolekcija);
    }

    public static void paralelnoSortiranje(int[] kolekcija) {
        ExecutorService executorService = Executors.newFixedThreadPool(BROJ_NITI);
        AtomicBoolean zamjena = new AtomicBoolean(true); // Praćenje promjena

        while (zamjena.get()) {
            zamjena.set(false); // Pretpostavimo da nema zamjena

            for (int i = 0; i < BROJ_NITI; i++) {
                int nitIndex = i;

                executorService.submit(() -> {
                    for (int j = nitIndex; j < kolekcija.length - 1; j += BROJ_NITI) {
                        if (kolekcija[j] > kolekcija[j + 1]) {
                            // Zamjena elemenata
                            int temp = kolekcija[j];
                            kolekcija[j] = kolekcija[j + 1];
                            kolekcija[j + 1] = temp;
                            zamjena.set(true);
                        }
                    }
                });
            }
        }

        executorService.shutdown();
        while (!executorService.isTerminated()) {
        }
    }

    public static void ispisiNiz(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
