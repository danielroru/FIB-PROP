package Dominio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

/**
 * Class for applying the Girvan-Newman algorithm to a graph
 * @author Cluster 7 sub 1
 * @version 1.0
 */
public class GirvanNewman extends Algorithm
{
   public GirvanNewman(){}
    
    /**
     * Appicar l'algorisme de Girvan-Newman
     * @param g Graf al que apliquem l'algorisme
     */
    @Override
    public void calc(Graph<Integer,Double> g1){
    	
    	HashMap<Integer,HashMap<Integer,Double>> betw = new HashMap<Integer,HashMap<Integer,Double>>();
    	graphs = new HashMap<Integer, Graph<Integer,Double>>();
    	Graph<Integer,Double> g = g1.clone();
    	Integer totalArestes = calcArestes(g);
    	graphs.put(0, g.clone());
    	Double heValue = null; Integer heOrigin = null; Integer heDesti = null;
    	Set<Entry<Integer,HashMap<Integer,Double>>> vertexsHM;
    	Set<Entry<Integer,Double>> vertexHM;
    	HashMap<Integer,Double> edges;
    	
    	// 1. Calcular/Recalcular la "betweeness" de cada aresta del graf
    	while (calcBetw(g, betw)) { 

	    	// 2. Treiem l'aresta amb el pes més alt
    		heValue = null; heOrigin = null; heDesti = null;
    		vertexsHM = betw.entrySet();
    		
    		// Per cada vertex
    		for (Entry<Integer,HashMap<Integer,Double>> vsHM: vertexsHM) {
    			Integer origen = vsHM.getKey();
    			edges = vsHM.getValue();
    			vertexHM = edges.entrySet();
    			
    			// Mirem la seva aresta
    			for (Entry<Integer,Double> vHM: vertexHM) {
        			Integer desti = vHM.getKey();
        			Double edge = vHM.getValue();
        			
        			// Mirar si l'aresta existeix i te el pes mes alt
        			if (edge != null && (heValue == null || edge > heValue)) {
        				heValue = edge;
        				heOrigin = origen;
        				heDesti = desti;
        			}
        		}
    		}
    		
    		if (heValue != null)
    			g.removeEdge(heOrigin, heDesti);

    		Integer i = calcArestes(g);
    		Double perc = ((double)(i/(totalArestes*1.0)))*100;
    		graphs.put(100-perc.intValue(), g.clone());

        	betw = new HashMap<Integer,HashMap<Integer,Double>>();
    		//System.out.println("Arestes: " + i + " de "+totalArestes+": " + perc.intValue() + "%");
    	}
    }
    
    private Integer calcArestes(Graph<Integer,Double> g) {
    	Integer i = 0;
    	
		for (Integer v: g.getVertexs()) {
			i += g.getEdges(v).size();
		}
		
		return i;
    }
    
    private boolean calcBetw(Graph<Integer,Double> g, HashMap<Integer,HashMap<Integer,Double>> dists) {
    	boolean connected = false;
    	// Per cada vertex
    	ArrayList<Integer> vertexs = g.getVertexs();
    	for (Integer v: vertexs) {
    		HashMap<Integer,Double> hm = new HashMap<Integer,Double>();
    		HashMap<Integer,Double> edges = g.getEdges(v);
    		
    		Iterator<Integer> keys = edges.keySet().iterator();
    		while (keys.hasNext()) {
    			if (!connected) connected = true;
    			Integer k = keys.next();
    			Double edge = edges.get(k);
    			hm.put(k, 1/edge);
    		}

    		// Afegir la llista d'adjacencies al hashmap
			dists.put(v, hm);
    	}
    	
    	// Si no hi ha cap aresta, retornem fals
    	if (!connected) return false;	

    	Double dist,sum;
    	Integer key, keySub;
    	HashMap<Integer,Double> edges, subEdges;
    	Set<Entry<Integer,Double>> keys, keysSub;
    	
    	// Per cada vertex
    	for (Integer v: vertexs) {

    		// Obtenir les seves arestes
    		edges = dists.get(v);
    		keys = edges.entrySet();
    		for (Entry<Integer,Double> k: keys) {
    			
    			key = k.getKey();
    			dist = k.getValue();
    			
    			// Per cada vei de V, mirar si hi ha un cami mes curt mitjançant un vei en comu de V i de KEY
        		subEdges = dists.get(key);
        		
    			keysSub = subEdges.entrySet();
        		for (Entry<Integer,Double> ks: keysSub) {
        			keySub = ks.getKey();
        			if (!edges.containsKey(keySub)) continue;
        			
        			// Si KEYSUB es vei comu, mirar la suma de les distancies
        			sum = edges.get(keySub) + ks.getValue();
        			
        			// Si la suma es menor que la distancia actual de V a KEY, modificar-la
        			if (dist > sum) edges.put(key, sum);
        		}
    		}
    	}
    	
		return true;
    }

    /**
     * Select solution for the user
     * @param p Integer between 0 and 100
     * @return Correct graph solution for user.
     */
    @Override
    public ArrayList<ArrayList<Integer>> obtain(){
    	ArrayList<ArrayList<Integer>> coms = new ArrayList<ArrayList<Integer>>();
    	Graph<Integer,Double> graf = closestGraph();
    	
    	ArrayList<Integer> visitats = new ArrayList<Integer>();

    	if (graf == null) return coms;
    	
    	ArrayList<Integer> vs = graf.getVertexs();
    	for (Integer v: vs) {
    		ArrayList<Integer> current = new ArrayList<Integer>();
    		if (visitats.contains(v)) continue;
    		current.add(v);
    		
    		Stack<Integer> sgV = new Stack<Integer>();
    		sgV.push(v);
    		
    		while(!sgV.isEmpty()) {
    			Integer vertex = sgV.pop();
    			
    			HashMap<Integer,Double> edges = graf.getEdges(vertex);
    			Iterator<Integer> it = edges.keySet().iterator();
    			
    			while (it.hasNext()) {
    				Integer next = it.next();
    				Double n = edges.get(next);
    				
            		if (visitats.contains(next)) continue;
            		visitats.add(next);
            		
            		if (!current.contains(vertex))
            			current.add(vertex);
            		
            		if (!current.contains(next))
            			current.add(next);
            		
            		sgV.push(next);
            	}
    		}

    		coms.add(current);
    	}
    	
    	for (int i=0; i<coms.size(); i++) {
    		if (coms.get(i).isEmpty())
    			coms.remove(coms.get(i));
    	}
    	
    	return coms;
    }
    
    public void checkGraphs() {
    	Iterator<Integer> gIt = graphs.keySet().iterator();
    	
    	Graph<Integer,Double> graph;
    	
    	while (gIt.hasNext()) {
    		Integer next = gIt.next();
    		graph = graphs.get(next);
    		
    		System.out.println(next + ": " + calcArestes(graph));
    	}
    }
    
    private Graph<Integer,Double> closestGraph() {
    	Graph<Integer,Double> graf = new Graph<Integer,Double>();
    	
    	if (graphs.containsKey(p))
    		return graphs.get(p);
    	
    	Iterator<Integer> iK = graphs.keySet().iterator();
    	Integer closest = 0;
    	
    	while (iK.hasNext()){
    		Integer next = iK.next();
    		
    		if (abs(next-p) < (abs(closest-p)))
    			closest = next;
    	}
    	graf = graphs.get(closest);

    	return graf;
    }
    
    private Integer abs(Integer i) {
    	if (i < 0) return i*(-1);
    	return i;
    }
}