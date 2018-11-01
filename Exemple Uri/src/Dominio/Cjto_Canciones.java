/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;


import java.util.*;
import java.io.*;
import Dominio.Cancion;

/**
 *
 * @author Alex Cuello
 */
public class Cjto_Canciones {

    private HashMap<Integer,Cancion> cjtoCanciones = new HashMap<>() ;
    
    /**
     * Constructora por defecto
     */
    public void Cjto_Canciones(){
    };


    /**
     * Pre: Si la cancion esta en el sistema la sobrescribe
     * Post: Se anyade una nueva cancion al sistema
     * @param c1 
     */
    public void addCancion(Cancion c1){ 
       cjtoCanciones.put(c1.getId(), c1);
        
    }; 

    /**
     * Pre: La cancion a modificar ha de estar en el sistema
     * Post: Se modifica una cancion 
     * @param c_old
     * @param c_new 
     */
    public void modCancion(Cancion c_old, Cancion c_new){
        if (cjtoCanciones.containsValue(c_old)) {
                cjtoCanciones.remove(c_old.getId());
                cjtoCanciones.put(c_new.getId(), c_new);
        }
    }; 
    
    /**
     * Post: Devuelve una lista con todas las canciones
     * @return 
     */
    public ArrayList<Cancion> getAll(){
        ArrayList<Cancion> lista_canciones = new ArrayList<>();
        Set<Integer> S = cjtoCanciones.keySet();
        Iterator<Integer> it = S.iterator();
        while(it.hasNext()){
            Cancion c = cjtoCanciones.get(it.next());
            lista_canciones.add(c);                      
        }
        return lista_canciones;
    }
    
    /**
     * Devuelve todos los ids que hay en el Sistema
     * @return 
     */
    public ArrayList<Integer> getAllid(){
        ArrayList<Integer> lista_id_canciones = new ArrayList<>();
        Set<Integer> S = cjtoCanciones.keySet();
        Iterator<Integer> it = S.iterator();
        while(it.hasNext()){
            lista_id_canciones.add(it.next());                      
        }
        return lista_id_canciones;
    }
    
    /**
     * Pre: La id del parametro ha de ser de alguna de las canciones del sistema
     * Post: Devuelve la cancion con la Id del parametro
     * @param id
     * @return 
     */
    public Cancion getCancion(int id) {
        if(cjtoCanciones.containsKey(id)){
            Cancion c = cjtoCanciones.get(id);
            return c;
        }
        return new Cancion();
    };
    
    
    /**
     * Post: Eliminamos la cancion del parametro
     * @param c 
     */
    public void delCancion(Cancion c){
        cjtoCanciones.remove(c.getId());
    };
    
    /**
     * Post: Eliminamos la cancion con la id que indica el parametro
     * @param id
     */
    public void delCancion(int id){
        cjtoCanciones.remove(id);
    };
    
    /**
     * Post: Eliminamos todas las canciones del sistema
     */
    public void delAllCanciones(){
        cjtoCanciones.clear();
        
    };
    
    /**
     * Si existe la cancion con id que se le pasa por parametro
     * @param idC
     * @return 
     */
    public boolean existsCancion(int idC) {
        return cjtoCanciones.containsKey(idC);
    };
    
    /**
     * Indica si existe la cancion con Titulo Title y Autor Author
     * @param Title
     * @param Author
     * @return 
     */
    public boolean existsCancion(String Title, String Author) {
        ArrayList<Cancion> lista_canciones = new ArrayList<>();
        Set<Integer> S = cjtoCanciones.keySet();
        Iterator<Integer> it = S.iterator();
        while(it.hasNext()){
            Cancion c = cjtoCanciones.get(it.next());
            if(c.getTitulo().equals(Title) && Author.equals(c.getAutor())) return true;                
        }
        return false;
    };
    
    public Cancion retCancion(String Title, String Author) {
        
        ArrayList<Cancion> lista_canciones = new ArrayList<>();
        Set<Integer> S = cjtoCanciones.keySet();
        Iterator<Integer> it = S.iterator();
        while(it.hasNext()){
            Cancion c = cjtoCanciones.get(it.next());
            if(c.getTitulo().equals(Title) && Author.equals(c.getAutor())) return c;                
        }
        return null;
        
    };
    
    
}
