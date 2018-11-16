package Dominio;


public class Aula {

    /* --------------------------------------------------------------------------
        ATRIBUTS
    -------------------------------------------------------------------------- */

    private String id;
    private int capacitat;
    private Enumeracio.TipusAula tipus;

    /* --------------------------------------------------------------------------
        MÈTODES
    -------------------------------------------------------------------------- */

    ////////////////////////////////////////////////////////////////////
    ///// CONSTRUCTORES
    ////////////////////////////////////////////////////////////////////

    // Constructora per defecte
    public Aula() {};

    public Aula (Aula a) {
        this.id = a.id;
        this.capacitat = a.capacitat;
        this.tipus = a.tipus;
    }

    public Aula(String id, int capacitat, Enumeracio.TipusAula tipus) {
        this.id = id;
        this.capacitat = capacitat;
        this.tipus = tipus;
    }

    ////////////////////////////////////////////////////////////////////
    ///// CONSULTORES
    ////////////////////////////////////////////////////////////////////

    public String getId() {
        return this.id;
    }

    public int getCapacitat() {
        return this.capacitat;
    }

    public Enumeracio.TipusAula getTipusAula() {
        return this.tipus;
    }

    ////////////////////////////////////////////////////////////////////
    ///// MODIFICADORES
    ////////////////////////////////////////////////////////////////////

    public void setId(String id) {
        this.id = id;
    }

    public void setCapacitat(int capacitat) {
        this.capacitat = capacitat;
    }

    public void setTipus(Enumeracio.TipusAula tipus) {
        this.tipus = tipus;
    }
}
