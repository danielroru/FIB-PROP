package Dominio;

public class CtrlPresentacio {

    private CtrlDomini CD;
    private CtrlDominiAula CDaula;

    private CtrlPresentacioAula CPaula;

    public CtrlPresentacio() throws Exception {
        CD = new CtrlDomini();
        CDaula = CD.getCtrlDominiAula();
    }

    public void iniciControlador() throws Exception {

    }

    public void iniciAules() throws Exception {
        CPaula = new CtrlPresentacioAula(CDaula);
        CPaula.gestioAules();
    }


}
