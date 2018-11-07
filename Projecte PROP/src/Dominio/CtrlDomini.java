package Dominio;

public class CtrlDomini {

    private CtrlDominiAula cdAula;
    private CtrlDominiPlaEstudis cdPlaEstudis;

    public CtrlDomini() {
        cdAula = new CtrlDominiAula();
        cdPlaEstudis = new CtrlDominiPlaEstudis();
    }

    public CtrlDominiAula getCtrlDominiAula() {
        return cdAula;
    }

    public CtrlDominiPlaEstudis getCdPlaEstudis() {
        return cdPlaEstudis;
    }
}
