package Dominio;

public class Sessio extends Assignatura{

    // Atributs
    private Enumeracio.TipusSessio tipus;
    private int idGrup;
    private int duracio;


    // Mètodes

    // Constructores

    public Sessio() {
    }

    public Sessio(Assignatura a) {
        super(a);
    }

    public Sessio(Assignatura a, int idGrup, int duracio, Enumeracio.TipusSessio tipus) {
        super(a);
        this.idGrup = idGrup;
        this.duracio = duracio;
        this.tipus = tipus;
    }

    // Consultores


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
