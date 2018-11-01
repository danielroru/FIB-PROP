/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.util.*;

/**
 *
 * @author carlos.piris
 */
public class DriverCjto_Usuarios {
    
    private static Integer cont = 0;
    
    public static void menu() {
        System.out.print("OPCIONES\n"
                + " 0 Quit \n"
                + " 1 Añadir un Usuario\n"
                + " 2 Modificar un Usuario \n"
                + " 3 Lista de todos los usuarios \n"
                + " 4 Eliminar usuario \n"
                + " 5 Eliminar todos los usuarios \n");
    }
    
    public static Usuario leeUsuario(Scanner sc){
        System.out.print("Nombre del usuario: ");
        Usuario u = new Usuario(sc.next(), cont);
        ++cont;
        return u;
    }
    
    public static void main(String[] args) {
        System.out.println("Driver Cjto_Usuarios");
        Scanner sc = new Scanner(System.in); // Habilitamos la entrada
        int option = -1;
        Cjto_Usuarios cu = new Cjto_Usuarios(); // Creamos un cjto de Usuarios
        while (option != 0) {
            menu();
            option = sc.nextInt(); // Leemos la opcion a realizar
            switch (option) {
                case 1: // Añadir una Usuario
                    System.out.print("\n");
                    Usuario u = leeUsuario(sc);
                    cu.addUsuario(u); // Añadimos la cancion al conjunto de usuarios
                    System.out.print("\n");
                    break;
                    
                case 2: // Modificar un Usuario
                    System.out.print("\n");
                    System.out.print("Nombre del usuario a modificar: ");
                    String s = sc.next();
                    System.out.println("Nuevos valores: ");
                    Usuario u2 = leeUsuario(sc);
                    cu.modUsuario(cu.getUsuario(s), u2);
                    break;
                    
                case 3: // Lista de todos los usuarios
                    System.out.println("\n");
                    ArrayList<Usuario> lu = cu.getAllUsuarios(); //Tenemos todos los usuarios del sistema
                    for(Usuario uit : lu){
                        System.out.println(uit.getNombre());
                    }  
                   break;
                    
                case 4: // Eliminar Usuario
                    System.out.print("\n");
                    System.out.print("Nombre del usuaior a eliminar: ");
                    String n = sc.next();
                    System.out.print("Seguro que quieres eliminar el Usuario con nombre "+n+" [s/n]?" );
                    if("s".equals(sc.next())){
                        cu.delUsuario(cu.getUsuario(n));
                    }
                    System.out.println("\n"); 
                    break;
                case 5: // Eliminar todos los usuarios
                    System.out.print("\n");
                    System.out.print("Seguro que quieres eliminar todos los Usuarios [s/n]? ");
                    if("s".equals(sc.next()))cu.delAllUsuarios();
                    System.out.print("Todas los usuarios eliminados satisfactoriamente \n");
                    break;
                default:
                    break;

            }
            System.out.print("\n");
        }
    }
}
