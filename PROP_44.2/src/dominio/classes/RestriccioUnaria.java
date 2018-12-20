package dominio.classes;

import dominio.controladores.CtrlDomini;

import java.util.HashSet;
import java.util.Set;
import dominio.controladores.CtrlDominiGenerarHorari;

public class RestriccioUnaria {

    public static Set<UAH> crearDomini(Sessio s) {
        Set<UAH> result;

        if (s.getTipus().equals(Enumeracio.TipusSessio.LABORATORI)) {
            result = new HashSet<>(CtrlDominiGenerarHorari.getUAHlaboratori());
        }
        else {
            result = new HashSet<>(CtrlDominiGenerarHorari.getUAHteoria());
        }

        String nom = s.getAssignatura().getNom();

        Assignatura as = PlaEstudis.getConjuntAssignatures().getAssignatura(nom);

        if ((s.getIdGrup() < (as.getnGrupsMati() + 1) * 10)) {
            result.retainAll(CtrlDominiGenerarHorari.getUAHmatins());
        }
        else {
            result.retainAll(CtrlDominiGenerarHorari.getUAHtardes());
        }

        return result;


    }

}
