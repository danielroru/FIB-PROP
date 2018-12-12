package dominio.controladores;

import dominio.swing.vistaPrincipal;

public class CtrlPresentacio {

    //////////////////////////////////////// Declaracions

    private CtrlDomini ctrlDomini;

    private vistaPrincipal vPrincipal;

    //////////////////////////////////////// Constructores

    public CtrlPresentacio() {
        ctrlDomini = new CtrlDomini();

        vPrincipal = new vistaPrincipal(this);
    }

    //////////////////////////////////////// Operacions

    public void iniciarPresentacio() {
        ctrlDomini.inicialitzar();
        vPrincipal.ferVisible();
    }

    public void carregarSetDades(String path) {
        ctrlDomini.carregarSetAssignatures(path);
    }

}
