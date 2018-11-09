package Dominio;
import java.util.*;

public class CtrlDomini {

    private static HashSet<Sessio> sessionsTeoria;
    private static HashSet<Sessio> sessionsLaboratori;
    private static HashSet<Sessio> sessionsProblemes;

    public static void crearSessions(Set<Assignatura> cjtAssig) {

        sessionsTeoria = new HashSet<Sessio>();
        sessionsLaboratori = new HashSet<Sessio>();
        sessionsProblemes = new HashSet<Sessio>();


        for (Assignatura a : cjtAssig) {
            for(int i = 1; i <= a.getnGrupsT(); ++i) {
                Sessio sT = new Sessio();
                sT.setNomAssig(a.getNom());
                sT.setIdGrup(i * 10);
                sT.setDuracio(a.getnHoresT());
                sT.setTipus(Enumeracio.TipusSessio.TEORIA);
                sessionsTeoria.add(sT);
                for (int j = 1; j <= a.getnGrupsL(); ++j) {
                    Sessio sL = new Sessio();
                    sL.setNomAssig(a.getNom());
                    sL.setIdGrup(i * 10 + j);
                    sL.setDuracio(a.getnHoresL());
                    sL.setTipus(Enumeracio.TipusSessio.LABORATORI);
                    sessionsLaboratori.add(sL);
                }
                for (int j = 1; j <= a.getnGrupsP(); ++j) {
                    Sessio sP = new Sessio();
                    sP.setNomAssig(a.getNom());
                    sP.setIdGrup(i * 10 + j);
                    sP.setDuracio(a.getnHoresP());
                    sP.setTipus(Enumeracio.TipusSessio.PROBLEMES);
                    sessionsProblemes.add(sP);
                }
            }
        }
    }

}
