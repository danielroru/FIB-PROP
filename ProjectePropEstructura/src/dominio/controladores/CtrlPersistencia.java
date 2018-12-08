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

    private CtrlPersistencia() {}

    public static CtrlPersistencia getInstance() {
        return instance;
    }


    // [ Opció 1 ] : Carregar Dades
    ////////////////////////////////

    public static String[][] carregarAules() {
        return ctrlPersistenciaCarregarDades.carregarAules();
    }

    public static String[][] carregarAssignatures() {
        return ctrlPersistenciaCarregarDades.carregarAssignatures();
    }

    public static String[] carregarPlaEstudis() {
        return ctrlPersistenciaCarregarDades.carregarPlaEstudis();
    }

    // [ Opció 3 ] : Guardar Horari
    ////////////////////////////////

    public static void guardarHorari(Map<String, Matriu> ultimHorari, String nomFitxer) {
        ctrlPersistenciaGuardarHorari.guardarHorari(ultimHorari, nomFitxer);
    }

}
