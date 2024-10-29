import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static Double Plus(Double broj1, Double broj2) {
        return broj1 + broj2;
    }
    public static Double Podijeljeno(Double broj1, Double broj2) throws Exception {
        if (broj2 == 0) throw new Exception ("Nije dozvoljeno dijeljenje s nulom!");
        return Math.round((broj1 / broj2) * 100) / 100.0;
    }
    public static void main(String[] args) {
        String operacija;
        System.out.printf("Unesite operaciju ('plus' za sabiranje, 'podijeljeno' za dijeljenje):");
        Scanner input = new Scanner(System.in);
        operacija = input.nextLine();
        ArrayList<Double> brojevi = new ArrayList<>();
        System.out.printf("Unesite brojeve: ");
        double broj;
        do {
            broj = input.nextDouble();
            if (broj == -400) break;
            brojevi.add(broj);
        } while (broj != -400);
        double rezultat = brojevi.get(0);
        if (operacija.equals("plus")) {
            for (int i = 1; i < brojevi.size(); i++)
                rezultat = Plus(rezultat, brojevi.get(i));
        } else {
            try {
                for (int i = 1; i < brojevi.size(); i++)
                    rezultat = Podijeljeno(rezultat, brojevi.get(i));
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return;
            }
        }
        System.out.println("Konacni rezultat: " + rezultat);
    }
}