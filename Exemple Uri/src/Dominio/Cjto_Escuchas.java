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
public class Cjto_Escuchas {
   
    private Set<Escucha> E;
   
    public Cjto_Escuchas(){
        E = new HashSet<>();
    }
    
    public Cjto_Escuchas(Cjto_Escuchas conjEsc){
        this.E = new HashSet<>(conjEsc.getE());
    }

    public Set<Escucha> getE() {
        return E;
    }

  
    /**
     * Añadir una Escucha al sistema
     * @param e 
     */
    public void addEscucha(Escucha e){
        E.add(e);
    }
   
    
    
    //Post: Devuelve si existe la cancion con la id del parametro en alguna 
    //      de las escuchas.
    public boolean isCancion(int id){
        Iterator<Escucha> it = E.iterator();
        while(it.hasNext()){
            Escucha esc = it.next();
            if(esc.isCancion(id)){
                return true;
                
            }
        }
        return false;
    }
    
    //Post: Elimina una escucha del sistema.
    public void delEscucha(int id){
        Iterator<Escucha> it = E.iterator();
        while(it.hasNext()){
            if(it.next().getId() == id){
                it.remove();
            }
        }
    }
    
    //Post: Elimina todos las Escuchas del conjunto.
    public void delAllEscuchas(){
        E.clear();
            
    }
    
    /**
     * Elimina todas las canciones con el id del parametro de las escuchas
     * del sistema.
     * @param id 
     */
    public void delCancion(int id){
        Iterator<Escucha> it = E.iterator();
        while(it.hasNext()){
            Escucha esc = it.next();
            if(esc.isCancion(id)){
                esc.remove(id);
            }
        }
            
    }
    
    /**
     * Elimina todas las canciones de todas las escuchas del sistema.
     */
    public void vaciar(){
        Iterator<Escucha> it = E.iterator();
        while(it.hasNext()){
            it.next().removeAll();
        }
    }
    /**
     * Devuelve el numero de veces que una cancion coincide en distintos
     * conjuntos de escuchas. (Si en un conjunto de escuchas hay dos escuchas
     * que comparten c1 y c2 solo se cuentan una vez, es decir, que si un 
     * usuario tiene c1 y c2 en 2 escuchas distintas solo lo contamos una vez).
     * 
     * -OBSERVACION- Esto servira para poner valor a las aristas cuando elijan 
     *  que se asocie por "escuchas relacionadas".
     * 
     * @param c1
     * @param c2
     * @return 
     */
    public int coincidencias(Cancion c1, Cancion c2){
        int coincidencias = 0;
        Iterator<Escucha> it = E.iterator();
        while(it.hasNext()){
            if(it.next().coinciden(c1, c2)) ++coincidencias;
            
        }
        return coincidencias;
        
    }
    /**
     * Devuelve el numero de veces que una cancion coincide en distintos
     * conjuntos de escuchas.
     * @param id1
     * @param id2
     * @return 
     */
    public int coincidencias(int id1, int id2){
        int coincidencias = 0;
        Iterator<Escucha> it = E.iterator();
        while(it.hasNext()){
            if(it.next().coinciden(id1, id2)) ++coincidencias;     
        }
        return coincidencias;
        
    }
    
    public boolean coinciden(int id1, int id2){
        Iterator<Escucha> it = E.iterator();
        while(it.hasNext()){
            Escucha esc = it.next();
            if(esc.isCancion(id1) && esc.isCancion(id2)) return true;
        }
        return false;
    
    }
    /**
     * Devuelve si el conjunto de escuchas es vacio.
     * @return 
     */
    public boolean isEmpty(){
        return E.isEmpty();
    }
    /**
     * Devuelve la Escucha con la id pasada por parametro.
     * @return 
     */
    public List<Escucha> getAllEscuchas() {
        List<Escucha> listEsc = new ArrayList<>();
        Iterator<Escucha> it = E.iterator();
        while(it.hasNext()){
            Escucha e = it.next();
            listEsc.add(e);               
        }
        return listEsc;
    }
    
    public Escucha getEscucha(Integer id){
        Escucha e = new Escucha();
        for(Escucha e2 : E){
            if(e2.getId() == id){
                e = e2;
                break;
            }
        }
        return e;
    }
    
    
}
