package Dominio;
import com.sun.deploy.util.SessionState;

import java.util.*;

public class CtrlDomini {

    public static HashSet<Sessio> getSessions() {
        return sessions;
    }

    public static void setSessions(HashSet<Sessio> sessions) {
        CtrlDomini.sessions = sessions;
    }

    private static HashSet<Sessio> sessions;

    private static HashSet<UAH> UAHmatins;
    private static HashSet<UAH> UAHtardes;
    private static HashSet<UAH> UAHteoria;
    private static HashSet<UAH> UAHlaboratori;

    public static void generarHorari(PlaEstudis pe, ConjuntAules cjtAules) {
        crearSessions(pe, cjtAules);
        crearUAHs(pe,cjtAules);
        GeneradorHorari.generarHorari(pe, cjtAules);
    }

    public static HashSet<Sessio> getSessionsByIdAssig(String idAssig) {
        HashSet<Sessio> SessionsAssig = new HashSet<>();
        for (Sessio s : sessions) {
            if (s.getNomAssig() == idAssig) SessionsAssig.add(s);
        }
        return SessionsAssig;
    }

    private static void crearSessions(PlaEstudis PlaE, ConjuntAules cjtAules) {

        ConjuntAssignatures cjtAssig = PlaE.getCjtAssig();

        sessions = new HashSet<Sessio>();

        for (Assignatura a : cjtAssig.getConjuntAssignatures().values()) {
            for(int i = 1; i <= a.getnGrupsT(); ++i) {
                Sessio sT = new Sessio();
                sT.setNomAssig(a.getNom());
                sT.setIdGrup(i * 10);
                sT.setDuracio(a.getnHoresT());
                sT.setTipus(Enumeracio.TipusSessio.TEORIA);
                sessions.add(sT);
                for (int j = 1; j <= a.getnGrupsL(); ++j) {
                    Sessio sL = new Sessio();
                    sL.setNomAssig(a.getNom());
                    sL.setIdGrup(i * 10 + j);
                    sL.setDuracio(a.getnHoresL());
                    sL.setTipus(Enumeracio.TipusSessio.LABORATORI);
                    sessions.add(sL);
                }
                for (int j = 1; j <= a.getnGrupsP(); ++j) {
                    Sessio sP = new Sessio();
                    sP.setNomAssig(a.getNom());
                    sP.setIdGrup(i * 10 + j);
                    sP.setDuracio(a.getnHoresP());
                    sP.setTipus(Enumeracio.TipusSessio.PROBLEMES);
                    sessions.add(sP);
                }
            }
        }

    }


    private static void crearUAHs(PlaEstudis PlaE, ConjuntAules cjtAules) {
        UAHmatins = new HashSet<UAH>();
        UAHtardes = new HashSet<UAH>();
        UAHteoria = new HashSet<UAH>();
        UAHlaboratori = new HashSet<UAH>();

        for (Aula a : cjtAules.getConjuntAules()) {
            for (Enumeracio.Dia dia : Enumeracio.Dia.values()) {
                for (int i = PlaE.getHoraInici(); i < PlaE.getHoraFi(); i++) {
                    UAH uah = new UAH();

                    uah.setIdAula(a.getId());
                    uah.setIdHora(i);
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

    public static void setUAHmatins(HashSet<UAH> UAHmatins) {
        CtrlDomini.UAHmatins = UAHmatins;
    }

    public static HashSet<UAH> getUAHtardes() {
        return UAHtardes;
    }

    public static void setUAHtardes(HashSet<UAH> UAHtardes) {
        CtrlDomini.UAHtardes = UAHtardes;
    }

    public static HashSet<UAH> getUAHteoria() {
        return UAHteoria;
    }

    public static void setUAHteoria(HashSet<UAH> UAHteoria) {
        CtrlDomini.UAHteoria = UAHteoria;
    }

    public static HashSet<UAH> getUAHlaboratori() {
        return UAHlaboratori;
    }

    public static void setUAHlaboratori(HashSet<UAH> UAHlaboratori) {
        CtrlDomini.UAHlaboratori = UAHlaboratori;
    }

}
