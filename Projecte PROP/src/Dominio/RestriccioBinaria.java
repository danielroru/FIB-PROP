package Dominio;

import java.util.*;

public class RestriccioBinaria {

    public static HashSet<Sessio> arestesNivell(ConjuntAssignatures cjtAssig, Sessio s) {
        HashSet<Sessio> resultat = new HashSet<>();

        int NivellSessio = cjtAssig.getConjuntAssignatures().get(s.getNom()).getNivell();

        // Iterem per totes les assignatures del mateix nivell que s
        for (Assignatura a : cjtAssig.getConjuntNivells().get(NivellSessio)) {
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

        switch (s.getTipus()) {
            case TEORIA:
                if (uah.getCapacitat() < s.getnAlumnesT()) return false;
                break;
            case LABORATORI:
                if (uah.getCapacitat() < s.getnAlumnesL()) return false;
                break;
            case PROBLEMES:
                if (uah.getCapacitat() < s.getnAlumnesP()) return false;
                break;
            default:
                break;
        }



        // Comprovem si la UAH ja ha estat assignada previament
        if (h.getHorari().values().contains(uah)) {
            return false;
        }

        // Les Sessions que tenen conflicte amb s
        for(Sessio sessioConflicte : GeneradorHorari.getG().getArestes().get(s)) {
            // Si la solució té un valor assignat per una sessió conflictiva (s)
           if (h.getHorari().containsKey(sessioConflicte)) {
               for (UAH uahConflicte : h.getHorari().get(sessioConflicte)) {
                   if (coincideixenUAH(uah, uahConflicte)) return false;
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
