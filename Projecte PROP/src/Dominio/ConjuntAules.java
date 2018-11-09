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

    public List<Aula> llistarAules() {
        List<Aula> resultat = new ArrayList<>(conjuntAules.values());
        return resultat;
    }


    public void afegirAula(String id, int capacitat, Aula.TipusAula tipus) {
        Aula a = new Aula(id, capacitat, tipus);
        this.conjuntAules.put(id, a);
    }

    public void afegirAules() {

    }
}
