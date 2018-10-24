package Dominio;

import java.util.*;

public class ConjuntAules {

    /* --------------------------------------------------------------------------
        ATRIBUTS
    -------------------------------------------------------------------------- */


    //Set<Aula> conjuntAules = new HashSet<Aula>();

    Map<String,Assignatura> conjuntAules = new HashMap<String,Assignatura>();

    /* --------------------------------------------------------------------------
        MÈTODES
    -------------------------------------------------------------------------- */

    public void afegirAula() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("ID de l'aula:");
        int id = scanner.nextLine();

        System.out.println("Capacitat de l'aula:");
        int capacitat = scanner.nextInt();

        System.out.println("Tipus de l'aula:");
        System.out.println("    Teoria      -> 1");
        System.out.println("    Laboratori  -> 2");

        Aula.TipusAula tipus;
        int numTipusAula = scanner.nextInt();

        if (numTipusAula == 1 || numTipusAula == 2) {
            tipus = numTipusAula == 1 ? Aula.TipusAula.TEORIA : Aula.TipusAula.LABORATORI;
        }


        Aula a = new Aula(id,capacitat,tipus);
        conjuntAules.put(id, a);
    }

    public void eliminarAula(Aula a) {
        conjuntAules.remove(a);
    }

}
