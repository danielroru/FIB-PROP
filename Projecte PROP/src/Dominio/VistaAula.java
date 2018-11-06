package Dominio;

public class VistaAula {
    private inout io = new inout();

    public void mostrarMissatge(String missatge) {
        io.writeln(missatge);
    }
}
