package Dominio;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        PlaEstudis pe = new PlaEstudis();
        CapaDomini CD = new CapaDomini();
        CD.crearPlaEstudis();
        ConjuntAules conjuntAules = new ConjuntAules();
        boolean on = true;
        boolean escMenu = true;
        int accio;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Indica el valor de l'operació:");


        /////////////////////////////////////////////////////////////////////
        ///// Implementats: crearAssignatura
        ////////////////////////////////////////////////////////////////////
        escriureMenu();
        accio = scanner.nextInt();
        do {

            if (accio == 1) {
                boolean on_Gestio = true;
                escriureMenuGestioConfiguracio();
                do {
                    accio = scanner.nextInt();
                    if (accio == 1)
                        CD.configuracioAula(conjuntAules);
                    else if (accio == 2)
                        CD.configuracioNivell(scanner, pe);
                    else if (accio == 3)
                        CD.configuracioAssignatura(scanner, pe);
                    else if (accio == 4)
                        on_Gestio = false;
                    else {
                        System.out.println("Error: Indica una de les següents opcións");
                        escriureMenuGestioConfiguracio();
                    }
                } while (on_Gestio);
            } else if (accio == 2) {
                boolean on_Horari = true;
                escriureMenuGenerarHorari();
                do {
                    accio = scanner.nextInt();
                    if (accio == 1)
                        CD.crearHorari();
                    else if (accio == 2)
                        CD.llistarHorari();
                    else if (accio == 3)
                        CD.eliminarHorari();
                    else if (accio == 4)
                        on_Horari = false;
                    else {
                        System.out.println("Error: Indica una de les següents opcións");
                        escriureMenuGenerarHorari();
                    }
                } while (on_Horari);
            } else if (accio == 3) {
                boolean on_Configuracio = true;
                escriureMenuConfiguracio();
                do {
                    accio = scanner.nextInt();
                    if (accio == 1)
                        CD.hInihFi(scanner, pe);
                    else if (accio == 2)
                        CD.hCanviFranja(scanner, pe);
                    else if (accio == 3)
                        on_Configuracio = false;
                    else {
                        System.out.println("Error: Indica una de les següents opcións");
                        escriureMenuConfiguracio();
                    }

                } while (on_Configuracio);
            } else if (accio == 4) {
                on = false;
                escMenu = false;
            } else System.out.println("Error: Indica una de les següents opcións");
            if (escMenu) escriureMenu();
            if (on) accio = scanner.nextInt();
        } while (on);
    }


    // Nivell 1
    public static void escriureMenu() {
        System.out.println("1] Gestió Configuració");
        System.out.println("2] Generar Horari");
        System.out.println("3] Configuració");
        System.out.println("4] Sortir");
    }

    // Nivell 2 - [1] opció: Gestió Configuració
    public static  void escriureMenuGestioConfiguracio() {
        System.out.println("1] Configuració Aules");
        System.out.println("2] Configuració Nivells");
        System.out.println("3] Configuració Assignatures");
        System.out.println("4] Sortir");
    }

    // Nivell 3 - [1 - 1] opcionó: Menú Aules
    public static void escriureMenuAula() {
        System.out.println("1] Llistar Aules Disponibles");
        System.out.println("2] Crear Aules");
        System.out.println("3] Eliminar Aules  ");
        System.out.println("4] Sortir");
    }

    // Nivell 3 - [1 - 2] opció: Menú Nivells
    public static void escriureMenuNivell() {
        System.out.println("1] Llistar Nivells Disponibles");
        System.out.println("2] Crear Nivell");
        System.out.println("3] Eliminar Nivell");
        System.out.println("4] Sortir");
    }

    // Nivell 3 - [1 - 3] opció: Menú Assignatures
    public static void escriureMenuAssignatura() {
        System.out.println("1] Llistar Assignatures Disponibles");
        System.out.println("2] Crear Assignatures");
        System.out.println("3] Eliminar Assignatures");
        System.out.println("4] Sortir");
    }

    // Nivell 2 - [2] opció: Generar Horari
    public static  void escriureMenuGenerarHorari() {
        System.out.println("1] Crear Horari");
        System.out.println("2] Llistar Horari");
        System.out.println("3] Eliminar Horari");
        System.out.println("4] Sortir");
    }

    // Nivell 2 - [3] opció: Configuració
    public static  void escriureMenuConfiguracio() {
        System.out.println("1] Hora Inici / Hora Fi");
        System.out.println("2] Hora Canvi Franja");
        System.out.println("3] Sortir");
    }

    // Nivell 3 - [3 - 1] opció: Hora Inici / Hora Fi

    public static  void escriureMenuHoraIniciFi() {
        System.out.println("1] Ensenyar Hora [Inici - Fi]");
        System.out.println("2] Modificar Hora [Inici - Fi]");
        System.out.println("3] Sortir");
    }

    public static  void escriureMenuHoraCanviFranja() {
        System.out.println("1] Ensenyar Hora Cannvi Franja");
        System.out.println("2] Modificar Hora Cannvi Franja");
        System.out.println("3] Sortir");
    }
}