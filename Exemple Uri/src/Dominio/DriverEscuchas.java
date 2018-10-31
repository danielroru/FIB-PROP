/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.util.*;
/**
 *
 * @author Joan Torras
 */
public class DriverEscuchas {
    
      /*
     public static void showSong(Cancion c){
        System.out.print("ID:");
        System.out.print(c.getId());
        System.out.print("\nTitulo: "); 
        System.out.print(c.getTitulo());
        System.out.print("\nAutor: ");
        System.out.print(c.getAutor());
        System.out.print("\nAlbum: ");
        System.out.print(c.getAlbum());
        System.out.print("\nAño: ");
        System.out.print(c.getAnyo());
        Set<String> S = c.getEstilo();
        Iterator<String> it2 = S.iterator();
        System.out.println("\nEstilos: ");
        while(it2.hasNext()){
            System.out.println(it2.next()+" ");
        }
        System.out.print("\n");
    }
    */
    
     public static void show(Escucha e){
        List<Integer> l = new ArrayList<>(e.getListCanciones());
        Iterator<Integer> it = l.iterator();
        while(it.hasNext()){
            System.out.print(it.next() + "\n");
            
            
        }
    }
        


     public static void main(String[] args) {         
         System.out.print("---DRIVER ESCUCHAS---\n");
         Escucha e = new Escucha(0);
         
         int caso = -1;
         
         while(caso != 0){
            System.out.print("ELIGE MODO:\n");
            System.out.print("1-> Añadir cancion\n");
            System.out.print("2-> Eliminar cancion\n");
            System.out.print("3-> Buscar cancion\n");
            System.out.print("4-> Buscar si coinciden dos canciones\n");
            System.out.print("5-> Mostrar lista canciones\n");
            System.out.print("6-> Eliminar todas las canciones\n");
            System.out.print("7-> Salir\n");
            Scanner leer = new Scanner(System.in);
            caso = leer.nextInt();
            switch(caso){
                case 1:
                    System.out.print("---AÑADIR CANCION---\n");
                    System.out.print("Escribe el id de la cancion\n");
                    leer = new Scanner(System.in);      
                    e.addCancion(leer.nextInt());
                    break;
                case 2:
                    System.out.print("---ELIMINAR CANCION---\n");
                    System.out.print("Pon el id de la cancion a eliminar\n");
                    leer = new Scanner(System.in);
                    e.remove(leer.nextInt());
                    break;

                case 3:
                    System.out.print("---BUSCAR CANCION---\n");
                    System.out.print("Escribe el id de la cancion a buscar\n");
                    leer = new Scanner(System.in);
                    int id = leer.nextInt();
                    if(e.isCancion(id)){
                        System.out.print("la cancion con ID =" + id + ""
                                + " esta en el sistema\n");
                    }
                    else System.out.print("La cancion no esta en el sistema\n");
                    break;
                case 4:
                    System.out.print("---COINCIDENCIAS---\n");
                    System.out.print("Escribe las ids de las canciones\n");
                    leer = new Scanner(System.in);
                    int id1 = leer.nextInt();
                    int id2 = leer.nextInt();
                    if(e.isCancion(id1) && e.isCancion(id2)) System.out.print(""
                            + "Coinciden!\n");
                    else System.out.print("No coinciden!\n");
                    break;
                    
                case 5:
                    System.out.print("---MOSTRAR LISTA CANCIONES---\n");
                    show(e);
                    break;
                    
                case 6:
                    System.out.print("---ELIMINAR TODAS LAS CANCIONES--\n");
                    e.removeAll();
                    break;
                case 7:
                    System.out.print("---GOODBYE---\n");
                    caso = 0;
                    
            }
                    
        }
                

    }
}
