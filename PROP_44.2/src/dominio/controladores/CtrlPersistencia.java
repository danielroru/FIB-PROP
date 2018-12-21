package dominio.controladores;

// Repàs
import dominio.classes.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class CtrlPersistencia {

    private static CtrlPersistencia instance = new CtrlPersistencia();

    private static CtrlDomini ctrlDomini = CtrlDomini.getInstance();

    private static CtrlPersistenciaGuardarHorari ctrlPersistenciaGuardarHorari =
            CtrlPersistenciaGuardarHorari.getInstance();
    private static CtrlPersistenciaCarregarHorari ctrlPersistenciaCarregarHorari =
            CtrlPersistenciaCarregarHorari.getInstance();

    private CtrlPersistencia() {}

    public static CtrlPersistencia getInstance() {
        return instance;
    }



    // [ Opció 3 ] : Guardar Horari
    ////////////////////////////////
    //TODO
    public static void guardarFitxer(Map<String, Matriu> ultimHorari, String nomFitxer) {
    }

    public static String llegirfitxer(String path) {
        String line = new String();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
                line = sCurrentLine;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return line;
    }

}
