package Dominio;

import java.util.*;

public class GeneradorHorari {
    private Graph G = new Graph();
    private Horari solucio = new Horari();


    private void iniGraf() {

        Set<Sessio> sessions = CtrlDomini.crearSessions();
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

    public Horari generarHorari() {

        iniGraf();

        return solucio;

    }
}
