package Dominio;

import java.util.*;

public class CapaDomini {

    private PlaEstudis pe = new PlaEstudis();
    private ConjuntAules conjuntAules = new ConjuntAules();
    private ConjuntRestriccions ConjuntRestriccions = new ConjuntRestriccions();

    public List<Aula> llistarAules() {
        return conjuntAules.llistarAules();
    }

    public void afegirAula(String id, int capacitat, Aula.TipusAula tipus) {
        conjuntAules.afegirAula(id,capacitat,tipus);
    }



    // Per eliminar
    // -------------------// -------------------// -------------------// -------------------// -------------------
    // -------------------// -------------------// -------------------// -------------------// -------------------
    // -------------------// -------------------// -------------------// -------------------// -------------------




    public static void hInihFi (Scanner scanner, PlaEstudis pe) {
        int accio;
        boolean on_hIniFi = true;
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
            }
        } while (on_hIniFi);
    }

    public static void hCanviFranja (Scanner scanner, PlaEstudis pe) {
        int accio;
        boolean on_hCanviFranja = true;
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
            }
        } while (on_hCanviFranja);
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

        /*
        System.out.println("Nombre de nivells");
        int nNivell = scanner.nextInt();

        System.out.println("Nombre d'aules");
        int nAula = scanner.nextInt();
        */

        PlaEstudis pe = new PlaEstudis(horaInici, horaFi, horaCanviFranja);

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
            // if (nivell > 0 && nivell < pe.getNNivell()) {
            if (nivell > 0) {
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
