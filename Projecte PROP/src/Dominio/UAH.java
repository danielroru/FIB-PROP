package Dominio;

public class UAH extends Aula {

    // Atributs

    private int hora;
    private Enumeracio.Dia dia;

    // Mètodes

    // Constructores

    public UAH() {
    }

    public UAH (Aula a) {
        super(a);
    }

    public UAH(Aula a, int hora, Enumeracio.Dia dia) {
        super(a);
        this.hora = hora;
        this.dia = dia;
    }

    // Consultores

    public int getHora() {
        return this.hora;
    }

    public Enumeracio.Dia getDia() {
        return dia;
    }

    // Modificadores

    public void setHora(int hora) {
        this.hora = hora;
    }

    public void setDia(Enumeracio.Dia dia) {
        this.dia = dia;
    }
}
