package Dominio;

public class Sessio {

    // Atributs

    private int id;
    private int idAssig;
    private int idGrup;
    private int duracio;
    private Enumeracio.TipusSessio tipus;

    // Mètodes

    // Constructores

    public Sessio() {

    }

    public Sessio(int id, int idAssig, int idGrup, int duracio, Enumeracio.TipusSessio tipus) {
        this.id = id;
        this.idAssig = idAssig;
        this.idGrup = idGrup;
        this.duracio = duracio;
        this.tipus = tipus;
    }

    // Consultores

    public int getId() {
        return this.id;
    }

    public int getIdAssig() {
        return this.idAssig;
    }

    public int getIdGrup() {
        return this.idGrup;
    }

    public int getDuracio() {
        return this.duracio;
    }

    public Enumeracio.TipusSessio getTipus() {
        return this.tipus;
    }

    // Modificadores

    public void setId(int id) {
        this.id = id;
    }

    public void setIdAssig(int idAssig) {
        this.idAssig = idAssig;
    }

    public void setIdGrup(int idGrup) {
        this.idGrup = idGrup;
    }

    public void setDuracio(int duracio) {
        this.duracio = duracio;
    }

    public void setTipus(Enumeracio.TipusSessio tipus) {
        this.tipus = tipus;
    }
}
