package Dominio;

public class Sessio {

    // Atributs

    private int id;
    private String nomAssig;
    private int idGrup;
    private int duracio;
    private Enumeracio.TipusSessio tipus;

    // Mètodes

    // Constructores

    public Sessio() {

    }

    public Sessio(int id, String nomAssig, int idGrup, int duracio, Enumeracio.TipusSessio tipus) {
        this.nomAssig = nomAssig;
        this.idGrup = idGrup;
        this.duracio = duracio;
        this.tipus = tipus;
    }

    // Consultores

    public int getId() {
        return this.id;
    }

    public String getNomAssig() {
        return this.nomAssig;
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

    public void setNomAssig(String nomAssig) {
        this.nomAssig = nomAssig;
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
