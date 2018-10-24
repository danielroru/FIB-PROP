package Dominio;

public class UAH {

    // Atributs

    private int id;
    private int idAssig;
    private int idAula;
    private int idHora;

    // Mètodes

    // Constructores

    public UAH() {
        this.id = 0;
        this.idAssig = 0;
        this.idAula = 0;
        this.idHora = 0;
    }

    public UAH(int id, int idAssig, int idAula, int idHora) {
        this.id = id;
        this.idAssig = idAssig;
        this.idAula = idAula;
        this.idHora = idHora;
    }

    // Consultores

    public int getId() {
        return this.id;
    }

    public int GetIdAssig() {
        return this.idAssig;
    }

    public int GetIdAula() {
        return this.idAula;
    }

    public int GetIdHora() {
        return this.idHora;
    }

    // Modificadores

    public void setId(int id) {
        this.id = id;
    }

    public void setIdAssig(int idAssig) {
        this.idAssig = idAssig;
    }

    public void setIdAula(int idAula) {
        this.idAula = idAula;
    }

    public void setIdHora(int idHora) {
        this.idHora = idHora;
    }
}
