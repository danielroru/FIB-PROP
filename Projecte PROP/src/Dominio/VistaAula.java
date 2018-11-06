package Dominio;

public class VistaAula {

    private inout io = new inout();
    private int numOpcions = 5;

    private void mostrarMenu() throws Exception {
        io.writeln("");

        String missatge = "Menú Gestió Aules";
        mostrarMissatge(missatge);

        io.writeln("    1] Llistar Aules Disponibles");
        io.writeln("    2] Afegir Aula");
        io.writeln("    3] Modificar Aula");
        io.writeln("    4] Eliminar Aula");
        io.writeln("    5] Enrere");

        io.writeln("");
        io.write("Valor: ");
    }

    public void mostrarMissatge(String missatge) throws Exception {
        io.writeln(missatge);
    }

    public void mostrarError(String missatge) throws Exception {
        io.writeln("");
        io.writeln("ERROR: " + missatge);
        io.writeln("");
    }

    public int obtenirOpcio() {
        int valor = 0;
        while (valor < 1 || valor > numOpcions) {
            mostrarMenu();
            valor = io.readint();
        }
        io.writeln("");
        return valor;
    }

    public String getID() throws Exception{
        io.write("ID de l'aula:");
        return io.readline();
    }

    public int getCapacitat() throws Exception{
        io.write("Capacitat de l'aula:");
        return io.readint();
    }

    public int getTipus() throws Exception{
        io.write("Tipus de l'aula:");
        io.write("    Teoria      -> 1");
        io.write("    Laboratori  -> 2");
        return io.readint();
    }
}
