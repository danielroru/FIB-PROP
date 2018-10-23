package Dominio;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        PlaEstudis pe = Utils.crearPlaEstudis();
        boolean on = true;
        int accio;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Indica el valor de l'operació:");
        Utils.escriureMenu();

        /////////////////////////////////////////////////////////////////////
        ///// Implementats: crearAssignatura
        ////////////////////////////////////////////////////////////////////
        do {
            accio = scanner.nextInt();
            if (accio == 1) pe.crearAula();
            if (accio == 2) pe.crearNivell();
            if (accio == 3) pe.eliminarAula();
            if (accio == 4) pe.eliminarNivell();
            if (accio == 5) pe.crearAssignatura();
            if (accio == 6) on = false;
        } while (on);

    }
}
