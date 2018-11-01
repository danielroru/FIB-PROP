/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;


import java.util.*;

/**
 *
 * @author marc.mauri.ruiz
 */
public class Usuario {
    
    
    private String nombre;
    private Integer escuchas;
    
    /**
     * Post: Se anyade un usuario, si existe no se hace nada
     * @param nombre 
     * @param id_escuchas 
     */
    public Usuario(String nombre, Integer id_escuchas) {
        this.nombre = nombre;
        this.escuchas = id_escuchas;
    }
    
    /**
     * Post: Retorna el nombre del Usuario
     * @return 
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Pre: El usuario ha de existir
     * Post: Se actualiza el nombre del parametro implicito
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Post: Devuelve el id de las escuchas del parametro implicito
     */
    public Integer getIdEscuchas() {
        return escuchas;
    }
    
    /**
     * Post: Se actualiza el id de las escuchas del parametro implicito
     * @param user 
     */
    public void setIdEscuchas(Integer escuchas) {
        this.escuchas = escuchas;
    }
    
}
