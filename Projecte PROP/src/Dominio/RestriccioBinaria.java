package Dominio;

import java.util.*;

public class RestriccioBinaria {

    public static HashSet<Sessio> arestesNivell(ConjuntAssignatures cjtAssig, Sessio s) {
        HashSet<Sessio> sessionsNivell = new HashSet<>();
        Assignatura assig = cjtAssig.getConjuntAssignatures().get(s.getNomAssig());
        Map<Integer, Set<Assignatura>> CjtNivells = cjtAssig.getCjtNivells();
        for (Set<Assignatura> sa : CjtNivells.values()) {
            for (Assignatura a : sa) {
                //Iterar per totes les sessions d'assignatures del mateix nivell que s
                for (Sessio sessio : CtrlDomini.getSessionsByIdAssig(a.getNom())) {
                    //Si la sessió és de teoria no es pot solapar amb les altres del mateix grup
                    if (s.getIdGrup() % 10 == 0 && sessio.getIdGrup() == s.getIdGrup())
                        sessionsNivell.add(sessio);
                        //si la sessió és de lab no es pot solapar amb les de teoria del mateix grup ni les altres del mateix grup de lab
                    else if (s.getIdGrup() % 10 != 0 &&
                            ((sessio.getIdGrup() % 10 == 0 && sessio.getIdGrup() / 10 == s.getIdGrup() / 10) || (sessio.getIdGrup() == s.getIdGrup())))
                        sessionsNivell.add(sessio);
                }
            }
        }
        return sessionsNivell;
    }

    public static HashSet<Sessio> arestesCorrequisit(Sessio s) {
        return new HashSet<>();
    }
}
