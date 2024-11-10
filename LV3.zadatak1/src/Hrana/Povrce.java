package Hrana;

import java.util.List;

public class Povrce extends BiljnaHrana {

    public Povrce(String latinskiNaziv, String zemljaPorijekla, List<Double> nutritivneVrijednosti) {
        super(latinskiNaziv, zemljaPorijekla, nutritivneVrijednosti);
    }
    @Override
    public boolean Zdravlje(Double koeficijentZdravlja) {
        return (DajBrojKalorija() < 100 && koeficijentZdravlja > 0.5 && koeficijentZdravlja < 0.7);
    }

}
