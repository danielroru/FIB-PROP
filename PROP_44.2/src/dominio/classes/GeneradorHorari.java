package dominio.classes;

import dominio.controladores.CtrlDomini;

import java.util.*;

public class GeneradorHorari {

    private static Graph G = new Graph();

    private static Map<Sessio, Set<UAH>> valPoss = new HashMap<>();

    public static Graph getG() {
        return G;
    }


    /**
     * Inicialitza el graf amb tots els vèrtexs i arestes corresponents segons les dades entrades
     */
    private static void iniGraf() {

        for (Sessio s : CtrlDomini.getSessions()) {

            //INICIALITZACIÓ VÈRTEXS
            Set<UAH> domini = new HashSet<UAH>(RestriccioUnaria.crearDomini(s));
            G.afegirVertex(s, domini);

            //INICIALITZACIÓ ARESTES
            Set<Sessio> arestesSessio = new HashSet<>(Restriccions.crearArestes(s));
            G.afegirAresta(s, arestesSessio);

        }
        valPoss  = G.copyVertexs();
    }

    private static boolean compatible(UAH uah, Sessio s) {
        for (UAH uahConflicte : G.getVertexs().get(s)) {
            if (RestriccioBinaria.coincideixenUAH(uahConflicte, uah))
                return false;
        }
        return true;
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
    private static Horari backtracking_cronologic(Queue<Sessio> sFutures, Horari solucio, int compt) {
        ++compt;
        System.out.println("iteracio: " + compt);
        //System.out.println(sFutures.size() + " sFutures");
        if (sFutures.isEmpty()) {
            //System.out.println("sFutures empty: " + compt);
            return solucio;
        } else {
            // Obtenim el següent element
            Sessio sActual = sFutures.element();
            int compt2 = 0;
            Set<UAH> valors = copyValPoss(sActual);
            for (UAH uah : valors) {
                ++compt2;
                if (!uah.teSessio()) {
                    sFutures.remove(sActual);
                    solucio.assignarUAH(sActual, uah);
                    uah.setSessio(sActual);
                    sActual.setUah(uah);
                    int cont = solucio.comptaAssignacions();
                    //if (compt == 1)
                    //imprimeixSessions(sFutures);
                    System.out.println("mida sFutures: " + sFutures.size());
                    System.out.println("mida solucio: " + solucio.comptaAssignacions());
                    System.out.println("Iteració: " + compt + " VALOR " + compt2 + " maxim " + valPoss.get(sActual).size());
                    System.out.println("AFAGEIX " + sActual.getAssignatura().getNom() + ' ' + sActual.getIdGrup() + ' ' + sActual.getTipus());
                    System.out.println("UAH: " + uah.getDia() + ' ' + uah.getHora() + ' ' + uah.getAula().getId());
                    if (solucio.assignacioCompleta(sActual))
                    propagar_restriccions(sFutures, sActual, uah);
                    if (!algun_dominio_vacio(sFutures)) {
                        //if ((compt == 115 && compt2 == 8) || (compt == 114 && compt2 == 3)) imprimeixSessions(sFutures);
                        //if (compt == 125) {
                        //    System.out.println("sFutures " + compt);
                        //    imprimeixSessions(sFutures);
                        //}
                        //Horari sol2 = backtracking_cronologic(sFutures, solucio, compt);
                        solucio = backtracking_cronologic(sFutures, solucio, compt);
                        System.out.println("it: " + compt + " assignacions postbacktracking: " + solucio.comptaAssignacions());
                        System.out.println(solucio.comptaAssignacions() + " assignacions solucio");
                        if (!solucio.esFallo()) {
                            //solucio = solucio;
                            if ((solucio.comptaAssignacions() + sFutures.size()) < 131) System.out.println("______ FALLO _____");
                            return solucio;
                        } else {
                            sFutures.add(solucio.getFallo());
                            uah.eliminaSessio();
                            solucio.eliminarUAH(sActual, uah);
                            solucio.noEsFallo();
                            //if ((solucio.comptaAssignacions() + sFutures.size()) < 131) System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>FALLO _____" + sFutures.size() + " " + solucio.comptaAssignacions());
                            //System.out.println("Iteració: " + compt + " VALOR " + compt2 + " maxim " + valPoss.get(sActual).size());
                            //System.out.println("ELIMINA else1 " + sActual.getAssignatura().getNom() + ' ' + sActual.getIdGrup() + ' ' + sActual.getTipus());
                            //System.out.println("UAH: " + uah.getDia() + ' ' + uah.getHora() + ' ' + uah.getAula().getId());
                            //System.out.println("sFutures postelse: " + sFutures.size());
                            //System.out.println(solucio.comptaAssignacions() + " assignacions solucio postelse");
                        }
                    } else {
                        //System.out.println(compt + " " + "ELIMINA else 2 " + sActual.getAssignatura().getNom() + ' ' + sActual.getIdGrup() + ' ' + sActual.getTipus());
                        //System.out.println("UAH: " + uah.getDia() + ' ' + uah.getHora() + ' ' + uah.getAula().getId());
                        solucio.eliminarUAH(sActual, uah);
                        uah.eliminaSessio();
                        //sFutures.add(sActual);
                    }
                    //sFutures.add(sActual);
                }
            }
            //System.out.println("---------------------------NOU HORARI " + compt + "---------------------------------------" + sFutures.size() + " " + solucio.comptaAssignacions());
            //imprimeixSessions(sFutures);
            solucio.setFallada(sActual);
            return solucio;
        }
    }

    /**
     *  l'horari
     * @return l'Horari generat segons la inicialització del graf
     */

    public static Horari generarHorari() {

        iniGraf();
        Horari solucio = new Horari();
        Queue<Sessio> vfutures = new LinkedList<Sessio>(CtrlDomini.getSessions());
        //Map<Sessio, Set<UAH>> vals = G.copyVertexs();
        int compt = 0;
        //int compt2 = 0;
        solucio = backtracking_cronologic(vfutures, solucio, compt);
        return solucio;
    }

    private static void imprimeixAssignacions(Horari solucio) {
        for (Sessio s : solucio.getAssignacio().keySet()) {
            System.out.println(s.getAssignatura().getNom() + " " + s.getIdGrup() + " " + s.getTipus());
            for (UAH uah : solucio.getAssignacio().get(s))
                System.out.println(" ----" + uah.getDia() + " " + uah.getHora() + " " + uah.getAula().getId());
        }
    }
}
