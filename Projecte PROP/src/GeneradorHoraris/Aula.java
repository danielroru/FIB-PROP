package GeneradorHoraris;



public class Aula {

    // Atributs

    private int id;
    private int capacitat;

    private enum TipusAula {
        LABORATORI, TEORIA
    }

    private TipusAula tipus;

    /* --------------------------------------------------------------------------
        Mètodes
    -------------------------------------------------------------------------- */

    //  Constructores
    //  --------------------------------------------

    // Constructora per defecte
    public Aula() {

    }

    public Aula(int id, int capacitat, boolean accesOrdinadors) {
        this.id = id;
        this.capacitat = capacitat;
        this.tipus = accesOrdinadors ? TipusAula.LABORATORI : TipusAula.TEORIA;
    }

    //  Consultores
    //  --------------------------------------------

    public int getId() {
        return this.id;
    }

    public int getCapacitat() {
        return this.capacitat;
    }

    public TipusAula getTipusAula() {
        return this.tipus;
    }


    //  Modificadores
    //  --------------------------------------------

    public void setId(int id) {
        this.id = id;
    }

    public void setCapacitat(int capacitat) {
        this.capacitat = capacitat;
    }

    public void settipus(TipusAula tipus) {
        this.tipus = tipus;
    }
}
