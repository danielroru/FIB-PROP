package dominio.controladores;

import com.google.gson.Gson;
import dominio.classes.*;

import java.util.HashMap;
import java.util.Map;

public class CtrlDominiCarregarHorari {

    private static PlaEstudis plaEstudis;

    public CtrlDominiCarregarHorari(PlaEstudis pe) {
        plaEstudis = pe;
    }

    private class Pestudis {
        public int horaInici;
        public int horaFi;
        public int horaCanviFranja;
        public ConjuntAules cjtAules;
        public ConjuntAssignatures cjtAssignatures;
        public Horari horari;
    }


    public static Horari carregarHorari(String path) {

        Gson gson = new Gson();
        String json = CtrlPersistencia.llegirfitxer(path);

        Pestudis pe = gson.fromJson(json, Pestudis.class);

        plaEstudis.setCjtAssignatures(pe.cjtAssignatures);
        plaEstudis.setCjtAules(pe.cjtAules);
        plaEstudis.setHoraInici(pe.horaInici);
        plaEstudis.setHoraFi(pe.horaFi);
        plaEstudis.setHoraCanviFranja(pe.horaCanviFranja);
        CtrlDomini.getPlaEstudis().setUltimHorari(pe.horari);

        return pe.horari;

    }

}
