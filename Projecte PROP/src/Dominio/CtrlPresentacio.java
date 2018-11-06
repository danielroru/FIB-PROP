package Dominio;

public class CtrlPresentacio {

    private CtrlDomini CD;
    private CtrlDominiAula CA;

    public CtrlPresentacio() {
        CD = new CtrlDomini();
        CA = CD.getCtrlDominiAula();
    }

    public void iniciControlador() {

    }


}
