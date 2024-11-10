package Hrana;

import java.util.List;

public class Voce extends BiljnaHrana {

    public Voce(String latinskiNaziv, String zemljaPorijekla, List<Double> nutritivneVrijednosti) {
        super(latinskiNaziv, zemljaPorijekla, nutritivneVrijednosti);
    }
    @Override
    public boolean Zdravlje(Double koeficijentZdravlja) {
        return (DajBrojKalorija() < 50 && koeficijentZdravlja > 0.75);
    }



}
