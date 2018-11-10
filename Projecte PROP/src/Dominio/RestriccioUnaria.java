package Dominio;

import java.util.HashSet;
import java.util.Set;

public class RestriccioUnaria {

    public static Set<UAH> crearDomini(ConjuntAssignatures cjtAssig, Sessio s) {
        Set<UAH> result = new HashSet<>();
        result = (s.getTipus().equals(Enumeracio.TipusSessio.LABORATORI)) ? CtrlDomini.getUAHlaboratori() : CtrlDomini.getUAHteoria();

        Assignatura as = cjtAssig.getConjuntAssignatures().get(s.getNomAssig());

        if ((s.getIdGrup() < (as.getnGrupsMati() + 1) * 10)) {
            result.retainAll(CtrlDomini.getUAHmatins());
        } else {
            result.retainAll(CtrlDomini.getUAHtardes());
        }

        return result;


    }

}
