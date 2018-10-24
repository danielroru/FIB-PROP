package Dominio;

public class Aula {

    // Atributs

    private int id;
    private int capacitat;
    private boolean esLaboratori;

    // Mètodes

    // Constructores

    public Aula() {
        this.id = 0;
        this.capacitat = 0;
        this.esLaboratori = false;
    }

    public Aula(int id, int capacitat, boolean accesOrdinadors, boolean disponible) {
        this.id = id;
        this.capacitat = capacitat;
        this.esLaboratori = accesOrdinadors;
    }

    // Consultores

    public int getId() {
        return this.id;
    }

    public int getCapacitat() {
        return this.capacitat;
    }

    public boolean getEsLaboratori() {
        return this.esLaboratori;
    }


    // Modificadores

    public void setId(int id) {
        this.id = id;
    }

    public void setCapacitat(int capacitat) {
        this.capacitat = capacitat;
    }

    public void setEsLaboratori(boolean esLaboratori) {
        this.esLaboratori = esLaboratori;
    }
}
