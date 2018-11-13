package Dominio;

import java.util.*;

public class CtrlDomini {



    private static HashSet<Sessio> sessions;

    private final static HashSet<UAH> UAHmatins = new HashSet<>();
    private final static HashSet<UAH> UAHtardes = new HashSet<>();
    private final static HashSet<UAH> UAHteoria = new HashSet<>();
    private final static HashSet<UAH> UAHlaboratori = new HashSet<>();

    public static void generarHorari(PlaEstudis pe, ConjuntAules cjtAules) {
        crearSessions(pe, cjtAules);
        crearUAHs(pe,cjtAules);
        Horari solucio = GeneradorHorari.generarHorari(pe, cjtAules);
        imprimirHorari(solucio);
    }

    public static void imprimirHorari(Horari solucio) {

        inout io = new inout();



    }

    public static HashSet<Sessio> getSessionsByIdAssig(String idAssig) {
        Set<Sessio> SessionsAssig = new HashSet<>();
        for (Sessio s : sessions) {
            if (s.getAssignatura().getNom() == idAssig) SessionsAssig.add(s);
        }
        return SessionsAssig;
    }

    private static void crearSessions(PlaEstudis PlaE) {

        sessions = new HashSet<Sessio>();

        for (Assignatura a : PlaE.getCjtAssig().getConjuntAssignatures()) {
            for(int i = 1; i <= a.getnGrupsT(); ++i) {
                Sessio sT = new Sessio(a);

                sT.setIdGrup(i * 10);
                sT.setDuracio(a.getnHoresT());
                sT.setTipus(Enumeracio.TipusSessio.TEORIA);
                sessions.add(sT);

                for (int j = 1; j <= a.getnGrupsL(); ++j) {
                    Sessio sL = new Sessio(a);
                    sL.setIdGrup(i * 10 + j);
                    sL.setDuracio(a.getnHoresL());
                    sL.setTipus(Enumeracio.TipusSessio.LABORATORI);
                    sessions.add(sL);
                }

                for (int j = 1; j <= a.getnGrupsP(); ++j) {
                    Sessio sP = new Sessio(a);
                    sP.setIdGrup(i * 10 + j);
                    sP.setDuracio(a.getnHoresP());
                    sP.setTipus(Enumeracio.TipusSessio.PROBLEMES);
                    sessions.add(sP);
                }
            }
        }

    }


    private static void crearUAHs(PlaEstudis PlaE, ConjuntAules cjtAules) {

        for (Aula a : cjtAules.getConjuntAules()) {
            for (Enumeracio.Dia dia : Enumeracio.Dia.values()) {
                for (int i = PlaE.getHoraInici(); i < PlaE.getHoraFi(); i++) {
                    UAH uah = new UAH(a);

                    uah.setHora(i);
                    uah.setDia(dia);

                    if (i < PlaE.getHoraCanviFranja()) UAHmatins.add(uah);
                    else UAHtardes.add(uah);

                    if ((a.getTipusAula()).equals(Enumeracio.TipusAula.TEORIA)) UAHteoria.add(uah);
                    else UAHlaboratori.add(uah);
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

    public static HashSet<Sessio> getSessions() {
        return sessions;
    }

    public static void setSessions(HashSet<Sessio> sessions) {
        CtrlDomini.sessions = sessions;
    }
}
