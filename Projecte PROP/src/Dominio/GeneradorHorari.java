package Dominio;

import java.util.*;

public class GeneradorHorari {

    private static Graph G;

    public static Graph getG() {
        return G;
    }

    public static void setG(Graph g) {
        G = g;
    }

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

    private static Estructura backtracking_cronologic(Queue<Sessio> sFutures, Estructura solucio) {
        if (sFutures.isEmpty())
            return solucio;
        else {
            // Obtenim el seguent element
            Sessio sActual = sFutures.element();
            sFutures.remove();

            for (UAH uah : G.getUAHbySessio(sActual)) {
                solucio.assignarUAH(sActual, uah);
                if (solucio.valida(sActual, uah)) {
                    Queue<Sessio> sFu = sFutures;
                    if (!solucio.assignacioCompelta(sActual)) sFu.add(sActual);
                    solucio = backtracking_cronologic(sFu, solucio);
                    if (!solucio.esfallo()) {
                        return solucio;
                    } else solucio.eliminarUAH(sActual, uah);
                } else solucio.eliminarUAH(sActual, uah);
            }
            return new Estructura();
        }
    }

    public static Estructura generarHorari() {

        iniGraf();
        Estructura solucio = new Estructura();
        Queue<Sessio> vfutures = new LinkedList<Sessio>(CtrlDomini.getSessions());

        solucio = backtracking_cronologic(vfutures, solucio);
        return solucio;
    }
}
