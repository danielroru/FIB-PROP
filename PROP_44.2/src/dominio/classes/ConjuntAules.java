package dominio.classes;
import java.util.*;

public class ConjuntAules {

    /* --------------------------------------------------------------------------
        ATRIBUTS
    -------------------------------------------------------------------------- */

    private static Set<Aula> conjuntAules = new HashSet<Aula>();
    private static ConjuntAules instance = new ConjuntAules();

    /* --------------------------------------------------------------------------
        MÈTODES
    -------------------------------------------------------------------------- */
    public ConjuntAules() {}

    public Set<Aula> getAules() {
        return this.conjuntAules;
    }


    public void reset() {
        instance = new ConjuntAules();
    }

    /**
     * Afegeix una aula a la instància
     *
     * @param  a Aula a afegir
     */
    public void afegirAula(Aula a) {
        this.conjuntAules.add(a);
    }


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