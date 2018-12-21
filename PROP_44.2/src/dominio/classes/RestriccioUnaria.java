package dominio.classes;

import dominio.controladores.CtrlDomini;

import java.util.HashSet;
import java.util.Set;
import dominio.controladores.CtrlDominiGenerarHorari;

public class RestriccioUnaria {

    /**
     * Creadora de restricció unària manual d'hora
     *
     * @param  inici true si la restricció es refereix a la hora d'inici de classes, false si és de hora de fi
     * @param  hora hora llindar
     * @return UAHs que NO compleixen la restricció
     */
    public static Set<UAH> restriccioHora(boolean inici, int hora) {
        Set<UAH> uahsNoPossibles = new HashSet<>();
        if (inici) {
            for (UAH uah : CtrlDominiGenerarHorari.getUAHs())
                if (uah.getHora() < hora) uahsNoPossibles.add(uah);
        } else {
            for (UAH uah : CtrlDominiGenerarHorari.getUAHs())
                if (uah.getHora() > hora) uahsNoPossibles.add(uah);
        }
        return uahsNoPossibles;
    }


    /**
     * Creadora de restricció unària manual de dia
     *
     * @param  dies dies de la setmana que es vol buit
     *
     * @return UAHs que NO compleixen la restricció
     */
    public static Set<UAH> restriccioDia(Set<Enumeracio.Dia> dies) {
        Set<UAH> uahsNoPossibles = new HashSet<>();
        for (Enumeracio.Dia dia : dies) {
            
        }
        return uahsNoPossibles;
    }

    public static Set<UAH> crearDomini(Sessio s) {
        Set<UAH> result;

        if (s.getTipus().equals(Enumeracio.TipusSessio.LABORATORI)) {
            result = new HashSet<>(CtrlDominiGenerarHorari.getUAHlaboratori());
        }
        else {
            result = new HashSet<>(CtrlDominiGenerarHorari.getUAHteoria());
        }

        String nom = s.getAssignatura().getNom();

        Assignatura as = CtrlDomini.getPlaEstudis().getConjuntAssignatures().getAssignatura(nom);

        if ((s.getIdGrup() < (as.getnGrupsMati() + 1) * 10)) {
            result.retainAll(CtrlDominiGenerarHorari.getUAHmatins());
        }
        else {
            result.retainAll(CtrlDominiGenerarHorari.getUAHtardes());
        }

        return result;

    }

}