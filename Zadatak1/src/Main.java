import java.util.Scanner;
import static java.lang.Math.sqrt;

public class Main {
    static boolean DaLiJeProst(int n) {
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i <= sqrt(n); i += 2)
            if (n % i == 0) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        do {
            System.out.println("Unesite broj n: ");
            n = in.nextInt();
            if (n > 500) System.out.println("Uneseni broj je prevelik!");
            if (n < 2) {
                System.out.println("Nije moguce izvrsiti izracunavanje prostih brojeva.");
                return;
            }
        } while (n > 500);
        System.out.println("Prosti brojevi: ");
        for (int i = 2; i <= n; i++) {
            if (DaLiJeProst(i)) {
                System.out.printf(String.valueOf(i));
                System.out.print(" ");
            }
        }
    }
}