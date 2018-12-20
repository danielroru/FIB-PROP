package dominio.classes;
// implements Comparable<Sessio>
public class Sessio {

    // Atributs
    private Enumeracio.TipusSessio tipus;
    private int idGrup;
    private Assignatura assignatura;


    // Mètodes

    // Constructores

    public Sessio() {
    }

    public Sessio(Assignatura assig, int idGrup, Enumeracio.TipusSessio tipus) {
        this.assignatura = assig;
        this.idGrup = idGrup;
        this.tipus = tipus;
    }

    // Consultores

    public Assignatura getAssignatura() {
        return this.assignatura;
    }

    public int getIdGrup() {
        return this.idGrup;
    }

    public Enumeracio.TipusSessio getTipus() {
        return this.tipus;
    }

    // Modificadores
    public void setAssignatura(Assignatura assig) {
        this.assignatura = assig;
    }

    public void setIdGrup(int idGrup) {
        this.idGrup = idGrup;
    }

    public void setTipus(Enumeracio.TipusSessio tipus) {
        this.tipus = tipus;
    }

}
