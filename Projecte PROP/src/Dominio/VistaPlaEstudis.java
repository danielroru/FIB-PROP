// Marc Casellas

package Dominio;

import java.util.Vector;

public class VistaPlaEstudis {

    private inout io = new inout();

    private int numOpcionsMenu = 3;

    public void mostrarMissatge(String missatge) throws Exception {
        io.writeln(missatge);
    }

    public void mostrarError(String missatge) throws Exception {
        io.writeln("");
        io.writeln("ERROR: " + missatge);
        io.writeln("");
    }

    private void mostrarMenu() throws Exception {

        io.writeln("");

        mostrarMissatge("Menú Gestió Pla d'Estudis");

        io.writeln("    1] Finestra horaria [Inici - Fi]");
        io.writeln("    2] Canvi de franja");
        io.writeln("    3] Enrere");

        io.writeln("");

    }


    public int getOpcioMenu() throws Exception {
        int valor = 0;
        while (valor < 1 || valor > numOpcionsMenu) {
            mostrarMenu();
            valor = io.readint();
        }

        return valor;
    }

    public void mostrarHores(Vector<int> dades) throws Exception {
        int mida = dades.size();

        if (mida == 0) io.writeln("Encara no s'han establit les hores");
        else {
            for (int i = 0; i < mida; i += 3) {
                io.writeln("");
                io.writeln("    Hora inici classes:     " + dades.get(i));
                io.writeln("    Hora fi classes:        " + dades.get(i + 1));
                io.writeln("    Hora canvi de franja:   " + dades.get(i + 2));
            }
        }
    }
}
