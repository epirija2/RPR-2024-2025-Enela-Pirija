import controller.PredmetController;
import model.Predmet;
import view.PredmetView;

public class Main {
    public static void main(String[] args) {
        Predmet predmetModel = new Predmet("Razvoj programskih rjesenja", 5.0);

        PredmetView predmetView = new PredmetView();
        predmetView.setUlazniTekstZaNaziv("Tehnike programiranja");

        PredmetController predmetController = new PredmetController(predmetModel, predmetView);
        predmetController.azurirajNazivPredmeta();
        System.out.println(predmetView.getPoruka());

        predmetView.setUlazniTekstZaECTS(6.0);
        predmetController.azurirajECTS();
        System.out.println(predmetView.getPoruka());

        predmetController.dajOsobeIzDatoteke("src/data/predmeti.txt");
        System.out.println(predmetView.getPoruka());
    }
}