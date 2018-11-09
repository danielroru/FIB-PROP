package Dominio;
import java.util.*;

public class CtrlDomini {

    public Set<Sessio> transfAssigSessio(ConjuntAssignatures cjtAssig) {
        Set<Assignatura> cjtAssignatures = new HashSet<>();
        Set<Sessio> cjtSessio = new HashSet<>();
        cjtAssignatures = cjtAssig.getConjuntAssignatures();
        int i = 1;
        for (Assignatura a : cjtAssignatures) {
            Sessio sT = new Sessio();
            sT.setNomAssig(a.getNom());
            sT.setIdGrup(i*10);
            sT.setDuracio(a.getnHoresT());
            cjtSessio.add(sT);
            for(int j = 1; j <= a.getnGrupsL(); ++j) {
                Sessio sL = new Sessio();
                sL.setNomAssig(a.getNom());
                sL.setIdGrup(i*10+j);
                sL.setDuracio(a.getnHoresT());
                cjtSessio.add(sL);
            }
            for(int j = 1; j <= a.getnGrupsL(); ++j) {
                Sessio sP = new Sessio();
                sP.setNomAssig(a.getNom());
                sP.setIdGrup(i*10+j);
                sP.setDuracio(a.getnHoresT());
                cjtSessio.add(sP);
            }
            ++i;
        }
        return cjtSessio;
    }

}
