package dominio.controladores;

import dominio.swing.vistaPrincipal;

public class CtrlPresentacio {

    //////////////////////////////////////// Declaracions

    private CtrlDomini ctrlDomini;
    private vistaPrincipal vPrincipal = null;

    //////////////////////////////////////// Constructores

    public CtrlPresentacio() {
        ctrlDomini = new CtrlDomini();

        if (vPrincipal == null)
            vPrincipal = new vistaPrincipal(this);
    }

    //////////////////////////////////////// Operacions

    public void iniciarPresentacio() {
        ctrlDomini.inicialitzar();
        vPrincipal.ferVisible();
    }


}
