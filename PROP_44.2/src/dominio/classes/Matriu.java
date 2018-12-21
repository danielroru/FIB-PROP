package dominio.classes;

public class Matriu {

    private int interval = PlaEstudis.getHoraFi()-PlaEstudis.getHoraInici();

    private int diesS = Enumeracio.Dia.values().length;

    private Casella [][] matriu;

    public Matriu() {
        matriu = new Casella [diesS][interval];
    }

    public void assignarCasella(int i, int j, Casella c) {
        matriu[i][j-PlaEstudis.getHoraInici()] = c;
    }

    public void eliminarCasellas(int i, int j) {
        matriu[i][j-PlaEstudis.getHoraInici()] = new Casella();
    }

    public Casella getCasella(int i, int j) {
        return matriu[i][j-PlaEstudis.getHoraInici()];
    }

    public void swap(int i1, int j1, int i2, int j2) {
        Casella aux = matriu[i1][j1];
        matriu[i1][j1] = matriu[i2][j2];
        matriu[i2][j2] = aux;
    }
}
