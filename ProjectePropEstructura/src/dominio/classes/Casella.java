package dominio.classes;

public class Casella {

    private String nomAssig;
    private int numGrup;
    private Enumeracio.TipusSessio tipus;

    /**
     * Constructora per defecte
     */
    public Casella() {}

    /**
     * Constructora amb inicialització
     *
     * @param  nomAssig nom de l'Assignatura
     * @param  numGrup número de grup
     * @param  tipus tipus de la sessió
     */
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

    public boolean esBuida() {return this == null; }
}
