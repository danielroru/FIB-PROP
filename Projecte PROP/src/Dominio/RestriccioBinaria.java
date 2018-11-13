package Dominio;

import java.util.*;

public class RestriccioBinaria {

    public static HashSet<Sessio> arestesNivell(Sessio s) {
        HashSet<Sessio> resultat = new HashSet<>();

        int NivellSessio = PlaEstudis.getConjuntAssignatures().getAssignatura(s.getAssignatura().getNom()).getNivell();

        // Iterem per totes les assignatures del mateix nivell que s
        for (Assignatura a : PlaEstudis.getConjuntAssignatures().getAssigsByNivell(NivellSessio)) {
            // Iterem per totes les sessions de totes les assignatures del nivell de s
            for (Sessio sAssig : CtrlDomini.getSessionsByIdAssig(a.getNom())) {
                if (s != sAssig) {
                    // Si la sessió s és de teoria
                    if (s.getTipus().equals(Enumeracio.TipusSessio.TEORIA)) {
                        // Si es de teoria no es pot solapar amb el mateix grup T/L [10,11]
                        if ((s.getIdGrup()/10) == (sAssig.getIdGrup()/10)) {
                            resultat.add(sAssig);
                        }
                    }
                    // Si és de LAB o PROB
                    else {
                        if (sAssig.getTipus().equals(Enumeracio.TipusSessio.TEORIA)) {
                            if ((s.getIdGrup()/10) == (sAssig.getIdGrup()/10)) {
                                resultat.add(sAssig);
                            }
                        }
                        else {
                            if (s.getIdGrup() == sAssig.getIdGrup()) {
                                resultat.add(sAssig);
                            }
                        }
                    }
                }

            }
        }
        return resultat;
    }

    public static boolean validaSolucio(Horari h, Sessio s, UAH uah) {

        // Comprovem si la UAH ja ha estat assignada previament
        if (h.existeixUAH(uah)) {
            return false;
        }

        switch (s.getTipus()) {
            case TEORIA:
                if (uah.getAula().getCapacitat() < s.getAssignatura().getnAlumnesT()) return false;
                break;
            case LABORATORI:
                if (uah.getAula().getCapacitat() < s.getAssignatura().getnAlumnesL()) return false;
                break;
            case PROBLEMES:
                if (uah.getAula().getCapacitat() < s.getAssignatura().getnAlumnesP()) return false;
                break;
            default:
                break;
        }

        // Les Sessions que tenen conflicte amb s
        for (Sessio sessioConflicte : GeneradorHorari.getG().getArestes().get(s)) {

           // Si la solució té un valor assignat per una sessió conflictiva (s)
           for (UAH uahconflicte : h.getHorari()){
               if (uahconflicte.getSessio().equals(sessioConflicte)) {
                   if (coincideixenUAH(uah, uahconflicte)) return false;
               }
           }
        }
        return true;
    }

    public static boolean coincideixenUAH (UAH a, UAH b) {
        return ((a.getDia() == b.getDia()) && (a.getHora() == b.getHora()));
    }

    public static HashSet<Sessio> arestesCorrequisit(Sessio s) {
        return new HashSet<>();
    }
}
