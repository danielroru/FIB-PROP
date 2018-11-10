package Dominio;

import java.util.*;

public class ConjuntAules {

    /* --------------------------------------------------------------------------
        ATRIBUTS
    -------------------------------------------------------------------------- */


    //Set<Aula> conjuntAules = new HashSet<Aula>();

    private Set<Aula> conjuntAules = new HashSet<Aula>();

    /* --------------------------------------------------------------------------
        MÈTODES
    -------------------------------------------------------------------------- */


    public Set<Aula> getConjuntAules() {
        return this.conjuntAules;
    }

    public void setConjuntAules(Set<Aula> cjtAules) {
        this.conjuntAules = cjtAules;
    }

    public void afegirAula(Aula a) {
        this.conjuntAules.add(a);
    }

}
