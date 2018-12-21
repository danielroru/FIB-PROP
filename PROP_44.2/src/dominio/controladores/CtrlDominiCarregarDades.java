package dominio.controladores;


import com.google.gson.Gson;
import dominio.classes.*;

public class CtrlDominiCarregarDades {

    private static PlaEstudis plaEstudis;

    public CtrlDominiCarregarDades(PlaEstudis pe) {
        plaEstudis = pe;
    }

    // Carreguem les dades de la Controladora de Persistencia

    // Funcionalitat Principal
    //////////////////////////

    public static void carregarDadesByFolder(String path) {
        carregarAules(path + "/aules.json");
        carregarAssignatures(path + "/assignatures.json");
        carregarPlaEstudis(path + "/plaEstudis.json");


        System.out.println("Dades carregades");


    }


    public static void carregarAules(String path) {

        Gson gson = new Gson();
        String json = CtrlPersistencia.llegirfitxer(path);

        ConjuntAules cjtAules = gson.fromJson(json, ConjuntAules.class);

        CtrlDomini.getPlaEstudis().setCjtAules(cjtAules);
    }



    public static void carregarAssignatures(String path) {

        Gson gson = new Gson();
        String json = CtrlPersistencia.llegirfitxer(path);

        ConjuntAssignatures cjtAssignatures = gson.fromJson(json, ConjuntAssignatures.class);

        CtrlDomini.getPlaEstudis().setCjtAssignatures(cjtAssignatures);
    }

    private class hores {
        public int horaInici = -1;
        public int horaFi = -1;
        public int horaCanviFranja = -1;
    }


    public static void carregarPlaEstudis(String path) {
        Gson gson = new Gson();
        String json = CtrlPersistencia.llegirfitxer(path);

        hores h = gson.fromJson(json, hores.class);

        CtrlDomini.getPlaEstudis().setHoraInici(h.horaInici);
        CtrlDomini.getPlaEstudis().setHoraFi(h.horaFi);
        CtrlDomini.getPlaEstudis().setHoraCanviFranja(h.horaCanviFranja);

    }

}
