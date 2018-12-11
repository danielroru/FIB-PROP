package dominio.controladores;

import dominio.classes.*;

import java.util.*;

public class CtrlDomini {

    private static HashSet<Sessio> sessions;

    private static HashSet<UAH> UAHmatins = new HashSet<>();
    private static HashSet<UAH> UAHtardes = new HashSet<>();
    private static HashSet<UAH> UAHteoria = new HashSet<>();
    private static HashSet<UAH> UAHlaboratori = new HashSet<>();

    private static Horari ultimHorari = new Horari();

    private static CtrPersistencia ctrPersistencia;

    public void inicialitzar() {
        ctrPersistencia = new CtrPersistencia();
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

    public static void generarHorari(){
        reset();
        crearUAHs();
        crearSessions();
        ultimHorari = GeneradorHorari.generarHorari();
        ultimHorari.mapejaHorari();
        ultimHorari.imprimirHorari();
    }

    public static void guardarHorari() {
        try {
            if (!existeixUltimHorari()) throw new Exception ("    ERROR: Encara no has generat cap horari");
            inout io = new inout();

            io.write("Quin nom li vols posar?");
            String path = io.readline();

            ultimHorari.guardarHorari(path);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void llegirHorari() {
        try {
            if (PlaEstudis.isNull()) throw new Exception ("    ERROR: Encara no has carregat les dades de persistència");
            inout io = new inout();

            io.write("Quin fitxer vols carregar?");
            String path = io.readline();

            ultimHorari.llegirHorari(path);
            ultimHorari.imprimirHorari();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void carregarSetAssignatures(String path) {
        ctrPersistencia.carregarAssignatures(path);
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

        for (Assignatura a : PlaEstudis.getConjuntAssignatures().getAssignatures()) {
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

        for (Aula a : PlaEstudis.getConjuntAules().getAules()) {
            for (Enumeracio.Dia dia : Enumeracio.Dia.values()) {
                for (int i = PlaEstudis.getHoraInici(); i < PlaEstudis.getHoraFi(); i++) {
                    UAH uah = new UAH();

                    uah.setHora(i);
                    uah.setDia(dia);
                    uah.setAula(a);

                    if (i < PlaEstudis.getHoraCanviFranja()) UAHmatins.add(uah);
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
}
