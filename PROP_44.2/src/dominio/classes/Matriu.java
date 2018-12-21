package dominio.classes;

import dominio.controladores.CtrlDomini;

public class Matriu {

    private int interval = CtrlDomini.getPlaEstudis().getHoraFi()-CtrlDomini.getPlaEstudis().getHoraInici();

    private int diesS = Enumeracio.Dia.values().length;

    private Casella [][] matriu;

    public Matriu() {
        matriu = new Casella [diesS][interval];
    }

    public void assignarCasella(int i, int j, Casella c) {
        matriu[i][j- CtrlDomini.getPlaEstudis().getHoraInici()] = c;
    }

    public void eliminarCasellas(int i, int j) {
        matriu[i][j-CtrlDomini.getPlaEstudis().getHoraInici()] = new Casella();
    }

    public Casella getCasella(int i, int j) {
        return matriu[i][j-CtrlDomini.getPlaEstudis().getHoraInici()];
    }

    public void swap(int i1, int j1, int i2, int j2) {
        Casella aux = matriu[i1][j1];
        matriu[i1][j1] = matriu[i2][j2];
        matriu[i2][j2] = aux;
    }
}
