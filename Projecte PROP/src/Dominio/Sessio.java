package Dominio;

public class Sessio implements Comparable<Sessio> {

    // Atributs
    private Enumeracio.TipusSessio tipus;
    private int idGrup;
    private int duracio;
    private Assignatura assignatura;


    // Mètodes

    // Constructores

    public Sessio() {
    }

    public Sessio(Assignatura a) {
    }

    public Sessio(Assignatura assig, int idGrup, int duracio, Enumeracio.TipusSessio tipus) {
        this.assignatura = assig;
        this.idGrup = idGrup;
        this.duracio = duracio;
        this.tipus = tipus;
    }

    // Consultores

    public Assignatura getAssignatura() {
        return assignatura;
    }

    public void setAssignatura(Assignatura assignatura) {
        this.assignatura = assignatura;
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

    public void setIdGrup(int idGrup) {
        this.idGrup = idGrup;
    }

    public void setDuracio(int duracio) {
        this.duracio = duracio;
    }

    public void setTipus(Enumeracio.TipusSessio tipus) {
        this.tipus = tipus;
    }

    @Override
    public int compareTo(Sessio o) {
        return 0;
    }
}
