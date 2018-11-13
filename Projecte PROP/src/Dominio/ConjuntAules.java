package Dominio;

import java.util.*;

public class ConjuntAules {

    /* --------------------------------------------------------------------------
        ATRIBUTS
    -------------------------------------------------------------------------- */

    private Set<Aula> conjuntAules = new HashSet<Aula>();

    /* --------------------------------------------------------------------------
        MÈTODES
    -------------------------------------------------------------------------- */


    public Set<Aula> getAules() {
        return this.conjuntAules;
    }

    public void setConjuntAules(Set<Aula> cjtAules) {
        this.conjuntAules = cjtAules;
    }

    public void afegirAula(Aula a) {
        this.conjuntAules.add(a);
    }

}
