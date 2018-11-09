package Dominio;
import java.util.*;


public class ConjuntAssignatures {

    private Set<Assignatura> ConjuntAssignatures;
    private HashMap<Integer, Set<Assignatura>> cjtNivell = new HashMap<>() ;

    // Conjunt Assignatures

    public ConjuntAssignatures() {
        this.ConjuntAssignatures = new HashSet<>();
        this.cjtNivell = new HashMap<Integer, Set<Assignatura>>();
    }

    // Consultora

    public Set<Assignatura> getConjuntAssignatures() {
        return this.ConjuntAssignatures;
    }

    public HashMap<Integer,Set<Assignatura>> getCjtNivells() {
        return this.cjtNivell;
    }

    public Set<Assignatura> getNivell(Integer nombre) {
        Set<Assignatura> nivell = new HashSet<>();
        nivell = cjtNivell.get(nombre);
        return nivell;
    }

    // Modificadores

    public void setCjtAssig(Set<Assignatura> ConjuntAssignatures) {
        this.ConjuntAssignatures = ConjuntAssignatures;
    }

    public void setCjtNivells(HashMap<Integer,Set<Assignatura>> cjtNivells) {
        this.cjtNivell = cjtNivell;
    }


    // Afegir Assignatura

    public void addAssignatura(Assignatura assig) {
        this.ConjuntAssignatures.add(assig);
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
