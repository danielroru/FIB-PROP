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

    public static Horari carregarHorari(String path) {

        Gson gson = new Gson();
        String json = ctrlPersistencia.llegirfitxer(path);

        return gson.fromJson(json, Horari.class);
    }

}
