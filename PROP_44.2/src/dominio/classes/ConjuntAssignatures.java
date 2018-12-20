package dominio.classes;
import java.util.*;

public class ConjuntAssignatures {

    /**
     * Map ordenat per nom d'assignatura
     */
    private Map<String, Assignatura> cjtAssignatures;
    /**
     * Map ordenat per nivell de les assignatures
     */
    private Map<Integer, Set<Assignatura>> cjtNivell;

    // Conjunt Assignatures

    /**
     * Constructora per defecte
     */
    public ConjuntAssignatures() {
        this.cjtAssignatures = new HashMap<String, Assignatura>();
        this.cjtNivell = new HashMap<Integer, Set<Assignatura>>();
    }

    // Consultora

    public Set<Assignatura> getAssignatures() {
        return new HashSet<>(cjtAssignatures.values());
    }

    public Set<Assignatura> getConjuntNivells(int nivell) {
        return cjtNivell.get(nivell);
    }

    public Set<Assignatura> getAssigsByNivell(Integer nombre) {
        return cjtNivell.get(nombre);
    }

    public Assignatura getAssignatura(String nom) {
        return cjtAssignatures.get(nom);
    }

    // Afegir Assignatura

    /**
     * Afegeix una assignatura a la instància
     *
     * @param  assig Assignatura a afegir
     */
    public void afegirAssignatura(Assignatura assig) {
        this.cjtAssignatures.put(assig.getNom(), assig);
        Set<Assignatura> nivell = cjtNivell.get(assig.getNivell());
        if (nivell == null) {
            Set<Assignatura> aux = new HashSet<>();
            aux.add(assig);
            cjtNivell.put(assig.getNivell(), aux);
        }
        else {
            nivell.add(assig);
            cjtNivell.put(assig.getNivell(), nivell);
        }
    }

    /**
     * Retorna bool segons l'existència de l'assignatura a la instància
     * @param  assig nom de l'Assignatura
     * @return true si l'Assignatura amb nom assig està dins de la instància i false altrament
     */
    public boolean existeixAssignatura(String assig) {
        return cjtAssignatures.containsKey(assig);
    }
}
