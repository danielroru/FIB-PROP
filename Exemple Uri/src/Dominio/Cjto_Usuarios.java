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
public class Cjto_Usuarios {
    private final Set<Usuario> cjtoUsers = new HashSet<>();
    
    /**
     * Post: Se crea un conjunto de usuarios vacio
     */
    public void Cjto_Usuarios(){};
    
    /**
     * Pre: El usuario ha de existir
     * Post: Anyadir un Usuario al sistema si no existe
     * @param user 
     */
    public void addUsuario(Usuario user){
        cjtoUsers.add(user);
    }; 
    
    
    
    /**
     * Pre: El old_user ha de estar en el sistema
     * Post: El old_user contiene la informacion del new_user
     * @param old_user 
     * @param new_user 
     */
    public void modUsuario(Usuario old_user, Usuario new_user){
        if (cjtoUsers.contains(old_user)) {
            for (Usuario u : cjtoUsers) {
                if (u == old_user) {
                    u.setNombre(new_user.getNombre());
                    u.setIdEscuchas(new_user.getIdEscuchas());
                }
            }
        }
        else System.out.println("El usuario no existe");
    };
    /**
     * Devuelve si existe el Usuario.
     * @param nombre
     * @return 
     */
    public boolean isUsuario(String nombre) {
        for (Usuario u : cjtoUsers) {
            if (u.getNombre().equals(nombre)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Post: Devuelve el usuario de nombre nombre si existe
     * @param nombre 
     */
    public Usuario getUsuario(String nombre) {
        for (Usuario u : cjtoUsers) {
            if (u.getNombre().equals(nombre)) {
                return u;
            }
        }
        // Si salimos del for significa que el Usuario "nombre" no existe
        System.out.println("El usuario no existe");
        return new Usuario(null,null);
    };
    
    /**
     * Post: Elimina el usuario user del sistema si existe
     * @param user 
     */
    public void delUsuario(Usuario user){
        cjtoUsers.remove(user);
    };
    
    /**
     * Post: Elimina todos los Usuario del sistema
     */
    public void delAllUsuarios(){
        cjtoUsers.clear();
    };
    
    /**
     * Post: Devuelve un ArrayList<Usuario> con todos los usuarios del sistema
     */
    public ArrayList<Usuario> getAllUsuarios(){
        ArrayList<Usuario> list = new ArrayList<>(cjtoUsers);
        return list;
    }
    
}
