package Hrana;

import java.util.List;

public abstract class BiljnaHrana extends Hrana {
    protected String latinskiNaziv;

    public BiljnaHrana(String latinskiNaziv, String zemljaPorijekla, List<Double> nutritivneVrijednosti) {
        super(zemljaPorijekla, nutritivneVrijednosti);
        this.latinskiNaziv = latinskiNaziv;
    }
    @Override
    public Double DajBrojKalorija() {
        Double ukupnoKalorija = 0.0;
        for (Double k : nutritivneVrijednosti)
            ukupnoKalorija += k;
        return ukupnoKalorija;
    }
}
