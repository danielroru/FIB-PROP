package Dominio;

import java.util.*;

public class RestriccioBinaria {

    public static HashSet<Sessio> arestesNivell(Sessio s) {
        HashSet<Sessio> sessionsNivell = new HashSet<>();
        Assignatura assig = CtrlDomini.getPlaEstudis().getCjtAssig().getConjuntAssignatures().get(s.getNomAssig());
        Set<Assignatura> CjtNivells = CtrlDomini.getPlaEstudis().getCjtNivells().getNivell(assig.getNivell());
        for (Assignatura a : CjtNivells) {
            for (Sessio sessio : CtrlDomini.getSessionsByIdAssig(a.getNom())) {
                sessionsNivell.add(sessio);
            }
        }
        return sessionsNivell;
    }
}
