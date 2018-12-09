package dominio.vistes;

public class VistaEscriureHorari {

    private static VistaEscriureHorari instance = new VistaEscriureHorari();

    private VistaEscriureHorari() {}

    public static VistaEscriureHorari getInstance() {
        return instance;
    }

    public static void imprimirHorari(String[] horari) {
        for (String h : horari) {
            System.out.println(h);
        }
        System.out.println();
        System.out.println();
    }

}
