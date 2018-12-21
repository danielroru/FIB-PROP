package dominio.controladores;

import com.google.gson.Gson;
import dominio.classes.*;

import java.util.HashMap;
import java.util.Map;

public class CtrlDominiCarregarHorari {

    private static CtrlDominiCarregarHorari instance = new CtrlDominiCarregarHorari();
    private static CtrlPersistencia ctrlPersistencia = CtrlPersistencia.getInstance();

    private CtrlDominiCarregarHorari() {}

    public static CtrlDominiCarregarHorari getInstance() {
        return instance;
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
        String json = ctrlPersistencia.llegirfitxer(path);

        Pestudis pe = gson.fromJson(json, Pestudis.class);

        PlaEstudis.setCjtAssignatures(pe.cjtAssignatures);
        PlaEstudis.setCjtAules(pe.cjtAules);
        PlaEstudis.setHoraInici(pe.horaInici);
        PlaEstudis.setHoraFi(pe.horaFi);
        PlaEstudis.setHoraCanviFranja(pe.horaCanviFranja);
        CtrlDomini.setUltimHorari(pe.horari);

        return pe.horari;

    }

}
