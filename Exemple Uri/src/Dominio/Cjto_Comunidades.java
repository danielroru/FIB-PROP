/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;


import java.util.*;

/**
 *
 * @author carlos.piris
 */

public class Cjto_Comunidades {
    
    private String id;
    private ArrayList<ArrayList<String>> Criterios = new ArrayList<>();
    private Graph<Integer, Double> G = new Graph<>();
    private ArrayList<ArrayList<Integer>> result = new ArrayList<>();   //Resultados de los algoritmos
    
    /**
     * A partir de un Cjto de Canciones y un Cjto de Escuchas genera un grafo
     * @param cc
     * @param ce 
     * @param n_usu 
     */
    public void genGraph(Cjto_Canciones cc, Cjto_Escuchas ce, Integer n_usu) {
        G = new Graph<>();
        ArrayList<Cancion> cjt_can = cc.getAll();
        
        //Recorremos todas las canciones para crear el grafo
        for(Cancion c : cjt_can){
            G.addVertex(c.getId());
            ArrayList<Integer> ver = G.getVertexs();
            for(Integer v : ver){
                if(c.getId() != v){
                    Double w = 0d;
                    Cancion c2 = cc.getCancion(v);
                    for(ArrayList<String> criterio : Criterios){
                        String crit = criterio.get(0);
                        Double value = Double.parseDouble(criterio.get(1));
                        //Titulo
                        if(crit.equals("titulo") || crit.equals("Titulo")){
                            if(c.getTitulo().equals(c2.getTitulo())) w += value;
                            continue;
                        }
                        
                        //Album
                        if(crit.equals("album") || crit.equals("Album")){
                            if(c.getAlbum().equals(c2.getAlbum())) w += value;
                            continue;
                        }
                        
                        //Autor
                        if(crit.equals("autor") || crit.equals("Autor")){
                            if(c.getAutor().equals(c2.getAutor())) w += value;
                            continue;
                        }
                        
                        //Anyo
                        if(crit.equals("anyo") || crit.equals("Anyo")){
                            if(c.getAnyo() == c2.getAnyo()) w += value;
                            else {
                                int dec = (c2.getAnyo()/10)*10;
                                if(c.getAnyo() >= dec && c.getAnyo() <= (dec+9)){
                                    w += value/2.0;
                                }
                            }
                            continue;
                        }
                        
                        //Estilos
                        if(crit.equals("estilo") || crit.equals("Estilo")){
                            Set<String> s1 = c.getEstilo();
                            Set<String> s2 = c2.getEstilo();
                            Integer cont = 0;
                            for(String s : s1){
                                if(s2.contains(s)) ++cont;
                            }
                            int pestilo;
                            if(s1.size() <= s2.size()) pestilo = s1.size();
                            else pestilo = s2.size();
                            w += cont * (value/(double)pestilo);
                            continue;
                        }
                        
                        //Escuchas
                        if(crit.equals("escuchas") || crit.equals("Escuchas")){
                            double n_escuchas = 0d;
                            double n_c = 0d;
                            double n_c2 = 0d;
                            for(Escucha e : ce.getAllEscuchas()){
                                n_escuchas += e.getnCanciones();
                                if(e.isCancion(c.getId())) n_c += 1d;
                                if(e.isCancion(c2.getId())) n_c2 += 1d;
                            }
                            n_escuchas /= 2;
                            if(n_escuchas != 0d){
                                if(n_c > n_c2) w += n_c2 * (value / (double)n_escuchas);
                                else w += n_c * (value / (double)n_escuchas);
                                
                            }
                            continue;
                        }
                        
                        //Usuario
                        if(crit.equals("usuario") || crit.equals("Usuario")){
                            if(ce.coincidencias(c.getId(), c2.getId()) != 0){
                                w += (double)ce.coincidencias(c.getId(), c2.getId()) * (value / (double)n_usu);
                            }
                        }
                    }
                    if(w > 0d) G.addEdge(c.getId(), v, w*10.0);
                }
            }
        }
    }
    
    /**
     * Creadora por defecto
     */
    public Cjto_Comunidades(){
        
    }
    
    /**
     * Creadora con el parametro del nombre
     * @param id 
     */
    public Cjto_Comunidades(String id) {
        this.id = id;
    }
    
    /**
     * Retorna el nombre de la comunidad
     * @return 
     */
    public String getId() {
        return id;
    }
    
    /**
     * Modicia el nombre de la Comunidad
     * @param id 
     */    
    public void setId(String id){
        this.id = id;
    }

    /**
     * Retorna la lista de Criterios de la Comunidad
     * @return 
     */
    public ArrayList<ArrayList<String>> getCriterios() {
        return Criterios;
    }

    /**
     * Retorna el grafo de la comunidad
     * @return 
     */
    public Graph<Integer, Double> getGraph() {
        return G;
    }

    /**
     * Añade los criterios a la comunidad
     * @param Criterios 
     */
    public void setCriterios(ArrayList<ArrayList<String>> Criterios) {
        this.Criterios = Criterios;
    }
    
    /**
     * Añade un criteio a la lista de criterios
     * @param s
     * @param value 
     */
    public void addCriterio(String s, String value){
        ArrayList<String> al = new ArrayList<>();
        al.add(s);
        al.add(value);
        this.Criterios.add(al);
    }
    
    /**
     * Elimina el criterio de la lista de criterios si existe
     * @param s
     * @param value 
     */
    public void delCriterio(String s, String value){
        ArrayList<String> al = new ArrayList<>();
        al.add(s);
        al.add(value);
        this.Criterios.remove(al);
    }
    
    /**
     * Devuelve los resultados del algoritmo
     * @return 
     */
    public ArrayList<ArrayList<Integer>> getResult() {
        return result;
    }
    
    /**
     * Añade los resultados del algoritmo
     * @param res 
     */
    public void setResult(ArrayList<ArrayList<Integer>> res) {
        this.result = res;
    }

    /**
     * Añade un nuevo elemento a una Comunidad
     * @param com
     * @param id 
     */
    public void addResult(int com, int id){
        if(this.result.size() <= com && com != 0){
            ArrayList<Integer> auxl = new ArrayList<>();
            auxl.add(id);
            this.result.add(auxl);
        }
        else this.result.get(com).add(id);
    }
    
    /**
     * Elimina un elemento de una Comunidad
     * @param com
     * @param id 
     */
    public void delResult(int com, int id){
        if(this.result.size() >= com){
            this.result.get(com).remove(new Integer(id));
            if(this.result.get(com).isEmpty()) this.result.remove(com);
        }
    }
    
}