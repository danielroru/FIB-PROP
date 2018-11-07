// Marc Casellas

package Dominio;

public class CtrlPresentacioPlaEstudis {

    private VistaPlaEstudis vPlaEstudis;
    private CtrlDominiPlaEstudis cdPlaEstudis;

    ////////////////////////////////////////////////////////////////////
    ///// CONSTRUCTORES
    ////////////////////////////////////////////////////////////////////

    CtrlPresentacioPlaEstudis (CtrlDominiPlaEstudis c) {
        vPlaEstudis = new VistaPlaEstudis();
        cdPlaEstudis = c;
    }

    ////////////////////////////////////////////////////////////////////
    ///// MENU
    ////////////////////////////////////////////////////////////////////

    public void gestioPlaEstudis() throws Exception {

        int accio = -1;
        while (accio != 3) {
            accio = vPlaEstudis.getOpcioMenu();

            switch (accio) {
                case 1:
                    veureHores();
                    break;
                case 2:
                    modificarHores();
                    break;
                default:
                    break;
            }
        }
    }

    private void veureHores() throws Exception {

    }

    private void modificarHores() throws Exception {

    }
}
