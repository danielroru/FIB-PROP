package dominio.controladores;

import com.google.gson.Gson;
import dominio.classes.*;

import java.util.Map;


public class CtrlDominiGuardarHorari {

    private static CtrlDominiGuardarHorari instance = new CtrlDominiGuardarHorari();
    private static CtrlPersistencia ctrlPersistencia = CtrlPersistencia.getInstance();


    private CtrlDominiGuardarHorari() {}

    public static CtrlDominiGuardarHorari getInstance() {
        return instance;
    }

    public void guardarHorari(Horari ultimHorari, String path) {
        try {
            if (ultimHorari.getHorari().size() == 0) throw new Exception ("    ERROR: Encara no has generat cap horari");
            Gson gson = new Gson();
            String a = gson.toJson(ultimHorari);
            ctrlPersistencia.guardarFitxer(a, path);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
