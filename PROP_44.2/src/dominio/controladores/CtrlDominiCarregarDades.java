package dominio.controladores;


import com.google.gson.Gson;
import dominio.classes.*;

public class CtrlDominiCarregarDades {

    private static CtrlDominiCarregarDades instance = new CtrlDominiCarregarDades();
    private static CtrlPersistencia ctrlPersistencia = CtrlPersistencia.getInstance();

    private static PlaEstudis pE = PlaEstudis.getInstance();

    private CtrlDominiCarregarDades() {}

    public static CtrlDominiCarregarDades getInstance() {
        return instance;
    }



    // Carreguem les dades de la Controladora de Persistencia

    // Funcionalitat Principal
    //////////////////////////

    public static void carregarDadesByFolder(String path) {
        carregarAules(path + "/aules.json");
        carregarAssignatures(path + "/assignatures.json");
        carregarPlaEstudis(path + "/plaEstudis.json");

    }


    public static void carregarAules(String path) {

        Gson gson = new Gson();
        String json = ctrlPersistencia.llegirfitxer(path);

        ConjuntAules cjtAules = gson.fromJson(json, ConjuntAules.class);

        PlaEstudis.setCjtAules(cjtAules);
    }



    public static void carregarAssignatures(String path) {

        Gson gson = new Gson();
        String json = ctrlPersistencia.llegirfitxer(path);

        ConjuntAssignatures cjtAssignatures = gson.fromJson(json, ConjuntAssignatures.class);

        PlaEstudis.setCjtAssignatures(cjtAssignatures);
    }

    private class hores {
        public int horaInici = -1;
        public int horaFi = -1;
        public int horaCanviFranja = -1;
    }


    public static void carregarPlaEstudis(String path) {
        Gson gson = new Gson();
        String json = ctrlPersistencia.llegirfitxer(path);

        hores h = gson.fromJson(json, hores.class);

        PlaEstudis.setHoraInici(h.horaInici);
        PlaEstudis.setHoraFi(h.horaFi);
        PlaEstudis.setHoraCanviFranja(h.horaCanviFranja);

        System.out.println(PlaEstudis.getHoraInici());
        System.out.println(PlaEstudis.getHoraFi());
        System.out.println(PlaEstudis.getHoraCanviFranja());



    }

}
