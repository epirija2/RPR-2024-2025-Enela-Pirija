package Hrana;

import java.util.List;

public class Meso extends Hrana {
    protected VrsteMesa vrsta;

    public Meso(VrsteMesa vrsta, String zemljaPorijekla, List<Double> nutritivneVrijednosti) {
        super(zemljaPorijekla, nutritivneVrijednosti);
        this.vrsta = vrsta;
    }

    @Override
    public Double DajBrojKalorija() {
        Double ukupnoKalorija = 0.0;
        for (Double k : nutritivneVrijednosti)
            ukupnoKalorija += k;
        return ukupnoKalorija + (1.2 * ukupnoKalorija);
    }

    @Override
    public boolean Zdravlje(Double koeficijentZdravlja) {
        return koeficijentZdravlja > 0.95;
    }
}
