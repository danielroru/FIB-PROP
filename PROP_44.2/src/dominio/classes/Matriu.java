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
    //TODO
    //public boolean hiHaCasella(int i, int j) { return matriu[i][j-PlaEstudis.getHoraInici()].esBuida(); }
}
