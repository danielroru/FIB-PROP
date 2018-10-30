package Dominio;

import java.util.Scanner;

public class GeneradorHorari {

    public void generarHorari() {
        PlaEstudis pe = crearPlaEstudis();
        boolean on = true;
        boolean escMenu = true;
        int accio;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Indica el valor de l'operació:");
        escriureMenu();

        /////////////////////////////////////////////////////////////////////
        ///// Implementats: crearAssignatura
        ////////////////////////////////////////////////////////////////////

        accio = scanner.nextInt();
        do {
            if (accio == 1) {
                boolean on_Gestio = true;
                escriureMenuGestioConfiguracio();
                do {
                    accio = scanner.nextInt();
                    if (accio == 1)
                        configuracioAula(scanner, pe);
                    else if (accio == 2)
                        configuracioNivell(scanner, pe);
                    else if (accio == 3)
                        configuracioAssignatura(scanner, pe);
                    else if (accio == 4)
                        on_Gestio = false;
                    else {
                        System.out.println("Error: Indica una de les següents opcións");
                        escriureMenuGestioConfiguracio();
                    }
                }while(on_Gestio);
            }
            else if (accio == 2) {
                boolean on_Horari = true;
                escriureMenuGenerarHorari();
                do {
                    accio = scanner.nextInt();
                    if(accio == 1)
                        crearHorari();
                    else if(accio == 2)
                        llistarHorari();
                    else if(accio == 3)
                        eliminarHorari();
                    else if (accio == 4)
                        on_Horari = false;
                    else {
                        System.out.println("Error: Indica una de les següents opcións");
                        escriureMenuGenerarHorari();
                    }
                }while(on_Horari);
            }
            else if (accio == 3) {
                boolean on_Configuracio = true;
                escriureMenuConfiguracio();
                do {
                    accio = scanner.nextInt();
                    if(accio == 1)
                        hInihFi (scanner, pe);
                    else if(accio == 2)
                        hCanviFranja(scanner, pe);
                    else if (accio == 3)
                        on_Configuracio = false;
                    else {
                        System.out.println("Error: Indica una de les següents opcións");
                        escriureMenuConfiguracio();
                    }

                }while(on_Configuracio);
            }
            else if (accio == 4) {
                on = false;
                escMenu = false;
            }
            else System.out.println("Error: Indica una de les següents opcións");
            if (escMenu) escriureMenu();
            if (on) accio = scanner.nextInt();
        } while (on);
    }

    //Scanner scanner = new Scanner(System.in);

    /*////////////////////////////////////////////////////////////////////////////*/

    /* --------------------- */
    /*      CODI MENÚ:       */
    /* --------------------- */

    /*      - Opcions        */

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

    // Nivell 3 - [3 - 2] opció: Hora Canvi Franja

    /*////////////////////////////////////////////////////////////////////////////*/
    /*////////////////////////////////////////////////////////////////////////////*/

    /* --------------------- */
    /*   - Funcionalitat:    */
    /* --------------------- */

    //  -> Scanner i Pla Estudis es pot passar per valor ¿?

    /*////////////////////////////////////////////////////////////////////////////*/
    /* ............................. */
    // Nivell 1: GESTIÓ CONFIGURACIÓ
    /* ............................. */

    /*  +  [1 - 1] Configuració Aules    */
    public static void configuracioAula(Scanner scanner, PlaEstudis pe) {
        int accio;
        boolean on_Aula = true;
        escriureMenuAula();
        do {
            accio = scanner.nextInt();
            if (accio == 1) pe.llistarAula();
            else if (accio == 2) pe.crearAula();
            else if (accio == 3) pe.eliminarAula();
            else if (accio == 4) on_Aula = false;
            else {
                System.out.println("Error: Indica una de les següents opcións");
                escriureMenuAula();
            }
        } while (on_Aula);
        escriureMenuGestioConfiguracio();
    }

    /*  +  [1 - 2] Configuració Nivells    */
    public static void configuracioNivell(Scanner scanner, PlaEstudis pe) {
        int accio;
        boolean on_Nivell = true;
        escriureMenuNivell();
        do {
            accio = scanner.nextInt();
            if (accio == 1) {
                int nNivell =pe.getNNivell();
                System.out.println(nNivell);
            }
            else if (accio == 2) pe.crearNivell();
            else if (accio == 3) pe.eliminarNivell();
            else if (accio == 4) on_Nivell = false;
            else {
                System.out.println("Error: Indica una de les següents opcións");
                escriureMenuNivell();
            }
        } while (on_Nivell);
        escriureMenuGestioConfiguracio();
    }

    /*  +  [1 - 3] Configuració Assignatures */
    public static void configuracioAssignatura(Scanner scanner, PlaEstudis pe) {
        int accio;
        boolean on_Assignatura = true;
        escriureMenuAssignatura();
        do {
            accio = scanner.nextInt();
            if (accio == 1) {
                System.out.println("No està implementat");
            }
            else if (accio == 2) {
                System.out.println("No està implementat");
            }
            else if (accio == 3) {
                System.out.println("No està implementat");
            }
            else if (accio == 4) on_Assignatura = false;
            else {
                System.out.println("Error: Indica una de les següents opcións");
                escriureMenuAssignatura();
            }
        } while (on_Assignatura);
        escriureMenuGestioConfiguracio();
    }

    /*////////////////////////////////////////////////////////////////////////////*/

    /* ............................. */
    // Nivell 2: GENERAR HORARI
    /* ............................. */

    /*  + [2 - 1] Crear Horari */

    public static void crearHorari() {
        System.out.println("Aplicar Algoritme Generador Horari");
    }

    /*  + [2 - 2] Llistar Horari */

    public static void llistarHorari() {
        System.out.println("Llista Tots Els Horaris");
    }

    /*  + [2 - 3] Eliminar Horari */

    public static  void eliminarHorari() {
        System.out.println("Elimina Horari Seleccionat");
    }

    /*////////////////////////////////////////////////////////////////////////////*/

    /* ............................. */
    // Nivell 3: CONFIGURACIÓ
    /* ............................. */

    public static void hInihFi (Scanner scanner, PlaEstudis pe) {
        int accio;
        boolean on_hIniFi = true;
        escriureMenuHoraIniciFi();
        do {
            accio = scanner.nextInt();
            if (accio == 1) {
                int HoraInici = pe.getHoraInici();
                int HoraFi = pe.getHoraFi();
                System.out.println("Hora Inici: "+HoraInici);
                System.out.println("Hora Fi: "+HoraFi);
            }
            else if (accio == 2) {
                System.out.println("Hora Inici: ");
                int horaCanviFranja = pe.getHoraCanviFranja();
                int horaInici = scanner.nextInt();
                while (horaInici <  0 || horaCanviFranja <= horaInici)  {
                    if (horaInici <  0) System.out.println("L'hora de inici ha de ser igual o major a 0");
                    else {
                        System.out.println("L'hora de inici ha de ser més petit el canvi de franja");
                        System.out.println("El canvi de franja actualment és "+horaCanviFranja);
                    }

                    System.out.println("Torna escriure un altre valor");
                    horaInici = scanner.nextInt();
                }
                System.out.println("Hora Fi: ");
                int horaFi = scanner.nextInt();
                while ((horaFi - horaInici) <= 1 || horaFi <= horaCanviFranja) {
                    if ((horaFi - horaInici) <= 1) {
                        System.out.println("Escriu una hora de fi més gran que" +
                                " l'hora d'inici i pugui contenir l'hora de canvi de " +
                                "franja");
                    }
                    else {
                        System.out.println("L'hora de fi ha de ser més gran el canvi de franja");
                        System.out.println("El canvi de franja actualment és "+horaCanviFranja);
                    }
                    System.out.println("Torna escriure un altre valor");
                    horaFi = scanner.nextInt();
                }
                pe.setHoraInici(horaInici);
                pe.setHoraFi(horaFi);
            }
            else if (accio == 3) on_hIniFi = false;
            else {
                System.out.println("Error: Indica una de les següents opcións");
                escriureMenuHoraIniciFi();
            }
        } while (on_hIniFi);
        escriureMenuConfiguracio();
    }

    public static void hCanviFranja (Scanner scanner, PlaEstudis pe) {
        int accio;
        boolean on_hCanviFranja = true;
        escriureMenuHoraCanviFranja();
        do {
            accio = scanner.nextInt();
            if (accio == 1) {
                int HoraCanviFranja = pe.getHoraCanviFranja();
                System.out.println("Hora Canvi Franja: "+HoraCanviFranja);
            }
            else if (accio == 2) {
                System.out.println("Modifica Canvi De Franja: ");
                int canviFranja = scanner.nextInt();
                if (pe.getHoraInici() < canviFranja
                    && pe.getHoraFi() > canviFranja) {
                    pe.setHoraCanviFranja(canviFranja);
                    System.out.println("S'ha modificat correctement");
                }
                else {
                    System.out.println("No s'ha modificat correctement");
                    System.out.println("El valor nou ha de ser més gran que " +
                            "l'hora d'inici i més petit que l'hora de fi");
                }
            }
            else if (accio == 3) on_hCanviFranja = false;
            else {
                System.out.println("Error: Indica una de les següents opcións");
                escriureMenuHoraCanviFranja();
            }
        } while (on_hCanviFranja);
        escriureMenuConfiguracio();
    }

    //////////////////////////////////////////////////////////////////////////////////////////////
    public static PlaEstudis crearPlaEstudis() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hora d'inici de les classes");
        int horaInici = scanner.nextInt();
        while (horaInici <  0)  {
            System.out.println("L'hora de inici ha de ser igual o major a 0");
            System.out.println("Torna escriure un altre valor");
            horaInici = scanner.nextInt();
        }
        System.out.println("Hora de fi de les classes");
        int horaFi = scanner.nextInt();
        while ((horaFi - horaInici) <= 1) {
            System.out.println("Escriu una hora de fi més gran que" +
                    " l'hora d'inici i pugui contenir l'hora de canvi de " +
                    "franja");
            System.out.println("Torna escriure un altre valor");
            horaFi = scanner.nextInt();
        }
        System.out.println("Hora de canvi d'horari matí/tarda");
        boolean correcte = false;
        int horaCanviFranja = -1;
        while (!correcte) {
            int hora = scanner.nextInt();
            if (hora <= horaInici || hora >= horaFi) {
                System.out.println("L'hora de canvi de franges ha d'estar entre l'hora d'inici i la de fi de classes");
                System.out.println("Hora de canvi d'horari matí/tarda");
            } else {
                correcte = true;
                horaCanviFranja = hora;
            }
        }

        System.out.println("Nombre de nivells");
        int nNivell = scanner.nextInt();

        System.out.println("Nombre d'aules");
        int nAula = scanner.nextInt();

        PlaEstudis pe = new PlaEstudis(horaInici, horaFi, horaCanviFranja, nNivell, nAula);

        System.out.println("S'ha creat el pla d'estudis\n");

        return pe;
    }

    public static Assignatura crearAssignatura(PlaEstudis pe) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduir dades");

        System.out.println("Nom d'assignatura:");
        String nom = scanner.nextLine();

        boolean correcte = false;
        int nivell = 0;
        while (!correcte) {
            System.out.println("Nivell:");
            nivell = scanner.nextInt();
            if (nivell > 0 && nivell < pe.getNNivell()) {
                correcte = true;
            } else
                System.out.println("El nivell de l'assignatura ha d'estar entre el rang del pla d'estudis");
        }

        System.out.println("Número d'hores de teoria:");
        int nHoresT = scanner.nextInt();

        System.out.println("Número d'hores de laboratori:");
        int nHoresL = scanner.nextInt();

        System.out.println("Número d'hores de problemes:");
        int nHoresP = scanner.nextInt();

        System.out.println("Número de grups de teoria:");
        int nGrupsT = scanner.nextInt();

        int nGrupsL = 0;
        if(nHoresL >0) {
            System.out.println("Número de grups de laboratori:");
            nGrupsL = scanner.nextInt();
        }

        int nGrupsP = 0;
        if(nHoresP >0) {
            System.out.println("Número de grups de problemes:");
            nGrupsP = scanner.nextInt();
        }

        System.out.println("Número de grups de tarda:");
        int nGrupsTarda = scanner.nextInt();

        int nGrupsMati = nGrupsT - nGrupsTarda;
        System.out.println("Hi ha "+ nGrupsMati + "grups de matí");

        System.out.println("Número d'hores per bloc de teoria:");
        int horesBlocT = scanner.nextInt();

        int horesBlocL = 0;
        if(nHoresL >0) {
            System.out.println("Número d'hores per grup de laboratori:");
            horesBlocL = scanner.nextInt();
        }

        int horesBlocP = 0;
        if(nHoresP >0) {
            System.out.println("Número d'hores per grup de problemes:");
            horesBlocP = scanner.nextInt();
        }

        Assignatura as = new Assignatura(nom, nHoresT, nHoresL, nHoresP,
                nGrupsT, nGrupsL, nGrupsP, nGrupsTarda, nGrupsMati, horesBlocT, horesBlocL, horesBlocP, nivell);

        System.out.println("S'ha creat l'assignatura "+ nom);

        return as;
    }

}
