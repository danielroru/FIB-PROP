package Dominio;

public class VistaGeneral {
    private inout io = new inout();

    private int numOpcionsMenu = 4;

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

        mostrarMissatge("Menú Principal");

        io.writeln("1] Gestió Configuració");
        io.writeln("2] Generar Horari");
        io.writeln("3] Gestió Pla d'Estudis");
        io.writeln("4] Sortir de l'aplicació");

        io.writeln("");

    }

    private void mostrarMenuConfiguracio() throws Exception {

        io.writeln("");

        mostrarMissatge("Menú Configuració");

        io.writeln("1] Configuració Aules");
        io.writeln("2] Configuració Assignatures");
        io.writeln("3] Enrere");

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

    public int getOpcioAula() throws Exception {
        int valor = 0;
        while (valor < 1 || valor > numOpcionsMenu) {
            mostrarMenuConfiguracio();
            valor = io.readint();
        }

        return valor;
    }
}
