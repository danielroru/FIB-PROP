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
    private ConjuntAules() {}

    public Set<Aula> getAules() {
        return this.conjuntAules;
    }

    public static ConjuntAules getInstance() {
        return instance;
    }

    public static void reset() {
        instance = new ConjuntAules();
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

    public Aula getAula(String id) {
        Aula aula = null;
        for (Aula a : conjuntAules) {
            if (id == a.getId()) return a;
        }
        return aula;
    }

}
