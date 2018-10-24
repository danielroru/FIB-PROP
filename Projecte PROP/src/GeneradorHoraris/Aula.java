package GeneradorHoraris;



public class Aula {

    /* --------------------------------------------------------------------------
        ATRIBUTS
    -------------------------------------------------------------------------- */

    public enum TipusAula {
        LABORATORI, TEORIA
    }

    private int id;
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

    public Aula(int id, int capacitat, TipusAula tipus) {
        this.id = id;
        this.capacitat = capacitat;
        this.tipus = tipus;
    }

    //  CONSULTORES
    // --------------------------------------------

    public int getId() {
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

    public void setId(int id) {
        this.id = id;
    }

    public void setCapacitat(int capacitat) {
        this.capacitat = capacitat;
    }

    public void setTipus(TipusAula tipus) {
        this.tipus = tipus;
    }
}
