package Dominio;

import java.util.HashSet;
import java.util.Set;

public class RestriccioUnaria {

    public static Set<UAH> crearDomini(Sessio s) {
        Set<UAH> result;

        if (s.getTipus().equals(Enumeracio.TipusSessio.LABORATORI)) {
            result = new HashSet<>(CtrlDomini.getUAHlaboratori());
        }
        else {
            result = new HashSet<>(CtrlDomini.getUAHteoria());
        }

        Assignatura as = PlaEstudis.getConjuntAssignatures().getAssignatura(s.getAssignatura().getNom());

        if ((s.getIdGrup() < (as.getnGrupsMati() + 1) * 10)) {
            result.retainAll(CtrlDomini.getUAHmatins());
        }
        else {
            result.retainAll(CtrlDomini.getUAHtardes());
        }

        return result;


    }

}
