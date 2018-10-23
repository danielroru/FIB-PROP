package Dominio;
import java.util.Scanner;

public class Utils {
    //Scanner scanner = new Scanner(System.in);
    public static void escriureMenu() {
        System.out.println("1] Crear Aula");
        System.out.println("2] Crear Nivel");
        System.out.println("3] Eliminar Aula");
        System.out.println("4] Eliminar Nivell");
        //System.out.println("5] Aules");
        //System.out.println("6] Nivells");
        System.out.println("5] Crear Assignatura");
        System.out.println(("6] Sortir"));
    }

    public static PlaEstudis crearPlaEstudis() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hora d'inici de les classes");
        int horaInici = scanner.nextInt();

        System.out.println("Hora de fi de les classes");
        int horaFi = scanner.nextInt();

        System.out.println("Hora de canvi d'horari matí/tarda");
        boolean correcte = false;
        int horaCanviFranja = -1;
        while (!correcte) {
            int hora = scanner.nextInt();
            if (hora < horaInici || hora > horaFi) {
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
