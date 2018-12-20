package dominio.classes;
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
     * @param s de la que se n'obtenen les UAH
     * @return Set d'UAH corresponent a les UAH de la sessió en el graf
     */
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