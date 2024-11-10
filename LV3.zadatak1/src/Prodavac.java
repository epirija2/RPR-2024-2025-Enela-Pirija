import Hrana.NutritivneVrijednosti;

public class Prodavac implements NutritivneVrijednosti {
    protected String imePrezime;
    protected Integer brojStanda;
    protected Integer ID;

    public Prodavac(String imePrezime, Integer brojStanda, Integer ID) {
        setImePrezime(imePrezime);
        setBrojStanda(brojStanda);
        setID(ID);
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public Integer getBrojStanda() {
        return brojStanda;
    }

    public void setBrojStanda(Integer brojStanda) {
        this.brojStanda = brojStanda;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    @Override
    public boolean Zdravlje(Double koeficijentZdravlja) {
        return ID % 100 == 1;
    }

    @Override
    public Double DajBrojKalorija() {
        return 0.0;
    }
}
