package Dominio;

import java.util.*;


public class ConjuntAssignatures {

    private Map<String, Assignatura> cjtAssignatures;
    private HashMap<Integer, Set<Assignatura>> cjtNivell;

    // Conjunt Assignatures

    public ConjuntAssignatures() {
        this.cjtAssignatures = new HashMap<String, Assignatura>();
        this.cjtNivell = new HashMap<Integer, Set<Assignatura>>();
    }

    // Consultora

    public Set<Assignatura> getConjuntAssignatures() {
        return this.cjtAssignatures.values();
    }

    public HashMap<Integer,Set<Assignatura>> getConjuntNivells() {
        return this.cjtNivell;
    }

    public Set<Assignatura> getNivell(Integer nombre) {
        return cjtNivell.get(nombre);
    }

    public Assignatura getAssignatura(String nom) {
        return cjtAssignatures.get(nom);
    }

    // Afegir Assignatura

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



}
