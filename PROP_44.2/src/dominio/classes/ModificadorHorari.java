package dominio.classes;

import dominio.controladores.CtrlDomini;
import dominio.controladores.CtrlDominiGenerarHorari;

public class ModificadorHorari {

    private static void swap(Sessio s1, Sessio s2) {
        UAH aux = s1.getUah();
        s1.setUah(s2.getUah());
        s2.setUah(aux);
    }

    private static boolean compleixRestriccions() {
        Graph G = CtrlDominiGenerarHorari.iniGraf();
        System.out.println(G.getVertexs().keySet().size());
        //iterem per totes les sessions
        for (Sessio s : G.getVertexs().keySet()) {
            //iterem per totes les sessions conflictives de s
            for (Sessio conflictiva : G.getArestes().get(s)) {
                if (s != conflictiva && s.getUah() != null && conflictiva.getUah() != null)
                if (RestriccioBinaria.coincideixenUAH(s.getUah(), conflictiva.getUah()))
                    return false;
            }
        }
        return true;
    }

    public static void modificaHorari(UAH uah1, UAH uah2, Horari ultimHorari) {
        if (uah1.getAula().getTipusAula() == uah2.getAula().getTipusAula()) {
            swap(uah1.getSessio(), uah2.getSessio());
            if (!compleixRestriccions()) {
                System.out.println("El canvi que s'ha fet no compleix les restriccions especificades");
                swap(uah1.getSessio(), uah2.getSessio());
            } else {
                int i1 = uah1.getDia().ordinal();
                int j1 = uah1.getHora() - PlaEstudis.getHoraInici();
                int i2 = uah2.getDia().ordinal();
                int j2 = uah2.getHora() - PlaEstudis.getHoraInici();
                ultimHorari.getHorari().get(uah1.getAula().getId()).swap(i1, j1, i2, j2);
            }
        } else {
            System.out.println("Les dues Sessions no poden intercanviar aules per problemes de tipus");
        }
    }

}
