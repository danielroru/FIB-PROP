package Dominio;

public class UAH {

    // Atributs

    private String idAula;
    private int idHora;
    private Enumeracio.Dia dia;

    // Mètodes

    // Constructores

    public UAH() {
    }

    public UAH(String idAula, int idHora, Enumeracio.Dia dia) {
        this.idAula = idAula;
        this.idHora = idHora;
        this.dia = dia;
    }

    // Consultores

    public String getIdAula() {
        return this.idAula;
    }

    public int getIdHora() {
        return this.idHora;
    }

    public Enumeracio.Dia getDia() {
        return dia;
    }

    // Modificadores

    public void setIdAula(String idAula) {
        this.idAula = idAula;
    }

    public void setIdHora(int idHora) {
        this.idHora = idHora;
    }

    public void setDia(Enumeracio.Dia dia) {
        this.dia = dia;
    }
}
