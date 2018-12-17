package dominio.vistes;

import javafx.util.Pair;
import java.util.ArrayList;


public class VistaEscriureHorari {

    private static VistaEscriureHorari instance = new VistaEscriureHorari();

    private VistaEscriureHorari() {}

    public static VistaEscriureHorari getInstance() {
        return instance;
    }

    public static void imprimirHorari(ArrayList<Pair<String, String[][][]>> horari) {

        // Corregir
        // Posar llibreria io
        // Canviar 11 - 5 per variables

        // Ha d'escriure dies - Mirar de GIT HUB

        try {
            inout io = new inout();
            for (Pair<String, String[][][]> aula : horari) {
                io.writeln("");
                io.writeln("");
                io.writeln("---------------");
                io.writeln("Aula " + aula.getKey());
                io.writeln("---------------");
                io.writeln("");
                io.writeln("               DILLUNS        DIMARTS        DIMECRES        DIJOUS        DIVENDRES");
                String[][][] text = aula.getValue();
                for (int i = 0; i < 12; ++i) {
                    io.write(i + "h       ");
                    for (int j = 0; j < 5; ++j) {

                        if (text[j][i][0] == null)
                            io.write("    --------    ");
                        else
                            io.write("    "+text[j][j][0] + " " + text[j][i][1] + " " + text[j][i][2] + "    ");

                    }
                    io.writeln("");
                }
                System.out.println();
                System.out.println();
            }
        }
        catch (Exception e) {
            System.out.println(e);
            System.out.println("No s'ha pogut imprimir l'horari");
        }

    }

}
