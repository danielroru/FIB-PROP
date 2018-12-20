package dominio.classes;
import java.util.*;

public class ConjuntAules {

    /* --------------------------------------------------------------------------
        ATRIBUTS
    -------------------------------------------------------------------------- */

    private static HashMap<String, Aula> conjuntAules = new HashMap<String, Aula>();
    private static ConjuntAules instance = new ConjuntAules();

    /* --------------------------------------------------------------------------
        MÈTODES
    -------------------------------------------------------------------------- */
    public ConjuntAules() {}

    public HashSet<Aula> getAules() {
        return new HashSet<>(this.conjuntAules.values());
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
        this.conjuntAules.put(a.getId(), a);
    }

    /**
     * Retorna una aula a partir de l'id
     *
     * @param id Nom de l'aula a buscar
     * @return aula buscada
     */
    public Aula getAula(String id) {
        return this.conjuntAules.get(id);
    }

    /**
     * Comprova si una aula existeix
     *
     * @param id Nom de l'aula a buscar
     * @return true si l'aula existeix
     */
    public Boolean existeixAula(String id) {
        return this.conjuntAules.containsKey(id);
    }


}

