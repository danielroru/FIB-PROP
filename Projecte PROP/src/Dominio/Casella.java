package Dominio;

public class Casella {

    private String nomAssig;
    private int numGrup;
    private Enumeracio.TipusSessio tipus;

    public Casella() {}

    public Casella(String nomAssig, int numGrup, Enumeracio.TipusSessio tipus) {
        this.nomAssig = nomAssig;
        this.numGrup = numGrup;
        this.tipus = tipus;
    }

    public String getNomAssig() {
        return nomAssig;
    }

    public void setNomAssig(String nomAssig) {
        this.nomAssig = nomAssig;
    }

    public int getNumGrup() {
        return numGrup;
    }

    public void setNumGrup(int numGrup) {
        this.numGrup = numGrup;
    }

    public Enumeracio.TipusSessio getTipus() {
        return tipus;
    }

    public void setTipus(Enumeracio.TipusSessio tipus) {
        this.tipus = tipus;
    }
}
