/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.util.*;

/**
 *
 * @author Joan Torras
 */
public class Escucha {
    private int id;
    private Set<Integer> S = new HashSet<>(); // Contiene todas las id de las canciones
    
    public Escucha(){
    }
    
    /**
     * Constructora por copia
     * @param e 
     */
    public Escucha(Escucha e){
        this.id = e.getId();
        this.S = new HashSet<>(e.getS());
    }
    
    /**
     * Constructora por id, Set de canciones
     * @param id
     * @param S 
     */
    public Escucha(int id, Set<Integer> S) {
        this.S = new HashSet<>(S);
        this.id = id;
    }
    
    /**
     * Constructora por id, escucha vacia.
     * @param id 
     */
    public Escucha(int id) {
        S = new HashSet<>();
        this.id = id;
    }
    
    /**
     * Getter id.
     * @return 
     */
    public int getId() {
        return id;
    }
    
    /**
     * Setter id.
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Devuelve numero de canciones de la escucha.
     * @return 
     */
    public int getnCanciones() {
        return S.size();
    }
    
    public Set<Integer> getS() {
        return S;
    }

    public void setS(Set<Integer> S) {
        this.S = S;
    }
    
    
    /**
     * Devuelve si la escucha contiene o no canciones.
     * @return 
     */
    public boolean isEmpty(){
        return S.isEmpty();
    }
    /**
     * Añade una cancion a la escucha 
     * @param id
     */
    public void addCancion(int id) {
        S.add(id);
    }
    
    /**
     * Añade un conjunto de canciones a partir de una lista.
     * @param listC
     */
    public void addListCanciones(List<Integer> listC){
        Iterator<Integer> it = listC.iterator();
        while(it.hasNext()){
            S.add(it.next());
        }
                
    }
    /**
     * Devuelve si la cancion esta o no en la escucha.
     * @param id
     * @return 
     */
    public boolean isCancion(int id){
       return S.contains(id);
    }
    
    /**
     * Devuelve si la cancion con la id del parametro
     * esta o no en la escucha.
     * @param c
     * @return 
     */
    public boolean isCancion(Cancion c){
        return S.contains(c.getId());
    }
    /**
     * Elimina la cancion de la escucha con la id del parametro.
     * @param id 
     */
    public void remove(int id){
        S.remove(id);
    }
    
    /**
     * Elimina la cancion de la escucha.
     * @param c 
     */
    public void remove(Cancion c){
       S.remove(c.getId());
    }
    
    /**
     *  Elimina todos los elementos de la escucha.
     */
    public void removeAll() {
        S.clear();
    }
    
    /**
     * Devuelve si en la escucha coinciden c1 y c2.
     * @param c1
     * @param c2
     * @return 
     */
    public boolean coinciden(Cancion c1, Cancion c2){
        return (S.contains(c1.getId()) && S.contains(c2.getId()));
      
    }
    
    /**
     * Devuelve si en la escucha coinciden c1 y c2.
     * @param id1
     * @param id2
     * @return 
     */
    public boolean coinciden(int id1, int id2){
        return (S.contains(id1) && S.contains(id2));
      
    }
    
    /**
     * Devuelve una lista con todas las canciones del sistema.
     * @return 
     */
    public List<Integer> getListCanciones() {
        List<Integer> LC = new ArrayList<>();
        Iterator<Integer> it = S.iterator();
        while(it.hasNext()){
            Integer c = it.next();
            LC.add(c);               
        }
        return LC;
    }      
}