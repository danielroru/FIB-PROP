package dominio.controladores;

import dominio.classes.*;
import javafx.util.Pair;

import java.util.*;

public class CtrlDominiGenerarHorari {

    private static Queue<Sessio> sessions;

    private static HashSet<UAH> UAHmatins = new HashSet<>();
    private static HashSet<UAH> UAHtardes = new HashSet<>();
    private static HashSet<UAH> UAHteoria = new HashSet<>();
    private static HashSet<UAH> UAHlaboratori = new HashSet<>();
    private static HashSet<UAH> UAHs = new HashSet<>();

    public CtrlDominiGenerarHorari() {

    }

    public static void reset() {
        sessions = new LinkedList<>();
        UAHmatins = new HashSet<>();
        UAHtardes = new HashSet<>();
        UAHteoria = new HashSet<>();
        UAHlaboratori = new HashSet<>();
        UAHs = new HashSet<>();
    }

    /**
     * Inicialitza el graf amb tots els vèrtexs i arestes corresponents segons les dades entrades
     */
    public static Graph iniGraf() {
        Graph G = new Graph();
        for (Sessio s : sessions) {

            //INICIALITZACIÓ VÈRTEXS
            Set<UAH> domini = new HashSet<UAH>(RestriccioUnaria.crearDomini(s));
            G.afegirVertex(s, domini);

            //INICIALITZACIÓ ARESTES
            Set<Sessio> arestesSessio = new HashSet<>(Restriccions.crearArestes(s));
            G.afegirAresta(s, arestesSessio);

        }
        return G;
    }

    public static Horari generarHorari(){
        reset();
        crearUAHs();
        crearSessions();
        Horari h = GeneradorHorari.generarHorari();
        CtrlDomini.getPlaEstudis().setUltimHorari(h);
        h.mapejaHorari();
        return h;
    }

    public static Horari modificarDades(String oldDia, String oldHora, String oldAula,
                                        String newDia, String newHora, String newAula, Horari ultimHorari) {

        Enumeracio.Dia dia1 = Enumeracio.Dia.valueOf(oldDia.toUpperCase());
        int hora1 = Integer.parseInt(oldHora);
        Enumeracio.Dia dia2 = Enumeracio.Dia.valueOf(newDia.toUpperCase());
        int hora2 = Integer.parseInt(newHora);

        UAH uah1 = new UAH();
        UAH uah2 = new UAH();
        for (UAH uah : UAHs) {
            if ((uah.getDia() == dia1) && (uah.getHora() == hora1) && (uah.getAula().getId() == oldAula))
                uah1 = uah;
            else if ((uah.getDia() == dia2) && (uah.getHora() == hora2) && (uah.getAula().getId() == newAula))
                uah2 = uah;
        }
        if (uah1 == new UAH() || uah2 == new UAH()) System.out.println("MAL");
        ModificadorHorari.modificaHorari(uah1, uah2, ultimHorari);
        return ultimHorari;
    }

    public static ArrayList<Pair<String, String[][][]>> escriureHorari() {
        return CtrlDomini.getPlaEstudis().getUltimHorari().passarString();
    }


    public static Set<Sessio> getSessionsByIdAssig(String idAssig) {
        Set<Sessio> SessionsAssig = new HashSet<>();
        for (Sessio s : sessions) {
            if (s.getAssignatura().getNom() == idAssig) SessionsAssig.add(s);
        }
        return SessionsAssig;
    }

    private static void crearSessions() {

        sessions = new LinkedList<>();

        for (Assignatura a : CtrlDomini.getPlaEstudis().getConjuntAssignatures().getAssignatures()) {
            for(int i = 1; i <= a.getnGrupsT(); ++i) {
                Sessio sT = new Sessio();
                sT.setAssignatura(a);
                sT.setIdGrup(i * 10);
                sT.setTipus(Enumeracio.TipusSessio.TEORIA);
                for (int j = 0; j < a.getnHoresT(); ++j) {
                    sT.setId(j);
                    sessions.add(sT);
                }

                for (int j = 1; j <= a.getnGrupsL(); ++j) {
                    Sessio sL = new Sessio();
                    sL.setAssignatura(a);
                    sL.setIdGrup(i * 10 + j);
                    sL.setTipus(Enumeracio.TipusSessio.LABORATORI);
                    for (int t = 0; t < a.getnHoresL(); ++t) {
                        sL.setId(t);
                        sessions.add(sL);
                    }
                }

                for (int j = 1; j <= a.getnGrupsP(); ++j) {
                    Sessio sP = new Sessio();
                    sP.setAssignatura(a);
                    sP.setIdGrup(i * 10 + j);
                    sP.setTipus(Enumeracio.TipusSessio.PROBLEMES);
                    for (int t = 0; t < a.getnHoresP(); ++t) {
                        sP.setId(t);
                        sessions.add(sP);
                    }
                }
            }
        }

    }

    public static void comptaSessions() {
        int compt = 0;
        for (Assignatura ass : CtrlDomini.getPlaEstudis().getConjuntAssignatures().getAssignatures()) {
            compt += ass.getnHoresT()*ass.getnGrupsT() + ass.getnGrupsT()*ass.getnGrupsL()*ass.getnHoresL() + ass.getnGrupsT()*ass.getnGrupsP()*ass.getnHoresP();
        }
        System.out.println(compt + " sessions");
    }


    private static void crearUAHs() {

        for (Aula a : CtrlDomini.getPlaEstudis().getConjuntAules().getAules()) {
            for (Enumeracio.Dia dia : Enumeracio.Dia.values()) {
                for (int i = CtrlDomini.getPlaEstudis().getHoraInici(); i < CtrlDomini.getPlaEstudis().getHoraFi(); i++) {

                    UAH uah = new UAH();

                    uah.setHora(i);
                    uah.setDia(dia);
                    uah.setAula(a);

                    if (i < CtrlDomini.getPlaEstudis().getHoraCanviFranja()) UAHmatins.add(uah);
                    else UAHtardes.add(uah);

                    if ((a.getTipusAula()).equals(Enumeracio.TipusAula.TEORIA)) UAHteoria.add(uah);
                    else UAHlaboratori.add(uah);

                    UAHs.add(uah);
                }
            }
        }
    }

    public static HashSet<UAH> getUAHmatins() {
        return UAHmatins;
    }

    public static HashSet<UAH> getUAHtardes() {
        return UAHtardes;
    }

    public static HashSet<UAH> getUAHteoria() {
        return UAHteoria;
    }

    public static HashSet<UAH> getUAHlaboratori() {
        return UAHlaboratori;
    }

    public static HashSet<UAH> getUAHs() {
        return UAHs;
    }

    public static Queue<Sessio> getSessions() {
        return sessions;
    }
}
