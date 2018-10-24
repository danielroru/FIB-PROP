package Dominio;


public class Aula {

    /* --------------------------------------------------------------------------
        ATRIBUTS
    -------------------------------------------------------------------------- */

    public enum TipusAula {
        LABORATORI, TEORIA
    }

    private String id;
    private int capacitat;
    private TipusAula tipus;

    /* --------------------------------------------------------------------------
        MÈTODES
    -------------------------------------------------------------------------- */

    //  CONSTRUCTORES
    // --------------------------------------------

    // Constructora per defecte
    public Aula() {

    }

    public Aula(String id, int capacitat, TipusAula tipus) {
        this.id = id;
        this.capacitat = capacitat;
        this.tipus = tipus;
    }

    //  CONSULTORES
    // --------------------------------------------

    public String getId() {
        return this.id;
    }

    public int getCapacitat() {
        return this.capacitat;
    }

    public TipusAula getTipusAula() {
        return this.tipus;
    }


    //  MODIFICADORES
    // --------------------------------------------

    public void setId(String id) {
        this.id = id;
    }

    public void setCapacitat(int capacitat) {
        this.capacitat = capacitat;
    }

    public void setTipus(TipusAula tipus) {
        this.tipus = tipus;
    }
}