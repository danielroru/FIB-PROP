package dominio.controladores;

import dominio.classes.*;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CtrlDominiGenerarHorari {

    private static CtrlDominiGenerarHorari instance = new CtrlDominiGenerarHorari();

    private static HashSet<Sessio> sessions;

    private static HashSet<UAH> UAHmatins = new HashSet<>();
    private static HashSet<UAH> UAHtardes = new HashSet<>();
    private static HashSet<UAH> UAHteoria = new HashSet<>();
    private static HashSet<UAH> UAHlaboratori = new HashSet<>();

    private static Horari ultimHorari = new Horari();

    private static PlaEstudis plaEstudis = PlaEstudis.getInstance();

    private CtrlDominiGenerarHorari() {}

    public static CtrlDominiGenerarHorari getInstance() {
        return instance;
    }

    public static void reset() {
        UAHmatins = new HashSet<>();
        UAHtardes = new HashSet<>();
        UAHteoria = new HashSet<>();
        UAHlaboratori = new HashSet<>();
    }

    public static boolean existeixUltimHorari() {
        return ultimHorari.getHorari().size() != 0;
    }

    public static Horari generarHorari(){
        reset();
        crearUAHs();
        crearSessions();
        ultimHorari = GeneradorHorari.generarHorari();
        ultimHorari.mapejaHorari();
        return ultimHorari;
    }

    public static ArrayList<Pair<String, String[][][]>> escriureHorari() {
        return ultimHorari.passarString();
    }


    public static Set<Sessio> getSessionsByIdAssig(String idAssig) {
        Set<Sessio> SessionsAssig = new HashSet<>();
        for (Sessio s : sessions) {
            if (s.getAssignatura().getNom() == idAssig) SessionsAssig.add(s);
        }
        return SessionsAssig;
    }

    private static void crearSessions() {

        sessions = new HashSet<Sessio>();

        for (Assignatura a : plaEstudis.getConjuntAssignatures().getAssignatures()) {
            for(int i = 1; i <= a.getnGrupsT(); ++i) {
                Sessio sT = new Sessio();
                sT.setAssignatura(a);
                sT.setIdGrup(i * 10);
                sT.setTipus(Enumeracio.TipusSessio.TEORIA);
                sessions.add(sT);

                for (int j = 1; j <= a.getnGrupsL(); ++j) {
                    Sessio sL = new Sessio();
                    sL.setAssignatura(a);
                    sL.setIdGrup(i * 10 + j);
                    sL.setTipus(Enumeracio.TipusSessio.LABORATORI);
                    sessions.add(sL);
                }

                for (int j = 1; j <= a.getnGrupsP(); ++j) {
                    Sessio sP = new Sessio();
                    sP.setAssignatura(a);
                    sP.setIdGrup(i * 10 + j);
                    sP.setTipus(Enumeracio.TipusSessio.PROBLEMES);
                    sessions.add(sP);
                }
            }
        }

    }


    private static void crearUAHs() {

        for (Aula a : plaEstudis.getConjuntAules().getAules()) {
            for (Enumeracio.Dia dia : Enumeracio.Dia.values()) {
                for (int i = plaEstudis.getHoraInici(); i < plaEstudis.getHoraFi(); i++) {

                    UAH uah = new UAH();

                    uah.setHora(i);
                    uah.setDia(dia);
                    uah.setAula(a);

                    if (i < plaEstudis.getHoraCanviFranja()) UAHmatins.add(uah);
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


    public static void modificarDades(String oldDia, String oldHora, String oldAula,
                                      String newDia, String newHora, String newAula) {
        
    }
}
