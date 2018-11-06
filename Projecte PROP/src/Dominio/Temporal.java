package Dominio;

import java.util.Scanner;

public class Temporal {
    /////////////////////////////////////////////////////////////////
    /// MENÚ GESTIÓ CONFIGURACIÓ
    /////////////////////////////////////////////////////////////////

    public static void menuGestioConfiguracio(CapaDomini CD) {
        Scanner scanner = new Scanner(System.in);
        boolean on = true;
        int accio;

        while (on) {
            escriureMenuGestioConfiguracio();
            accio = scanner.nextInt();
            switch (accio) {
                case 1:
                    configuracioAules(CD);
                    break;
                case 2:
                    configuracioAssignatures(CD);
                    break;
                case 3:
                    on = false;
                    break;
                default:
                    escriureError(1);
                    break;
            }
        }
    }

    /////////////////////////////////////////////////////////////////
    /// AULES
    /////////////////////////////////////////////////////////////////

    // Gestió

    public static void configuracioAules(CapaDomini CD) {
        Scanner scanner = new Scanner(System.in);
        boolean on = true;
        int accio;

        while (on) {
            escriureMenuAula();
            accio = scanner.nextInt();
            switch (accio) {
                case 1:
                    llistarAules(CD);
                    break;
                case 2:
                    afegirAula(CD);
                    break;
                case 3:
                    modificarAula(CD);
                    break;
                case 4:
                    eliminarAula(CD);
                    break;
                case 5:
                    on = false;
                    break;
                default:
                    escriureError(1);
                    break;
            }
        }
    }

    // Operacions

    public static void llistarAules(CapaDomini CD) {
        System.out.println("Llista d'aules:");
        System.out.println(" ");

        int nTeoria = 0;
        int nLaboratori = 0;

        for(Aula a : CD.llistarAules()){
            Aula.TipusAula tipus = a.getTipusAula();
            System.out.println("    ID:         " + a.getId());
            System.out.println("    Capacitat:  " + a.getCapacitat());
            System.out.println("    Tipus:      " + tipus);
            System.out.println(" ");

            if (tipus == Aula.TipusAula.TEORIA) {
                nTeoria++;
            }
            else {
                nLaboratori++;
            }
        }

        System.out.println("    Número de classes de teoria:  " + nTeoria);
        System.out.println("    Número de classes de laboratori: " + nLaboratori);
        System.out.println(" ");
    }

    public static void afegirAula(CapaDomini CD) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("ID de l'aula:");
        String id = scanner.nextLine();
        System.out.println("Capacitat de l'aula:");
        int capacitat = scanner.nextInt();

        System.out.println("Tipus de l'aula:");
        System.out.println("    Teoria      -> 1");
        System.out.println("    Laboratori  -> 2");

        Aula.TipusAula tipus = null;
        int numTipusAula = scanner.nextInt();

        if (numTipusAula == 1 || numTipusAula == 2) {
            tipus = numTipusAula == 1 ? Aula.TipusAula.TEORIA : Aula.TipusAula.LABORATORI;
        }

        CD.afegirAula(id, capacitat, tipus);
        System.out.println("-- AULA AFEGIDA CORRECTAMENT --");
    }

    public static void modificarAula(CapaDomini CD) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("ID de l'aula:");
        String id = scanner.nextLine();

        CD.modificarAula(id);
    }

    public static void eliminarAula(CapaDomini CD) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("ID de l'aula:");
        String id = scanner.nextLine();

        CD.eliminarAula(id);
        System.out.println("-- AULA ELIMINADA CORRECTAMENT --");
    }

    /////////////////////////////////////////////////////////////////
    /// ASSIGNATURES
    /////////////////////////////////////////////////////////////////

    // Gestió

    public static void configuracioAssignatures(CapaDomini CD) {
        Scanner scanner = new Scanner(System.in);
        boolean on = true;
        int accio;

        while (on) {
            escriureMenuAssignatura();
            accio = scanner.nextInt();
            switch (accio) {
                case 1:
                    llistarAssignatures(CD);
                    break;
                case 2:
                    afegirAssignatura(CD);
                    break;
                case 3:
                    modificarAssignatura(CD);
                    break;
                case 4:
                    eliminarAssignatura(CD);
                    break;
                case 5:
                    on = false;
                    break;
                default:
                    escriureError(1);
                    break;
            }
        }
    }

    // Operacions

    public static void llistarAssignatures(CapaDomini CD) {

    }

    public static void afegirAssignatura(CapaDomini CD) {

    }

    public static void modificarAssignatura(CapaDomini CD) {

    }

    public static void eliminarAssignatura(CapaDomini CD) {

    }


    /////////////////////////////////////////////////////////////////
    /// MENÚ GENERAR HORARI
    /////////////////////////////////////////////////////////////////

    public static void menuGenerarHorari(CapaDomini CD) {
        Scanner scanner = new Scanner(System.in);
        boolean on = true;
        int accio;

        while (on) {
            escriureMenuGenerarHorari();
            accio = scanner.nextInt();
            switch (accio) {
                case 1:
                    crearHorari(CD);
                    break;
                case 2:
                    llistarHorari(CD);
                    break;
                case 3:
                    eliminarHorari(CD);
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

    /////////////////////////////////////////////////////////////////
    /// CREAR HORARI
    /////////////////////////////////////////////////////////////////

    // Gestió

    public static void crearHorari(CapaDomini CD) {

    }

    /////////////////////////////////////////////////////////////////
    /// LLISTAR HORARI
    /////////////////////////////////////////////////////////////////

    // Gestió

    public static void llistarHorari(CapaDomini CD) {

    }

    // Operacions

    /////////////////////////////////////////////////////////////////
    /// ELIMINAR HORARI
    /////////////////////////////////////////////////////////////////

    // Gestió

    public static void eliminarHorari(CapaDomini CD) {

    }

    // Operacions


    /////////////////////////////////////////////////////////////////
    /// MENÚ CONFIGURACIO
    /////////////////////////////////////////////////////////////////

    public static void menuConfiguracio(CapaDomini CD) {
        Scanner scanner = new Scanner(System.in);
        boolean on = true;
        int accio;

        while (on) {
            escriureMenuConfiguracio();
            accio = scanner.nextInt();
            switch (accio) {
                case 1:
                    intervalHores(CD);
                    break;
                case 2:
                    canviFranja(CD);
                    break;
                case 3:
                    on = false;
                    break;
                default:
                    escriureError(1);
                    break;
            }
        }
    }

    /////////////////////////////////////////////////////////////////
    /// INTERVAL HORES (HORA INICI / HORA FI)
    /////////////////////////////////////////////////////////////////

    // Gestió

    public static void intervalHores(CapaDomini CD) {
        Scanner scanner = new Scanner(System.in);
        boolean on = true;
        int accio;

        while (on) {
            escriureMenuIntervalHores();
            accio = scanner.nextInt();
            switch (accio) {
                case 1:
                    getIntervalHores(CD);
                    break;
                case 2:
                    setHoraInici(CD);
                    break;
                case 3:
                    setHoraFi(CD);
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

    // Operacions GET

    public static void getIntervalHores(CapaDomini CD) {

    }

    // Operacions SET

    public static void setHoraInici(CapaDomini CD) {

    }

    public static void setHoraFi(CapaDomini CD) {

    }

    /////////////////////////////////////////////////////////////////
    /// CANVI FRANJA
    /////////////////////////////////////////////////////////////////

    // Gestió

    public static void canviFranja(CapaDomini CD) {
        Scanner scanner = new Scanner(System.in);
        boolean on = true;
        int accio;

        while (on) {
            escriureMenuHoraCanviFranja();
            accio = scanner.nextInt();
            switch (accio) {
                case 1:
                    getHoraCF(CD);
                    break;
                case 2:
                    setHoraCF(CD);
                    break;
                case 3:
                    on = false;
                    break;
                default:
                    escriureError(1);
                    break;
            }
        }
    }

    // Operacions GET

    public static void getHoraCF(CapaDomini CD) {

    }

    // Operacions SET

    public static void setHoraCF(CapaDomini CD) {

    }


    // Nivell 1
    public static void escriureMenu() {
        System.out.println("");
        System.out.println("1] Gestió Configuració");
        System.out.println("2] Generar Horari");
        System.out.println("3] Configuració");
        System.out.println("4] Sortir de l'aplicació");
    }

    // Nivell 2 - [1] opció: Gestió Configuració
    public static  void escriureMenuGestioConfiguracio() {
        System.out.println("");
        System.out.println("1] Configuració Aules");
        //System.out.println("2] Configuració Nivells");
        System.out.println("2] Configuració Assignatures");
        System.out.println("3] Enrere");
    }

    // Nivell 3 - [1 - 1] opcionó: Menú Aules
    public static void escriureMenuAula() {
        System.out.println("");
        System.out.println("1] Llistar Aules Disponibles");
        System.out.println("2] Afegir Aula");
        System.out.println("3] Modificar Aula");
        System.out.println("4] Eliminar Aula");
        System.out.println("5] Enrere");
    }

    // Nivell 3 - [1 - 3] opció: Menú Assignatures
    public static void escriureMenuAssignatura() {
        System.out.println("");
        System.out.println("1] Llistar Assignatures Disponibles");
        System.out.println("2] Afegir Assignatura");
        System.out.println("3] Modificar Assignatura");
        System.out.println("4] Eliminar Assignatura");
        System.out.println("5] Enrere");
    }

    // Nivell 2 - [2] opció: Generar Horari
    public static  void escriureMenuGenerarHorari() {
        System.out.println("");
        System.out.println("1] Crear Horari");
        System.out.println("2] Llistar Horari");
        System.out.println("3] Eliminar Horari");
        System.out.println("4] Enrere");
    }

    // Nivell 2 - [3] opció: Configuració
    public static  void escriureMenuConfiguracio() {
        System.out.println("");
        System.out.println("1] Hora Inici / Hora Fi");
        System.out.println("2] Hora Canvi Franja");
        System.out.println("3] Enrere");
    }

    // Nivell 3 - [3 - 1] opció: Hora Inici / Hora Fi

    public static  void escriureMenuIntervalHores() {
        System.out.println("");
        System.out.println("1] Mostrar Hores [Inici - Fi]");
        System.out.println("2] Modificar Hora Inici");
        System.out.println("3] Modificar Hora Fi");
        System.out.println("4] Enrere");
    }

    public static  void escriureMenuHoraCanviFranja() {
        System.out.println("");
        System.out.println("1] Mostrar Hora Canvi Franja");
        System.out.println("2] Modificar Hora Canvi Franja");
        System.out.println("3] Enrere");
    }

    public static void escriureError(int nError) {
        switch (nError){
            case 1:
                System.out.println("Error: Indica una de les opcions!");
                break;
        }
    }

    public static void main(String[] args) {
        CapaDomini CD = new CapaDomini();
        Scanner scanner = new Scanner(System.in);

        boolean on = true;
        int accio;

        while (on) {
            System.out.println("Indica el valor de l'operació:");
            escriureMenu();
            accio = scanner.nextInt();
            switch (accio) {
                case 1:
                    menuGestioConfiguracio(CD);
                    break;
                case 2:
                    menuGenerarHorari(CD);
                    break;
                case 3:
                    menuConfiguracio(CD);
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
}
