package dominio.classes;


// implements Comparable<Sessio>
public class Sessio {

    // Atributs
    private Enumeracio.TipusSessio tipus;
    private int idGrup;
    private Assignatura assignatura;
    //tantes sessions com h, tants ids com h
    private int id;
    private UAH uah;


    // Mètodes

    // Constructores

    public Sessio() {
    }

    public Sessio(Assignatura assig, int idGrup, Enumeracio.TipusSessio tipus, int id, UAH uah) {
        this.assignatura = assig;
        this.idGrup = idGrup;
        this.tipus = tipus;
        this.id = id;
        this.uah = uah;
    }

    // Consultores

    public Assignatura getAssignatura() {
        return this.assignatura;
    }

    public void setAssignatura(Assignatura assig) {
        this.assignatura = assig;
    }

    public int getIdGrup() {
        return this.idGrup;
    }

    public Enumeracio.TipusSessio getTipus() {
        return this.tipus;
    }

    public int getId() {
        return id;
    }

    public UAH getUah() {
        return uah;
    }

    // Modificadores

    public void setIdGrup(int idGrup) {
        this.idGrup = idGrup;
    }

    public void setTipus(Enumeracio.TipusSessio tipus) {
        this.tipus = tipus;
    }

    public void setId(int id) { this.id = id; }

    public void setUah(UAH uah) {
        this.uah = uah;
    }
}