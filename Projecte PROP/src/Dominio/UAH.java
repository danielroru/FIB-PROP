package Dominio;

public class UAH {

    // Atributs

    private int hora;
    private Enumeracio.Dia dia;
    private Sessio sessio;
    private Aula aula;

    // Mètodes

    // Constructores

    public UAH() {
    }

    public UAH (Sessio sessio, Aula aula, int hora, Enumeracio.Dia dia) {
        this.sessio = sessio;
        this.aula = aula;
        this.hora = hora;
        this.dia = dia;
    }

    // Consultores


    public Sessio getSessio() {
        return sessio;
    }

    public void setSessio(Sessio sessio) {
        this.sessio = sessio;
    }

    public boolean teSessio() {
        return this.sessio == new Sessio();
    }

    public void eliminaSessio() {
        this.sessio = null;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

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
