package Dominio;

import java.util.*;

public class GeneradorHorari {

    private static Graph G = new Graph();

    public static Graph getG() {
        return G;
    }

    public static void setG(Graph g) {
        G = g;
    }

    private static void iniGraf(PlaEstudis pe, ConjuntAules cjtAules) {

        Set<Sessio> sessions = CtrlDomini.getSessions();

        for (Sessio s : sessions) {

            //INICIALITZACIÓ VÈRTEXS
            Set<UAH> domini = new HashSet<UAH>(RestriccioUnaria.crearDomini(pe.getCjtAssig(), s));
            G.afegirVertex(s, domini);

            //INICIALITZACIÓ ARESTES
            Set<Sessio> arestesSessio = new HashSet<>(Restriccions.crearArestes(pe.getCjtAssig(), s));
            G.afegirAresta(s, arestesSessio);

        }


    }

    private Set<UAH> getValors(Sessio s) {
        return G.getVertexs().get(s);
    }

    private void assignar(Sessio s, UAH uah) {

        G.getVertexs().get(s).add(uah);

    }

    private static Horari backtracking_cronologic(Queue<Sessio> vfutures, Horari solucio) {
        if (vfutures.isEmpty())
            return solucio;
        else {
            Sessio vactual = vfutures.element();
            vfutures.remove();

            for (UAH uah : G.getVertexs().get(vactual)) {
                solucio.assignarUAH(vactual, uah);

                if (solucio.valida(vactual, uah)) {
                    solucio = backtracking_cronologic(vfutures, solucio);
                    if (!solucio.esfallo()) {
                        return solucio;
                    } else solucio.eliminarUAH(vactual);
                } else solucio.eliminarUAH(vactual);
            }
            return new Horari();
        }
    }

    public static Horari generarHorari(PlaEstudis pe, ConjuntAules cjtAules) {

        iniGraf(pe, cjtAules);
        Horari solucio = new Horari();
        Queue<Sessio> vfutures = new LinkedList<Sessio>(CtrlDomini.getSessions());

        solucio = backtracking_cronologic(vfutures, solucio);
        return solucio;
    }
}
