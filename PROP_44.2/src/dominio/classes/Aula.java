package dominio.classes;

public class Aula {

    /* --------------------------------------------------------------------------
        ATRIBUTS
    -------------------------------------------------------------------------- */
    /**
     * Nom de l'aula
     */
    private String id;
    /**
     * Capacitat de l'aula
     */
    private int capacitat;
    /**
     * Tipus d'aula (laboratori o teoria)
     */
    private Enumeracio.TipusAula tipus;

    /* --------------------------------------------------------------------------
        MÈTODES
    -------------------------------------------------------------------------- */

    ////////////////////////////////////////////////////////////////////
    ///// CONSTRUCTORES
    ////////////////////////////////////////////////////////////////////

    // Constructora per defecte
    /**
     * Constructora per defecte
     */
    public Aula() {};

    /**
     * Constructora còpia
     * @param a Assignatura a copiar
     */
    public Aula (Aula a) {
        this.id = a.id;
        this.capacitat = a.capacitat;
        this.tipus = a.tipus;
    }

    /**
     * Constructora amb inicialització
     *
     * @param  id id de l'Aula
     * @param  capacitat capacitat de l'Aula
     * @param  tipus tipus de l'Aula
     */
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
