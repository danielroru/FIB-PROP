package dominio.controladores;

// Repàs
import dominio.classes.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;

public class CtrlPersistencia {

    private static CtrlPersistencia instance = new CtrlPersistencia();

    private static CtrlDomini ctrlDomini = CtrlDomini.getInstance();




    private CtrlPersistencia() {}

    public static CtrlPersistencia getInstance() {
        return instance;
    }



    // [ Opció 3 ] : Guardar Horari
    ////////////////////////////////
    //TODO
    public static void guardarFitxer(String json, String path) {
        System.out.println(path);
        try (BufferedWriter br = new BufferedWriter(new FileWriter(path))) {
            br.write(json);

        } catch (IOException e) {
            e.printStackTrace();
        }
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
