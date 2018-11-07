// Marc Casellas

package Dominio;


public class Aula {

    /* --------------------------------------------------------------------------
        ATRIBUTS
    -------------------------------------------------------------------------- */

    private String id;
    private int capacitat;

    // 1 -> Teoria
    // 0 -> Laboratori
    private String tipusAula;

    /* --------------------------------------------------------------------------
        MÈTODES
    -------------------------------------------------------------------------- */

    ////////////////////////////////////////////////////////////////////
    ///// CONSTRUCTORES
    ////////////////////////////////////////////////////////////////////

    // Constructora per defecte
    public Aula() { }

    public Aula(String id, int capacitat, String tipusAula) {
        this.id = id;
        this.capacitat = capacitat;
        this.tipusAula = tipusAula;
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

    public String getTipusAula() {
        return tipusAula;
    }

    ////////////////////////////////////////////////////////////////////
    ///// MODIFICADORES
    ////////////////////////////////////////////////////////////////////

    public boolean setId(String id) {
        this.id = id;
        return true;
    }

    public boolean setCapacitat(int capacitat) {
        this.capacitat = capacitat;
        return true;
    }

    public boolean setTipusAula (String tipusAula) {
        this.tipusAula = tipusAula;
        return true;
    }
}
