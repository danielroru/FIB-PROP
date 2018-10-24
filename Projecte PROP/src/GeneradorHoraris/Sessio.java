package GeneradorHoraris;

public class Sessio {

    // Atributs

    private int id;
    private int horaInici;
    private int horaFi;

    public enum Dia {
        DILLUNS, DIMARTS, DIMECRES, DIJOUS, DIVENDRES
    }

    Dia dia;

    public enum Tipus {
        TEORIA, LABORATORI, PROBLEMES
    }

    Tipus tipus;

    // Mètodes

    // Constructores

    public Sessio() {

    }

    public Sessio(int id, String tipus, String dia, int horaInici, int horaFi) {
        this.id = id;
        this.horaInici = horaInici;
        this.horaFi = horaFi;
        this.dia = Dia.valueOf(dia);
        this.tipus = Tipus.valueOf(tipus);
    }

    // Consultores

    public int getId() {
        return this.id;
    }

    public int getHoraInici() {
        return this.horaInici;
    }

    public int getHoraFi() {
        return this.horaFi;
    }

    public Dia getDia() {
        return this.dia;
    }

    public Tipus getProblemes() {
        return this.tipus;
    }

    // Modificadores

    public void setId(int id) {
        this.id = id;
    }
}
