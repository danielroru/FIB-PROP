package dominio.controladores;

import com.google.gson.Gson;
import dominio.classes.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class CtrlDominiGuardarHorari {


    private static PlaEstudis plaEstudis;

    public CtrlDominiGuardarHorari() {

    }

    public static void guardarHorari(String path) {
        try {
            //TODO
            // if (ultimHorari.getHorari().size() == 0) throw new Exception ("    ERROR: Encara no has generat cap horari");
            Gson gson = new Gson();

            Path folder = Paths.get(path);
            if(!Files.exists(folder)) {
                try {
                    Files.createDirectories(folder);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            ConjuntAssignatures assig = CtrlDomini.getPlaEstudis().getConjuntAssignatures();
            String json = gson.toJson(assig);
            CtrlPersistencia.guardarFitxer(json, path + "/assignatures.json");
            System.out.println("Assig guardades");

            ConjuntAules aules = CtrlDomini.getPlaEstudis().getConjuntAules();
            json = gson.toJson(aules);
            CtrlPersistencia.guardarFitxer(json, path + "/aules.json");
            System.out.println("Aules guardades");



            Auxiliar a = new Auxiliar();
            a.setHorari(CtrlDomini.getPlaEstudis().getUltimHorari().getHorari());
            a.setHoraInici(CtrlDomini.getPlaEstudis().getHoraInici());
            a.setHoraFi(CtrlDomini.getPlaEstudis().getHoraFi());
            a.setHoraFranja(CtrlDomini.getPlaEstudis().getHoraCanviFranja());
            json = gson.toJson(a);
            CtrlPersistencia.guardarFitxer(json, path + "/auxiliar.json");
            System.out.println("Horari guardat");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
