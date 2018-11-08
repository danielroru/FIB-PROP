package Dominio;

import java.util.Vector;

public class VistaAula {

    private inout io = new inout();

    private static int numOpcionsMenu;
    private static int numOpcionsModificar;

    public static int getNumOpcionsMenu() {
        return numOpcionsMenu;
    }

    public static int getNumOpcionsModificar() {
        return numOpcionsModificar;
    }

    ////////////////////////////////////////////////////////////////////
    ///// CONSTRUCTORA
    ////////////////////////////////////////////////////////////////////

    public void VistaAula() {
        numOpcionsMenu = 0;
        numOpcionsModificar = 0;
    }

    ////////////////////////////////////////////////////////////////////
    ///// PRINT
    ////////////////////////////////////////////////////////////////////

    private void mostrarMenu() throws Exception {

        io.writeln("");

        mostrarMissatge("Menú Gestió Aules");

        io.writeln("    1] Llistar Aules Disponibles"); ++numOpcionsMenu;
        io.writeln("    2] Afegir Aula"); ++numOpcionsMenu;
        io.writeln("    3] Modificar Aula"); ++numOpcionsMenu;
        io.writeln("    4] Eliminar Aula"); ++numOpcionsMenu;
        io.writeln("    5] Enrere"); ++numOpcionsMenu;

        io.writeln("");

    }

    public void modificarAules(Vector<String> dades) throws Exception {
        int mida = dades.size();

        if (mida == 0) io.writeln("No hi ha cap aula al sistema");
        else {
            for (int i = 0; i < mida; i += 3) {
                io.writeln("");
                io.writeln("    1] Id:         " + dades.get(i)); ++numOpcionsModificar;
                io.writeln("    2] Capacitat:  " + dades.get(i + 1)); ++numOpcionsModificar;
                io.writeln("    3] Tipus:      " + dades.get(i + 2)); ++numOpcionsModificar;
            }
        }
    }

    public void llistarAules(Vector<String> dades) throws Exception {
        int mida = dades.size();

        if (mida == 0) io.writeln("No hi ha cap aula al sistema");
        else {
            for (int i = 0; i < mida; i += 3) {
                io.writeln("");
                io.writeln("    Id:         " + dades.get(i));
                io.writeln("    Capacitat:  " + dades.get(i + 1));
                io.writeln("    Tipus:      " + dades.get(i + 2));
            }
        }
    }

    public void mostrarMissatge(String missatge) throws Exception {
        io.writeln(missatge);
    }

    public void mostrarError(String missatge) throws Exception {
        io.writeln("");
        io.writeln("ERROR: " + missatge);
        io.writeln("");
    }


    ////////////////////////////////////////////////////////////////////
    ///// GETTERS
    ////////////////////////////////////////////////////////////////////

    public int getOpcioMenu() throws Exception {
        int valor = 0;
        while (valor < 1 || valor > numOpcionsMenu) {
            mostrarMenu();
            valor = io.readint();
        }

        return valor;
    }

    public int getOpcioModificar() throws Exception {
        int valor = 0;
        while (valor < 1 || valor > numOpcionsModificar) {
            valor = io.readint();
        }

        return valor;
    }

    public String getID() throws Exception {
        io.writeln("ID de l'aula:");
        return io.readname();
    }

    public int getCapacitat() throws Exception {
        io.writeln("Capacitat de l'aula:");
        int valor = 0;
        valor = io.readint();
        while (valor < 1) {
            io.writeln("El valor no és possible, prova'n un altre");
            valor = io.readint();
        }

        return valor;
    }

    public int getTipus() throws Exception {
        io.writeln("Tipus de l'aula:");
        io.writeln("    Laboratori  -> 0");
        io.writeln("    Teoria      -> 1");
        int valor = -1;
        valor = io.readint();
        while (valor < 0 && valor > 2) {
            io.writeln("El valor no és possible, prova'n un altre");
            valor = io.readint();
        }

        return valor;
    }
}
