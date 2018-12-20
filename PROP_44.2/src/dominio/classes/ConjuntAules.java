package dominio.classes;

import java.util.*;

public class ConjuntAules {

    /* --------------------------------------------------------------------------
        ATRIBUTS
    -------------------------------------------------------------------------- */

    private Map<String, Aula> conjuntAules = new HashMap<>();

    /* --------------------------------------------------------------------------
        MÈTODES
    -------------------------------------------------------------------------- */

    /**
     * Afegeix una aula a la instància
     *
     * @param  a Aula a afegir
     * @return la instància amb l'Aula afegida
     */
    public void afegirAula(Aula a) {
        this.conjuntAules.put(a.getId(), a);
    }

    public Aula getAula(String id) {
        return this.conjuntAules.get(id);
    }

    public Set<String> getNomsAules() {

        return conjuntAules.keySet();
    }

    public Set<Aula> getAules() {
        return new HashSet<>(conjuntAules.values());
    }

}
