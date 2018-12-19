package dominio.controladores;

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

    public static Map<String, Matriu> carregarHorari(Horari ultimHorari, String text) {
        Map<String, Matriu> horari = new HashMap<>();
        try {
            if (PlaEstudis.isNull()) throw new Exception ("    ERROR: Encara no has carregat les dades de persistència");
            horari = ctrlPersistencia.llegirHorari(text);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return horari;
    }

}
