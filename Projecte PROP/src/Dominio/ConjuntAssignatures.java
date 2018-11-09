package Dominio;
import JSON.JSONArray;
import JSON.JSONObject;
import JSON.parser.JSONParser;
import JSON.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class ConjuntAssignatures {

    private Set<Assignatura> cjtAssignatures;
    private HashMap<Integer, Set<Assignatura>> cjtNivell = new HashMap<>() ;

    // Conjunt Assignatures

    public ConjuntAssignatures() {
        this.cjtAssignatures = new HashSet<>();
        this.cjtNivell = new HashMap<Integer, Set<Assignatura>>();
    }

    // Consultora

    public Set<Assignatura> getConjuntAssignatures() {
        return this.cjtAssignatures;
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

    public void setCjtAssig(Set<Assignatura> cjtAssignatures) {
        this.cjtAssignatures = cjtAssignatures;
    }

    public void setCjtNivells(HashMap<Integer,Set<Assignatura>> cjtNivells) {
        this.cjtNivell = cjtNivell;
    }


    // Afegir Assignatura

    public void afegirAssignatura(Assignatura assig) {
        this.cjtAssignatures.add(assig);
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