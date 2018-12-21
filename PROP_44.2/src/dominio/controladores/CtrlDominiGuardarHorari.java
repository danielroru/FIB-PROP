package dominio.controladores;

import com.google.gson.Gson;
import dominio.classes.*;

import java.util.Map;


public class CtrlDominiGuardarHorari {


    private static PlaEstudis plaEstudis;

    public CtrlDominiGuardarHorari(PlaEstudis pe) {
        plaEstudis = pe;
    }


    public static void guardarHorari(PlaEstudis plaEstudis, String path) {
        try {
            //TODO
            // if (ultimHorari.getHorari().size() == 0) throw new Exception ("    ERROR: Encara no has generat cap horari");
            Gson gson = new Gson();


            String json = gson.toJson(plaEstudis);

            System.out.println("hola");

            CtrlPersistencia.guardarFitxer(json, path);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
