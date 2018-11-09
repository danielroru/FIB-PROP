package Dominio;

public class UAH {

    // Atributs

    private int idAssig;
    private int idAula;
    private int idHora;
    private Enumeracio.Dia dia;

    // Mètodes

    // Constructores

    public UAH() {
    }

    public UAH(int idAssig, int idAula, int idHora, Enumeracio.Dia dia) {
        this.idAssig = idAssig;
        this.idAula = idAula;
        this.idHora = idHora;
        this.dia = dia;
    }

    // Consultores

    public int GetIdAssig() {
        return this.idAssig;
    }

    public int GetIdAula() {
        return this.idAula;
    }

    public int GetIdHora() {
        return this.idHora;
    }

    public Enumeracio.Dia getDia() {
        return dia;
    }

    // Modificadores

    public void setIdAssig(int idAssig) {
        this.idAssig = idAssig;
    }

    public void setIdAula(int idAula) {
        this.idAula = idAula;
    }

    public void setIdHora(int idHora) {
        this.idHora = idHora;
    }

    public void setDia(Enumeracio.Dia dia) {
        this.dia = dia;
    }
}
