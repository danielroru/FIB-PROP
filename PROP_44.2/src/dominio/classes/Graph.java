package dominio.classes;

import javafx.util.Pair;

import java.util.*;

public class Graph {

    private HashMap<Sessio, Set<UAH>> vertexs;
    private HashMap<Sessio, Set<Sessio>> arestes; //una aresta vertex tipus k te (midaSet) relacions amb altres arestes de tipus k

    /**
     * Constructora per defecte
     */
    public Graph() {
        vertexs = new HashMap<>();
        arestes = new HashMap<>();
    }

    /**
     * Constructora amb inicialització
     *
     * @param  vertexs vèrtexs del graf
     * @param  arestes arestes del graf
     */
    public Graph(HashMap<Sessio, Set<UAH>> vertexs, HashMap<Sessio, Set<Sessio>> arestes) {
        this.vertexs = vertexs;
        this.arestes = arestes;
    }


    /**
     * Afegeix arestes de s1 cap a s2
     * @param s1 sessió a la que s'afageixen l'aresta
     * @param s2 sessió cap on va dirigida l'aresta
     */
    public void afegirArestes(Sessio s1, Sessio s2) {
        Set<Sessio> newSet = arestes.get(s1);
        newSet.add(s2);
        arestes.put(s1, newSet);
    }

    /**
     * Retorna totes les UAH de la sessió s
     * @param s sessió de la que se n'obtenen les UAH
     * @return Set d'UAH corresponent a les UAH de la sessió en el graf
     */
    public Set<UAH> getUAHbySessio(Sessio s) {
        return this.vertexs.get(s);
    }

    public HashMap<Sessio, Set<Sessio>> getArestes() {
        return this.arestes;
    }

    public HashMap<Sessio, Set<UAH>> getVertexs() {
        HashMap<Sessio, Set<UAH>> vertex;
        vertex = new HashMap<>(this.vertexs);
        return vertex;
    }

    public HashMap<Sessio, Set<UAH>> copyVertexs() {
        HashMap<Sessio, Set<UAH>> copy = new HashMap<Sessio, Set<UAH>>();
        for (Map.Entry<Sessio, Set<UAH>> entry : vertexs.entrySet()) {
            /*Set<UAH> set = new HashSet<>();
            for (UAH uah : entry.getValue()) {
                set.add(uah);
            }*/
            copy.put(entry.getKey(), new HashSet<UAH>(entry.getValue()));
        }
        return copy;
    }

    public void afegirVertex(Sessio s, Set<UAH> sUAH) {
        vertexs.put(s,sUAH);
    }

    public void afegirAresta(Sessio s, Set<Sessio> sSessio) {
        arestes.put(s,sSessio);
    }

    public Pair<Sessio, Sessio> extreureArc() {
        return new Pair<>(arestes.entrySet().iterator().next().getKey(), arestes.entrySet().iterator().next().getValue().iterator().next());
    }

    public void esborrarUAHDomini(UAH uah, Sessio s) {
        vertexs.get(s).remove(uah);
    }

    public void afegirArcs(Pair<Sessio, Sessio> arc) {
        for (Sessio s : arestes.get(arc.getKey())) {
            if (s != arc.getValue()) {
                Set<Sessio> newValues = arestes.get(arc.getKey());
                newValues.add(s);
                arestes.put(arc.getKey(), newValues);
            }
        }
    }

    public void assignarUAH(Sessio s, UAH uah) {
        int duracio = 0;
        switch (s.getTipus()) {
            case TEORIA:
                duracio = s.getAssignatura().getnHoresT();
                break;
            case LABORATORI:
                duracio = s.getAssignatura().getnHoresL();
                break;
            case PROBLEMES:
                duracio = s.getAssignatura().getnHoresP();
                break;
        }
        Set<UAH> assignar = new HashSet<>();
        if (vertexs.get(s).size() < duracio) {
            assignar = vertexs.get(s);
        }
        vertexs.remove(s);
        assignar.add(uah);
        vertexs.put(s, assignar);
    }

    public boolean assignacioCompelta(Sessio s) {
        int duracio = 0;
        switch (s.getTipus()) {
            case TEORIA:
                duracio = s.getAssignatura().getnHoresT();
                break;
            case LABORATORI:
                duracio = s.getAssignatura().getnHoresL();
                break;
            case PROBLEMES:
                duracio = s.getAssignatura().getnHoresP();
                break;
        }
        if (vertexs.get(s).size() == duracio) return true;
        return false;
    }

    public boolean esfallo() {
        return this.vertexs.isEmpty();
    }

    public void eliminarUAH(Sessio s, UAH uah) {
        this.vertexs.get(s).remove(uah);
    }

    /*public void teRestriccio(Sessio principal, Sessio y) {
    }*/
}