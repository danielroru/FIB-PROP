package Dominio;
import java.util.*;

public class CtrlDomini {

    public Set<Sessio> transfAssigSessio(ConjuntAssignatures cjtAssig) {
        Set<Sessio> cjtSessio = new HashSet<>();
        for (Assignatura a : cjtAssig.getConjuntAssignatures()) {
            for(int i = 1; i <= a.getnGrupsT(); ++i) {
                Sessio sT = new Sessio();
                sT.setNomAssig(a.getNom());
                sT.setIdGrup(i * 10);
                sT.setDuracio(a.getnHoresT());
                sT.setTipus(Enumeracio.TipusSessio.TEORIA);
                cjtSessio.add(sT);
                for (int j = 1; j <= a.getnGrupsL(); ++j) {
                    Sessio sL = new Sessio();
                    sL.setNomAssig(a.getNom());
                    sL.setIdGrup(i * 10 + j);
                    sL.setDuracio(a.getnHoresL());
                    sL.setTipus(Enumeracio.TipusSessio.LABORATORI);
                    cjtSessio.add(sL);
                }
                for (int j = 1; j <= a.getnGrupsP(); ++j) {
                    Sessio sP = new Sessio();
                    sP.setNomAssig(a.getNom());
                    sP.setIdGrup(i * 10 + j);
                    sP.setDuracio(a.getnHoresP());
                    sP.setTipus(Enumeracio.TipusSessio.PROBLEMES);
                    cjtSessio.add(sP);
                }
            }
        }
        return cjtSessio;
    }

}
