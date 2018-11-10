package Dominio;

public class UAH {

    // Atributs

    private String idAula;
    private int hora;
    private Enumeracio.Dia dia;

    // Mètodes

    // Constructores

    public UAH() {
    }

    public UAH(String idAula, int hora, Enumeracio.Dia dia) {
        this.idAula = idAula;
        this.hora = hora;
        this.dia = dia;
    }

    // Consultores

    public String getIdAula() {
        return this.idAula;
    }

    public int getHora() {
        return this.hora;
    }

    public Enumeracio.Dia getDia() {
        return dia;
    }

    // Modificadores

    public void setIdAula(String idAula) {
        this.idAula = idAula;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public void setDia(Enumeracio.Dia dia) {
        this.dia = dia;
    }
}
