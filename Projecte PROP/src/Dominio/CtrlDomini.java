package Dominio;

import java.util.*;

public class CtrlDomini {



    private static HashSet<Sessio> sessions;

    private static HashSet<UAH> UAHmatins = new HashSet<>();
    private static HashSet<UAH> UAHtardes = new HashSet<>();
    private static HashSet<UAH> UAHteoria = new HashSet<>();
    private static HashSet<UAH> UAHlaboratori = new HashSet<>();

    private static Horari ultimHorari = new Horari();

    public static void reset() {
        UAHmatins = new HashSet<>();
        UAHtardes = new HashSet<>();
        UAHteoria = new HashSet<>();
        UAHlaboratori = new HashSet<>();
    }

    public static void generarHorari() throws Exception {
        reset();
        crearUAHs();
        crearSessions();
        Horari solucio = GeneradorHorari.generarHorari();
        ultimHorari = solucio;
        List<UAH> sol = solucio.ordena();
        imprimirHorari(sol);
    }

    public static void imprimirHorari(List<UAH> solucio) throws Exception {
        inout io = new inout();
        for (Aula a : PlaEstudis.getConjuntAules().getAules()) {
            io.writeln("");
            io.writeln("");
            io.writeln("---------------");
            io.writeln("Aula " + a.getId());
            io.writeln("---------------");
            io.writeln("");

            io.write("               ");
            for (Enumeracio.Dia dia : Enumeracio.Dia.values()) {
                io.write(dia.toString());
                for (int i = dia.toString().length(); i < 15; i++) {
                    io.write(" ");
                }
            }
            io.writeln("");
            for (int hora = PlaEstudis.getHoraInici(); hora < PlaEstudis.getHoraFi(); hora++) {
                io.write(hora + "h");
                int xifres = hora / 10 == 0 ? 1 : 2;
                for (int j = xifres+1; j < 15; j++) {
                    io.write(" ");
                }
                for (Enumeracio.Dia dia : Enumeracio.Dia.values()) {
                    for (UAH uah : solucio) {
                        if (uah.getHora() == hora && uah.getDia().equals(dia) && uah.getAula().equals(a)) {
                            String result = null;
                            String result2 = null;
                            String sigla = null;
                            switch (uah.getSessio().getTipus()) {
                                case TEORIA:
                                    sigla = "T";
                                    break;
                                case LABORATORI:
                                    sigla = "L";
                                    break;
                                case PROBLEMES:
                                    sigla = "P";
                                    break;
                            }
                            result = "[" + uah.getSessio().getAssignatura().getNom() + "]";
                            io.write(result);
                            int  k = 0;
                            for (k = result.length(); k < 8; k++) {
                                io.write(" ");
                            }
                            result2 = uah.getSessio().getIdGrup() + " " + sigla;
                            io.write(result2);
                            for (int j = k+result2.length(); j < 15; j++) {
                                io.write(" ");
                            }
                        }

                    }

                }
                io.writeln("");
            }
        }

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
                sT.setDuracio(a.getnHoresT());
                sT.setTipus(Enumeracio.TipusSessio.TEORIA);
                sessions.add(sT);

                for (int j = 1; j <= a.getnGrupsL(); ++j) {
                    Sessio sL = new Sessio();
                    sL.setAssignatura(a);
                    sL.setIdGrup(i * 10 + j);
                    sL.setDuracio(a.getnHoresL());
                    sL.setTipus(Enumeracio.TipusSessio.LABORATORI);
                    sessions.add(sL);
                }

                for (int j = 1; j <= a.getnGrupsP(); ++j) {
                    Sessio sP = new Sessio();
                    sP.setAssignatura(a);
                    sP.setIdGrup(i * 10 + j);
                    sP.setDuracio(a.getnHoresP());
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

    public static void setSessions(HashSet<Sessio> sessions) {
        CtrlDomini.sessions = sessions;
    }
}
