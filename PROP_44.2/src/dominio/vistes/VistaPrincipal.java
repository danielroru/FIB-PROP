package dominio.vistes;

import dominio.controladores.CtrlPresentacio;

public class VistaPrincipal {

    private static VistaPrincipal instance = new VistaPrincipal();
    private static CtrlPresentacio cP = CtrlPresentacio.getInstance();
    private static inout io = new inout();

    private VistaPrincipal() {

    }

    public static VistaPrincipal getInstance() {
        return instance;
    }

    public static void menuPrincipal() {
        try {
            io.writeln("////////////////////////////");
            io.writeln("// MENÚ PRINCIPAL");
            io.writeln("////////////////////////////");
            io.writeln("");
            io.writeln("1] Carregar Set De Persistencia");
            io.writeln("2] Generar Horari");
            io.writeln("3] Guardar Horari");
            io.writeln("4] Carregar Horari");
            io.writeln("0] Sortir de l'aplicació");
        }
        catch (Exception e) {
            try {
                io.writeln("No s'ha pogut imprimir l'horari");
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    public static int readint() {
        int accio = -1;
        try {
            accio = io.readint();
        }
        catch (Exception e) {
            accio = 0;
            System.out.println("Error al seleccionar la opció");
        }
        return accio;
    }

    public static void writeln(String text) {
        //io.writeln(text);
    }

}
