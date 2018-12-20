package dominio.classes;

import java.util.*;
import dominio.controladores.CtrlDominiGenerarHorari;

public class GeneradorHorari {

    private static Graph G;
    private static CtrlDominiGenerarHorari CtrlDomini = CtrlDominiGenerarHorari.getInstance();

    public static Graph getG() {
        return G;
    }

    public static void setG(Graph g) {
        G = g;
    }


    /**
     * Inicialitza el graf amb tots els vèrtexs i arestes corresponents segons les dades entrades
     */

    private static void iniGraf() {

        G = new Graph();

        for (Sessio s : CtrlDomini.getSessions()) {

            //INICIALITZACIÓ VÈRTEXS
            Set<UAH> domini = new HashSet<UAH>(RestriccioUnaria.crearDomini(s));
            G.afegirVertex(s, domini);

            //INICIALITZACIÓ ARESTES
            Set<Sessio> arestesSessio = new HashSet<>(Restriccions.crearArestes(s));
            G.afegirAresta(s, arestesSessio);

        }


    }

    /**
     * Crea l'horari amb satisfacció de restriccions
     * @param sFutures sessions amb UAHs pendents a assignar
     * @param solucio solució parcial
     * @return Horari amb les assignacions correpsonents que satisfan les restriccions
     */
    private static Horari backtracking_cronologic(Queue<Sessio> sFutures, Horari solucio) {
        if (sFutures.isEmpty())
            return solucio;
        else {
            // Obtenim el seguent element
            Sessio sActual = sFutures.element();

            for (UAH uah : G.getUAHbySessio(sActual)) {
                solucio.assignarUAH(sActual, uah);
                if (solucio.valida(sActual, uah)) {
                    if (solucio.assignacioCompelta(sActual)) sFutures.remove();
                    solucio = backtracking_cronologic(sFutures, solucio);
                    if (!solucio.esfallo()) {
                        return solucio;
                    } else solucio.eliminarUAH(sActual, uah);
                } else solucio.eliminarUAH(sActual, uah);
            }
            return new Horari();
        }
    }

    /**
     * Genera l'horari
     * @return l'Horari generat segons la inicialització del graf
     */

    public static Horari generarHorari() {

        iniGraf();
        Horari solucio = new Horari();
        Queue<Sessio> vfutures = new LinkedList<Sessio>(CtrlDomini.getSessions());

        solucio = backtracking_cronologic(vfutures, solucio);
        return solucio;
    }

}
