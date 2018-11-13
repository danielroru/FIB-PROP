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

    private static void iniGraf() {

        for (Sessio s : CtrlDomini.getSessions()) {

            //INICIALITZACIÓ VÈRTEXS
            Set<UAH> domini = new HashSet<UAH>(RestriccioUnaria.crearDomini(s));
            G.afegirVertex(s, domini);

            //INICIALITZACIÓ ARESTES
            Set<Sessio> arestesSessio = new HashSet<>(RestriccioBinaria.arestesNivell(s));
            G.afegirAresta(s, arestesSessio);

        }


    }

    private static Horari backtracking_cronologic(Queue<Sessio> sFutures, Horari solucio) {
        if (sFutures.isEmpty())

            return solucio;
        else {
            // Obtenim el seguent element
            Sessio sActual = sFutures.element();
            sFutures.remove();

            for (UAH uah : G.getUAHbySessio(sActual)) {
                if (solucio.valida(sActual, uah)) {
                    solucio.assignarUAH(sActual, uah);
                    solucio = backtracking_cronologic(sFutures, solucio);
                    if (!solucio.esfallo()) {
                        return solucio;
                    } else solucio.eliminarUAH(sActual, uah);
                } else solucio.eliminarUAH(sActual, uah);
            }
            return new Horari();
        }
    }

    public static Horari generarHorari() {

        iniGraf();
        Horari solucio = new Horari();
        Queue<Sessio> vfutures = new LinkedList<Sessio>(CtrlDomini.getSessions());

        solucio = backtracking_cronologic(vfutures, solucio);
        return solucio;
    }
}
