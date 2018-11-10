package Dominio;

import java.util.*;

public class GeneradorHorari {
    private Graph G = new Graph();

    private void iniGraf() {

        Set<Sessio> sessions = CtrlDomini.crearSessions();
        HashMap<Sessio, Set<UAH>> vertexs = new HashMap<>();
        HashMap<Sessio, Set<Sessio>> arestes = new HashMap<>();

        for (Sessio s : sessions) {
            //INICIALITZACIÓ VÈRTEXS
            Set<UAH> domini = RestriccioUnaria.crearDomini(s);
            vertexs.put(s, domini);
            //INICIALITZACIÓ ARESTES
            Set<Sessio> arestesSessio = RestriccioBinaria.arestesNivell(s);
            arestes.put(s, arestesSessio);
        }


    }

    public void generarHorari() {

    }
}
