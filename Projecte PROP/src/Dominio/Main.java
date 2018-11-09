package Dominio;

import java.util.*;


public class Main {

    /////////////////////////////////////////////////////////////////
    /// GENERAR HORARI
    /////////////////////////////////////////////////////////////////

    private void menuGenerarHorari() {
        Scanner scanner = new Scanner(System.in);
        boolean on = true;
        int accio;

        while (on) {
            accio = scanner.nextInt();
            switch (accio) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    on = false;
                    break;
                default:
                    escriureError(1);
                    break;
            }
        }
    }

    private static void generarHorari () {

    }

    private static void mostrarHorari () {

    }


    private static void escriureMenuPrincipal() {
        System.out.println("");
        System.out.println("1] Gestió Configuració");
        System.out.println("2] Generar Horari");
        System.out.println("3] Gestió Pla d'Estudis");
        System.out.println("0] Sortir de l'aplicació");
    }

    private static void escriureError(int nError) {
        switch (nError){
            case 1:
                System.out.println("Error: Indica una de les opcions!");
                break;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int accio = -1;

        while (accio != 0) {
            System.out.println("Indica el valor de l'operació:");
            escriureMenuPrincipal();
            accio = scanner.nextInt();

            switch (accio) {
                case 1:
                    generarHorari();
                    break;
                case 2:
                    mostrarHorari();
                    break;
                default:
                    escriureError(1);
                    break;
            }
        }
    }
}
