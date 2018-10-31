/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alex.cuello
 */
public class DriverCancion {
    
    
    public static void menu() {
        System.out.print("OPCIONES\n"
                + " 0 Quit \n"
                + " 1 Añadir una Cancion\n"
                + " 2 Modificar una Cancion \n"
                + " 3 Lista de todas las canciones \n"
                + " 4 Lista de todas las ids de las canciones \n"
                + " 5 Eliminar cancion \n"
                + " 6 Eliminar todas las canciones \n"
                + " 7 Añadir cancion de un fichero \n");
    }
    public static void addAtributos(Cancion c, Scanner sc, Cjto_Canciones cc,int id) {
        System.out.println("Introduce el: ");
        System.out.print("Titulo:  ");
        String Title = sc.next();
        System.out.print("Autor:  ");
        String Author = sc.next();
        if (cc.existsCancion(Title, Author)) {
            System.out.print("Ya existe una cancion con este Titulo y Autor");  
        }
        else {
            c.setAutor(Author);
            c.setTitulo(Title);
            System.out.print("Album:  ");
            c.setAlbum(sc.next());
            System.out.print("Anyo:  ");
            c.setAnyo(sc.nextInt());
            System.out.print("Numero de estilos y despues los n estilos: ");
            Set<String> s1 = new HashSet<>();
            for(int i = sc.nextInt(); i > 0; --i){
                s1.add(sc.next());
            }
            c.setEstilo(s1);
            c.setId(id);
            cc.addCancion(c);
        }      
    }
    
    public static void showSong(Cancion c){
        System.out.print("Id:");
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
    
    
    public static void main(String[] args) {

        System.out.println("Driver Cancion - ConjuntoCanciones ejemplo");
        Scanner sc = new Scanner(System.in); // Habilitamos la entrada
        int option = -1;
        int id = 0;
        Cjto_Canciones cc = new Cjto_Canciones(); // Creamos un cjto de canciones
        ArrayList<Cancion> lista_canciones = new ArrayList<>();
        ArrayList<Integer> lista_id_canciones = new ArrayList<>();
        while (option != 0) {
            menu();
            option = sc.nextInt(); // Leemos la opcion a realizar
            switch (option) {
                case 1: // Añadir una Cancion
                    System.out.println("");
                    Cancion c = new Cancion();
                    ++id;
                    addAtributos(c,sc,cc,id); // Afegeix els atributos a la canço c
                    System.out.println("");
                    break;
                    
                case 2:
                    System.out.println("\n");
                    break;
                    
                case 3:
                    System.out.println("");
                    lista_canciones = cc.getAll(); //Tenemos todas las canciones del sistema
                    Iterator<Cancion> it2 = lista_canciones.iterator();
                    while(it2.hasNext()){ 
                        Cancion caux = it2.next();
                        showSong(caux);
                    }    
                   break;
                
                    
                case 4:
                    System.out.println("\n");
                    lista_id_canciones = cc.getAllid(); //Tenemos todas las canciones del sistema
                    Iterator<Integer> it3 = lista_id_canciones.iterator();
                    System.out.print("Ids del sistema: ");
                    while(it3.hasNext()){ 
                        System.out.print(it3.next()+" ");
                    }  
                    System.out.print("\n");
                    break;
                    
                case 5:
                    
                    System.out.println("Escriu la id de la canço que vols eliminar: ");
                    int id2 = sc.nextInt();
                    System.out.println("Segur que vols eliminar la canço amb id: "+id2+" [s/n]?" );
                    if("s".equals(sc.next()))cc.delCancion(id2);
                    System.out.println("\n"); 
                    break;
                case 6:
                    cc.delAllCanciones();
                    System.out.println("Todas las canciones eliminadas satisfactoriamente \n");
                    break;
                case 7:
                    
                    try {
                        System.out.println("Los datos de entrada tiene que estar en el ficherro: GestionDatos/Entrada/Entrada.txt");
                        System.out.println("El formato del fichero tiene que ser id:Titulo:Album:Autor:Anyo:nEstilos:Estilos#");

                    } 
                    catch (Exception ex) {
                        Logger.getLogger(DriverCancion.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                default:
                    break;

            }
        }
    }
}