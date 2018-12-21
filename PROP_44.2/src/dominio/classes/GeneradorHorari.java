package dominio.classes;

import dominio.controladores.CtrlDomini;
import dominio.controladores.CtrlDominiGenerarHorari;

import java.util.*;

public class GeneradorHorari {

    private static Graph G;

    private static Map<Sessio, Set<UAH>> valPoss;

    public static Graph getG() {
        return G;
    }

    /**
     * Fa propagació de restriccions d'una sessió
     * @param sFutures sessions amb UAHs pendents a assignar
     * @param sActual sessió a la qual apliquem la propagació de restriccions
     */

    private static void propagar_restriccions(Queue<Sessio> sFutures, Sessio sActual, UAH uah) {
        //iterem per totes les sessions que no tenen valor assignat
        for (Sessio s : sFutures) {
            //if (s != sActual) {
                //valPoss.get(s).remove(uah);
                //comparem amb totes les sessions amb les que té restriccio sActual
                for (Sessio conflictiva : G.getArestes().get(sActual)) {
                    //si s d'sFutures té restricció amb sActual
                    if (s == conflictiva) {
                        Set<UAH> toRemove = new HashSet<>();
                        //iterem per tot el domini de la sessió conflictiva
                        for (UAH uahConflictiva : valPoss.get(conflictiva)) {
                            //si l'UAH del domini és conflictiva amb l'assignació d'sActual, l'eliminem
                            if (RestriccioBinaria.coincideixenUAH(uah, uahConflictiva))
                                //eliminem la uahConflictiva del domini de s
                                toRemove.add(uahConflictiva);
                        }
                        valPoss.get(conflictiva).removeAll(toRemove);
                    }
                }
            //}
        }
    }

    //pre: sFutures subconjunt de vèrtexs del graf
    private static boolean algun_dominio_vacio(Queue<Sessio> sFutures) {
        for (Sessio s : sFutures) {
            //isEmpty?? == NULL??
            if (valPoss.get(s).isEmpty()) return true;
        }
        return false;
    }

    private static Set<UAH> copyValPoss(Sessio s) {
        Set<UAH> resultat = new HashSet<>();
        for (UAH uah : valPoss.get(s)) {
            resultat.add(uah);
        }
        return resultat;
    }

    private static void imprimeixSessions(Queue<Sessio> sFutures) {
        for (Sessio s : sFutures) System.out.println(s.getAssignatura().getNom() + " " + s.getIdGrup() + " " + s.getTipus());
    }

    /**
     * Mira si el domini d'una sessió té algun valor que compleixi restricció amb una altra (per a la propagació de restriccions)
     * @param solapa uah de la sessió que té la restricció (destí de l'arc)
     * @param sActual sessió a la qual apliquem propagació de restriccions
     * @return true si té algun valor possible, false altrament
     */
    //private boolean compatible(UAH solapa, Sessio sActual) {

    //}

    /**
     * Crea l'horari amb satisfacció de restriccions
     * @param sFutures sessions amb UAHs pendents a assignar
     * @param solucio solució parcial
     * @return Horari amb les assignacions correpsonents que satisfan les restriccions
     */
    private static Horari forward_checking(Queue<Sessio> sFutures, Horari solucio) {
        if (sFutures.isEmpty()) {
            CtrlDominiGenerarHorari.comptaSessions();
            System.out.println(solucio.comptaAssignacions());
            return solucio;
        } else {
            // Obtenim el següent element
            Sessio sActual = sFutures.element();
            sFutures.remove(sActual);
            Set<UAH> valors = copyValPoss(sActual);
            for (UAH uah : valors) {
                if (!uah.teSessio()) {
                    solucio.assignarUAH(sActual, uah);
                    uah.setSessio(sActual);
                    sActual.setUah(uah);
                    if (solucio.assignacioCompleta(sActual))
                    propagar_restriccions(sFutures, sActual, uah);
                    if (!algun_dominio_vacio(sFutures)) {
                        solucio = forward_checking(sFutures, solucio);
                        if (!solucio.esFallo()) {
                            return solucio;
                        } else {
                            sFutures.add(solucio.getFallo());
                            uah.eliminaSessio();
                            solucio.eliminarUAH(sActual, uah);
                            solucio.noEsFallo();
                        }
                    } else {
                        solucio.eliminarUAH(sActual, uah);
                        uah.eliminaSessio();
                    }
                }
            }
            solucio.setFallada(sActual);
            return solucio;
        }
    }

    /**
     *  l'horari
     * @return l'Horari generat segons la inicialització del graf
     */

    public static Horari generarHorari() {
        //iniGraf(restriccioHora, restriccioDia);
        G = CtrlDominiGenerarHorari.iniGraf();
        valPoss = G.copyVertexs();
        Horari solucio = new Horari();
        Queue<Sessio> vfutures = new LinkedList<Sessio>(CtrlDominiGenerarHorari.getSessions());
        //Map<Sessio, Set<UAH>> vals = G.copyVertexs();
        int compt = 0;
        //int compt2 = 0;
        solucio = forward_checking(vfutures, solucio);
        return solucio;
    }
}
