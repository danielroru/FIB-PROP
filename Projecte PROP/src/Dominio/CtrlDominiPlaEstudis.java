package Dominio;

import java.util.Vector;

public class CtrlDominiPlaEstudis {


    public CtrlDominiPlaEstudis() {
    }

    public Vector<Integer> getHores() {

        Vector<Integer> resultat = new Vector<Integer>();

        resultat.add(PlaEstudis.getHoraInici());
        resultat.add(PlaEstudis.getHoraFi());
        resultat.add(PlaEstudis.getHoraCanviFranja());

        return resultat;
    }
}
