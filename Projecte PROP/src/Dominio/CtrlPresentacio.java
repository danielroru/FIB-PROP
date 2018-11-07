package Dominio;

public class CtrlPresentacio {

    private CtrlDomini CD;
    private CtrlDominiAula cdAula;
    private CtrlDominiPlaEstudis cdPlaEstudis;

    private CtrlPresentacioAula cpAula;
    private CtrlPresentacioPlaEstudis cpPlaEstudis;

    private VistaGeneral vGeneral;

    ////////////////////////////////////////////////////////////////////
    ///// CONSTRUCTORES
    ////////////////////////////////////////////////////////////////////

    public CtrlPresentacio() throws Exception {
        CD = new CtrlDomini();
        cdAula = CD.getCtrlDominiAula();
        cdPlaEstudis = CD.getCdPlaEstudis();

        vGeneral = new VistaGeneral();
    }

    public void iniciControlador() throws Exception {
        // TODO
    }

    ////////////////////////////////////////////////////////////////////
    ///// GESTIÓ
    ////////////////////////////////////////////////////////////////////

    public void iniciGestio() throws Exception {
        int accio = -1;
        while (accio != 4) {
            accio = vGeneral.getOpcioMenu();

            switch (accio) {
                case 1:
                    gestioConfiguracio();
                    break;
                case 2:
                    generarHorari();
                    break;
                case 3:
                    gestioPlaEstudis();
                    break;
                default:
                    break;
            }
        }
    }

    private void gestioConfiguracio() throws Exception {
        int accio = -1;
        while (accio != 4) {
            accio = vGeneral.getOpcioAula();

            switch (accio) {
                case 1:
                    gestioAules();
                    break;
                case 2:
                    gestioAssignatures();
                    break;
                case 3:
                    gestioPlaEstudis();
                    break;
                default:
                    break;
            }
        }
    }

    private void generarHorari() {

    }

    private void gestioAules() throws Exception {
        cpAula = new CtrlPresentacioAula(cdAula);
        cpAula.gestioAules();
    }

    private void gestioAssignatures() throws Exception {

    }

    private void gestioPlaEstudis() throws Exception {
        cpPlaEstudis = new CtrlPresentacioPlaEstudis(cdPlaEstudis);
        cpPlaEstudis.gestioPlaEstudis();
    }


}
