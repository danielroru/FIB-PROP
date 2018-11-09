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


    public void afegirAula(Aula a) {
        this.conjuntAules.put(a.getId(), a);
    }

    public void afegirAules() {

    }
}
