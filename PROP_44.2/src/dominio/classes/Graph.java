package dominio.classes;

import java.util.*;

public class Graph {

    private HashMap<Sessio, Set<UAH>> vertexs;
    private HashMap<Sessio, Set<Sessio>> arestes; //una aresta vertex tipus k te (midaSet) relacions amb altres arestes de tipus k

    public Graph() {
        vertexs = new HashMap<>();
        arestes = new HashMap<>();
    }

    public Graph(HashMap<Sessio, Set<UAH>> vertexs, HashMap<Sessio, Set<Sessio>> arestes) {
        this.vertexs = vertexs;
        this.arestes = arestes;
    }

    public void afegirArestes(Sessio s1, Sessio s2) {
        Set<Sessio> newSet = arestes.get(s1);
        newSet.add(s2);
        arestes.put(s1, newSet);
    }


    public Set<UAH> getUAHbySessio(Sessio s) {
        return this.vertexs.get(s);
    }

    public HashMap<Sessio, Set<Sessio>> getArestes() {
        return this.arestes;
    }

    public void afegirVertex(Sessio s, Set<UAH> sUAH) {
        vertexs.put(s,sUAH);
    }

    public void afegirAresta(Sessio s, Set<Sessio> sSessio) {
        arestes.put(s,sSessio);
    }


}