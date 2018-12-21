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

        Path folder = Paths.get(path);
        if(!Files.exists(folder)) {
            try {
                Files.createDirectories(folder);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String json = CtrlPersistencia.llegirfitxer(path + "/assignatures.json");
        CtrlDomini.getPlaEstudis().setCjtAssignatures(gson.fromJson(json, ConjuntAssignatures.class));
        System.out.println("Assig carregades");

        json = CtrlPersistencia.llegirfitxer(path + "/aules.json");
        CtrlDomini.getPlaEstudis().setCjtAules(gson.fromJson(json, ConjuntAules.class));
        System.out.println("Aules carregades");

        Map<String, Matriu> instance = new HashMap<>();
        json = CtrlPersistencia.llegirfitxer(path + "/horari.json");
        CtrlDomini.getPlaEstudis().getUltimHorari().setHorari(gson.fromJson(json, instance.getClass()));
        System.out.println("Aules carregades");

    }

}
