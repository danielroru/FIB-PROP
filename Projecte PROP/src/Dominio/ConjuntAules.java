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

    public Map<String,Aula> getConjuntAules() {
        return this.conjuntAules;
    }

    public void setConjuntAules(Map<String, Aula> cjtAules) {
        this.conjuntAules = cjtAules;
    }

    public void afegirAula(Aula a) {
        this.conjuntAules.put(a.getId(), a);
    }

}
