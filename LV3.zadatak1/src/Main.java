import Hrana.Meso;
import Hrana.Povrce;
import Hrana.Voce;
import Hrana.VrsteMesa;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        List<Double> jabukaNV = new ArrayList<>();
        jabukaNV.add(2.0); // proteini
        jabukaNV.add(100.0); // ugljikohidrati
        jabukaNV.add(8.0); //vlakna
        jabukaNV.add(2.7); // masti
        Voce jabuka = new Voce("Malus", "BiH", jabukaNV);
        System.out.printf("Jabuka ima " + jabuka.DajBrojKalorija() +" kalorija i ");
        if (jabuka.Zdravlje(0.8)) System.out.println("zdrava je!");
        else System.out.println("nije zdrava!");

        List<Double> krastavacNV = new ArrayList<>();
        krastavacNV.add(2.8); // proteini
        krastavacNV.add(14.4); // ugljikohidrati
        krastavacNV.add(1.0); //vlakna
        krastavacNV.add(0.9); // masti
        Povrce krastavac = new Povrce("Cucumis sativus", "BiH", krastavacNV);
        System.out.printf("Krastavac ima " + krastavac.DajBrojKalorija() +" kalorija i ");
        if (krastavac.Zdravlje(0.6)) System.out.println("zdrav je!");
        else System.out.println("nije zdrav!");

        List<Double> mesoNV = new ArrayList<>();
        mesoNV.add(124.0); // proteini
        mesoNV.add(0.0); // ugljikohidrati
        mesoNV.add(32.4); // masti
        Meso meso = new Meso(VrsteMesa.piletina, "BiH", mesoNV);
        System.out.printf("Meso ima " + meso.DajBrojKalorija() +" kalorija i ");
        if (meso.Zdravlje(0.7)) System.out.println("zdravo je!");
        else System.out.println("nije zdravo!");

        Prodavac prodavac = new Prodavac("NN", 123, 123401);
        if (prodavac.Zdravlje(0.57)) System.out.println("Prodavac zdrav!");
        else System.out.println("Prodavac nije zdrav!");

    }
}