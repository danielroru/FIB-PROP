package Dominio;

public class CtrlDomini {

    private CtrlDominiAula CDaula;

    public CtrlDomini() {
        CDaula = new CtrlDominiAula();
    }

    public CtrlDominiAula getCtrlDominiAula() {
        return CDaula;
    }
}
