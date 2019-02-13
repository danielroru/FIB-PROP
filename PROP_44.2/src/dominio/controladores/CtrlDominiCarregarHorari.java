package dominio.controladores;

import com.google.gson.Gson;
import dominio.classes.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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


    public static void carregarHorari(String path) {

        Gson gson = new Gson();


        String json = CtrlPersistencia.llegirfitxer(path + "/assignatures.json");
        CtrlDomini.getPlaEstudis().setCjtAssignatures(gson.fromJson(json, ConjuntAssignatures.class));
        System.out.println("Assig carregades");

        json = CtrlPersistencia.llegirfitxer(path + "/aules.json");
        CtrlDomini.getPlaEstudis().setCjtAules(gson.fromJson(json, ConjuntAules.class));
        System.out.println("Assig carregades");

        json = CtrlPersistencia.llegirfitxer(path + "/auxiliar.json");
        Auxiliar a = gson.fromJson(json, Auxiliar.class);
        CtrlDomini.getPlaEstudis().setHoraInici(a.getHoraInici());
        CtrlDomini.getPlaEstudis().setHoraFi(a.getHoraFi());
        CtrlDomini.getPlaEstudis().setHoraCanviFranja(a.getHoraFranja());
        CtrlDomini.getPlaEstudis().getUltimHorari().setHorari(a.getHorari());
        System.out.println("Auxiliar carregades");


    }

}
