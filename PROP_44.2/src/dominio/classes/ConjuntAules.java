package dominio.classes;

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

    /**
     * Afegeix una aula a la instància
     *
     * @param  a Aula a afegir
     * @return la instància amb l'Aula afegida
     */
    public void afegirAula(Aula a) {
        this.conjuntAules.add(a);
    }

}
