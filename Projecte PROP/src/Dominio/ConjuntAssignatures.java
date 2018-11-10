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

    public Map<String, Assignatura> getConjuntAssignatures() {
        return this.cjtAssignatures;
    }

    public HashMap<Integer,Set<Assignatura>> getCjtNivells() {
        return this.cjtNivell;
    }

    public Set<Assignatura> getNivell(Integer nombre) {
        return cjtNivell.get(nombre);
    }

    // Modificadores

    public void setCjtAssig(Map<String, Assignatura> cjtAssignatures) {
        this.cjtAssignatures = cjtAssignatures;
    }

    public void setCjtNivells(HashMap<Integer,Set<Assignatura>> cjtNivells) {
        this.cjtNivell = cjtNivell;
    }


    // Afegir Assignatura

    public void afegirAssignatura(Assignatura assig) {
        this.cjtAssignatures.get(assig);
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
