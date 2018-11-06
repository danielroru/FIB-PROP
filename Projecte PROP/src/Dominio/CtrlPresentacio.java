package Dominio;

public class CtrlPresentacio {

    private CtrlDomini CD;
    private CtrlDominiAula CDaula;

    public CtrlPresentacio() {
        CD = new CtrlDomini();
        CDaula = CD.getCtrlDominiAula();
    }

    public void iniciControlador() {

    }


}
