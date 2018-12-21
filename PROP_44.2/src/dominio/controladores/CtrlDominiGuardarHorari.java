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

    private class Pestudis {
        public int horaInici;
        public int horaFi;
        public int horaCanviFranja;
        public ConjuntAules cjtAules;
        public ConjuntAssignatures cjtAssignatures;
        public Horari horari;
    }

    public void guardarHorari(PlaEstudis plaEstudis, String path) {
        try {
            //TODO
            // if (ultimHorari.getHorari().size() == 0) throw new Exception ("    ERROR: Encara no has generat cap horari");
            Gson gson = new Gson();

            Pestudis pe = new Pestudis();
            pe.horaInici = PlaEstudis.getHoraInici();
            pe.horaFi = PlaEstudis.getHoraFi();
            pe.horaCanviFranja = PlaEstudis.getHoraCanviFranja();
            pe.cjtAules = PlaEstudis.getConjuntAules();
            pe.cjtAssignatures = PlaEstudis.getConjuntAssignatures();
            pe.horari = CtrlDomini.getUltimHorari();

            String json = gson.toJson(pe);

            System.out.println("hola");

            ctrlPersistencia.guardarFitxer(json, path);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
