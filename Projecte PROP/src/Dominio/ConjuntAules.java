package Dominio;

import java.util.*;

public class ConjuntAules {

    /* --------------------------------------------------------------------------
        ATRIBUTS
    -------------------------------------------------------------------------- */


    //Set<Aula> conjuntAules = new HashSet<Aula>();

    private Map<String,Aula> conjuntAules = new HashMap<String,Aula>();

    /* --------------------------------------------------------------------------
        MÈTODES
    -------------------------------------------------------------------------- */

    public void afegirAula() {

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

        Aula a = new Aula(id, capacitat, tipus);
        conjuntAules.put(id, a);
    }


    public void eliminarAula() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Entra la ID de l'aula que vols eliminar:");
        String id = scanner.nextLine();

        conjuntAules.remove(conjuntAules.get(id));
    }

}
