package dominio.controladores;

// Repàs
import dominio.classes.*;

import java.util.Map;

public class CtrlPersistencia {

    private static CtrlPersistencia instance = new CtrlPersistencia();

    private static CtrlDomini ctrlDomini = CtrlDomini.getInstance();
    private static CtrlPersistenciaCarregarDades ctrlPersistenciaCarregarDades =
            CtrlPersistenciaCarregarDades.getInstance();
    private static CtrlPersistenciaGuardarHorari ctrlPersistenciaGuardarHorari =
            CtrlPersistenciaGuardarHorari.getInstance();
    private static CtrlPersistenciaCarregarHorari ctrlPersistenciaCarregarHorari =
            CtrlPersistenciaCarregarHorari.getInstance();

    private CtrlPersistencia() {}

    public static CtrlPersistencia getInstance() {
        return instance;
    }


    // [ Opció 1 ] : Carregar Dades
    ////////////////////////////////

    public static String[][] carregarAules(String fitxer) {
        return ctrlPersistenciaCarregarDades.carregarAules(fitxer);
    }

    public static String[][] carregarAssignatures(String fitxer) {
        return ctrlPersistenciaCarregarDades.carregarAssignatures(fitxer);
    }

    public static String[] carregarPlaEstudis(String fitxer) {
        return ctrlPersistenciaCarregarDades.carregarPlaEstudis(fitxer);
    }

    // [ Opció 3 ] : Guardar Horari
    ////////////////////////////////

    public static void guardarHorari(Map<String, Matriu> ultimHorari, String nomFitxer) {
        ctrlPersistenciaGuardarHorari.guardarHorari(ultimHorari, nomFitxer);
    }

    // [ Opció 4 ] : Carregar Horari
    ////////////////////////////////

    public static Map<String, Matriu> llegirHorari(String path) {
        Map<String, Matriu> horari = CtrlPersistenciaCarregarHorari.llegirHorari(path);
        return horari;
    }

}
