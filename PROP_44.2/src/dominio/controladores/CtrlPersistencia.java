package dominio.controladores;

// Repàs
import dominio.classes.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;

public class CtrlPersistencia {


    // [ Opció 3 ] : Guardar Horari
    ////////////////////////////////
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
                line = sCurrentLine;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return line;
    }

}
