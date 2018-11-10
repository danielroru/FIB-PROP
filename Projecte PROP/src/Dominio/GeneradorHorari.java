package Dominio;

import java.util.*;

public class GeneradorHorari {
    private Graph G = new Graph();

    private void iniGraf(PlaEstudis pe, ConjuntAules cjtAules) {

        Set<Sessio> sessions = CtrlDomini.getSessions();
        HashMap<Sessio, Set<UAH>> vertexs = new HashMap<>();
        HashMap<Sessio, Set<Sessio>> arestes = new HashMap<>();

        for (Sessio s : sessions) {
            //INICIALITZACIÓ VÈRTEXS
            Set<UAH> domini = RestriccioUnaria.crearDomini(s);
            vertexs.put(s, domini);
            G.setVertexs(vertexs);
            //INICIALITZACIÓ ARESTES
            Set<Sessio> arestesSessio = Restriccions.crearArestes(s);
            arestes.put(s, arestesSessio);
            G.setArestes(arestes);
        }

    }

    private Set<UAH> getValors(Sessio s) {
        return G.getVertexs().get(s);
    }

    private void assignar(Sessio s, UAH uah) {
        G.getVertexs().get(s).clear();
        G.getVertexs().put(s, uah);
    }

    private Horari backtracking_cronologic(Queue<Sessio> vfutures, Horari solucio) {
        if (vfutures.isEmpty())
            return solucio;
        else {
            Sessio vactual = vfutures.element();
            for (UAH uah : getValors(vactual)) {
                assignar(vactual, uah);
            }
        }
    }

    public static Horari generarHorari(PlaEstudis pe, ConjuntAules cjtAules) {

        iniGraf(pe, cjtAules);
        Horari solucio = new Horari();
        Queue<Sessio> vfutures = new Queue<Sessio>(vfutures.addAll(CtrlDomini.crearSessions()));
        solucio = backtracking_cronologic(vfutures, solucio);
        return solucio;

    }
}
