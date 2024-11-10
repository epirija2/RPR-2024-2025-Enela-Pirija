package Hrana;

import java.util.List;

public abstract class Hrana implements NutritivneVrijednosti {
    protected String zemljaPorijekla;
    protected List<Double> nutritivneVrijednosti;

    public Hrana(String zemljaPorijekla, List<Double> nutritivneVrijednosti) {
        setZemljaPorijekla(zemljaPorijekla);
        setNutritivneVrijednosti(nutritivneVrijednosti);
    }

    public String getZemljaPorijekla() {
        return zemljaPorijekla;
    }

    public void setZemljaPorijekla(String zemljaPorijekla) {
        this.zemljaPorijekla = zemljaPorijekla;
    }

    public List<Double> getNutritivneVrijednosti() {
        return nutritivneVrijednosti;
    }

    public void setNutritivneVrijednosti(List<Double> nutritivneVrijednosti) {
        this.nutritivneVrijednosti = nutritivneVrijednosti;
    }


}
