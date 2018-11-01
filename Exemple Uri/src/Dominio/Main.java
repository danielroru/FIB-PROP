/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;
import GestionDatos.FileManager;
import Dominio.ControladoraDominio;
import java.util.*;
import java.io.*;
/**
 *
 * @author Alex Cuello / Carlos Piris
 */
public class Main {
    
    public static void menu() {
        System.out.print("OPCIONES \n"
                + " 0 Quit \n"
                + " 1 Administrar Canciones \n"
                + " 2 Administrar Usuarios con sus Escuchas \n"
                + " 3 Administrar Comunidades \n"
                + " 4 Algoritmos \n");
    }
    
    public static void menuCancion() {
        System.out.print("CONFIG CANCIONES \n"
                + " 0 Return \n"
                + " 1 Añadir una Cancion \n"
                + " 2 Listar canciones \n"
                + " 3 Modificar Cancion \n"
                + " 4 Eliminar cancion \n"
                + " 5 Eliminar todas las canciones \n"
                + " 6 Cargar Canciones desde fichero \n"
                + " 7 Guardar Canciones a un fichero \n");
    }
    
    public static void menuCancion2() {
        System.out.print("Listar Canciones: \n"
                + " 0 Return \n"
                + " 1 Todas\n"
                + " 2 Titulo\n"
                + " 3 Autor\n"
                + " 4 Album\n"
                + " 5 Anyo\n"
                + " 6 Estilo\n");
    }
    
    public static void menuUsuario() {
        System.out.print("CONFIG USUARIOS\n"
                + " 0 Return \n"
                + " 1 Añadir un Usuario \n"
                + " 2 Listar Usuarios \n"
                + " 3 Modificar Usuario \n"
                + " 4 Eliminar Usuario \n"
                + " 5 Eliminar todos los usuarios \n"
                + " 6 Cargar Usuarios desde fichero \n"
                + " 7 Guardar Usuarios a un fichero \n");
    }
    
    public static void menuComunidad() {
        System.out.print("CONFIG COMUNIDADES\n"
                + " 0 Return \n"
                + " 1 Crear un Cjto_Comunidades \n"
                + " 2 Ver nombre del Cjto_Comunidades \n"
                + " 3 Ver Criterios del Cjto_Comunidades \n"
                + " 4 Ver Grafo del Cjto_Comunidades \n"
                + " 5 Modificar nombre y criterios del Cjto_Comunidades \n"
                + " 6 Ver Comunidades \n"
                + " 7 Añadir cancion a una Comunidad \n"
                + " 8 Eliminar cancion de una Comuniadad \n"
                + " 9 Cargar Comunidades\n"
                + " 10 Guardar Comunidades\n");
    }
    
    public static void menuAlgoritmos() {
        System.out.print("ALGORITMOS \n"
                + " 0 Return \n"
                + " 1 Clique Percolation \n"
                + " 2 Girvan Newman \n"
                + " 3 Louvain \n"
                + " 4 Mostrar conjuntos calculados \n"
                + " 5 Guardar conjuntos calculados \n");
    }
    
    public static void addCancion(ControladoraDominio CD, Scanner sc2, int id) {
        System.out.println("Introduce el: ");
        System.out.print("Titulo:  ");
        String Titulo = sc2.next();
        System.out.print("Autor:  ");
        String Autor = sc2.next();
        if (CD.existsCancion(Titulo, Autor)) {
            System.out.print("Ya existe una cancion con este Titulo y Autor");  
        }
        else {
            System.out.print("Album:  ");
            String Album = sc2.next();
            System.out.print("Anyo:  ");
            int Anyo = sc2.nextInt();
            System.out.print("Numero de estilos y despues los n estilos: ");
            Set<String> s1 = new HashSet<>();
            for(int i = sc2.nextInt(); i > 0; --i){
                s1.add(sc2.next());
            }
            ++id;
            CD.addCancion(Titulo, Autor, Album, Anyo, s1);
        }  
        
    }
    
    public static void printCancion (Cancion c) {
        System.out.println("Id: "+c.getId());
        System.out.println("Titulo: "+c.getTitulo());
        System.out.println("Autor: "+c.getAutor());
        System.out.println("Album: "+c.getAlbum());
        System.out.println("Anyo: "+c.getAnyo());
        Set<String> est = c.getEstilo();
        System.out.print("Estilos: ");
        for(String es : est) System.out.print(es + " ");
        System.out.println("\n");
        
    }
        
    public static void main(String[] args) {
        System.out.println();
        System.out.println("Driver del Dominio");
        Scanner sc = new Scanner(System.in); // Habilitamos la entrada
        int option = -1;
        int id = 0;
        ControladoraDominio CD = new ControladoraDominio(); // Creamos la controladora del dominio

        while (option != 0) {
            menu();
            option = sc.nextInt(); // Leemos la opcion a realizar
            switch (option) {
                case 1: // Administrar Canciones
                    int opc = -1;
                    while(opc != 0) {
                        menuCancion();
                        opc = sc.nextInt();
                        switch (opc) {
                            case 1: // Añadir Cancion desde consola
                                System.out.println("");
                                addCancion(CD,sc,id);
                                System.out.print("\n");
                                break;
                            case 2: // Listar Cancion
                                menuCancion2();
                                option = sc.nextInt();
                                while(option != 0) {
                                    menuCancion2();
                                    switch(option){
                                        case 1: //Listar todas las canciones
                                            System.out.println("");
                                            System.out.print("Todas las canciones del sistema son: \n");
                                            ArrayList<Cancion> lc = CD.getAll();
                                            for(Cancion c: lc){
                                                printCancion(c);
                                            }
                                            break;
                                        case 2: // Listar Canciones por Titulo
                                            System.out.println("");
                                            System.out.print("Introduce el Titulo de las canciones que quieres buscar : ");
                                            String Titulo = sc.next();
                                            ArrayList<Cancion> lc2 = CD.getAll();
                                            for(Cancion c: lc2){
                                                if(c.getTitulo().equals(Titulo)) printCancion(c);
                                            }
                                            break;
                                        
                                        case 3: // Listar Canciones por Autor
                                            System.out.println("");
                                            System.out.print("introduce el Autor de las canciones que quieres buscar: ");
                                            String Autor = sc.next();
                                            ArrayList<Cancion> lc3 = CD.getAll();
                                            for(Cancion c: lc3){
                                                if(c.getAutor().equals(Autor)) printCancion(c);
                                            }
                                            break;
                                        case 4: // Listar Canciones por Album
                                            System.out.println("");
                                            System.out.print("introduce el Album de las canciones que quieres buscar: ");
                                            String Album = sc.next();
                                            ArrayList<Cancion> lc4 = CD.getAll();
                                            for(Cancion c: lc4){
                                                if(c.getAlbum().equals(Album)) printCancion(c);
                                            }
                                            break;
                                        case 5: // Listar Canciones por Anyo
                                            System.out.println("");
                                            System.out.print("introduce el Anyo de las canciones que quieres buscar: ");
                                            ArrayList<Cancion> lc5 = CD.getAll();
                                            int Anyo = sc.nextInt();
                                            for(Cancion c: lc5){
                                                if(c.getAnyo() == Anyo) printCancion(c);
                                            }
                                            break;
                                        case 6: // Listar Canciones por Estilo
                                            System.out.println("");
                                            System.out.print("introduce el Estilo de las canciones que quieres buscar: ");
                                            break;
                                        default:
                                            break;
                                    }
                                    menuCancion2();
                                    option = sc.nextInt();
                                }
                                break;
                                
                            case 3: // Modificar Cancion
                                System.out.print("\n");
                                System.out.print("Id de la cancion a modificar: ");
                                int id_old = sc.nextInt();
                                //CD.delCancion(id_old);
                                System.out.print("Nuevos parametros cancion: \n");
                                addCancion(CD,sc,id);
                                break;
                            case 4: // Eliminar cancion
                                System.out.print("\n");
                                System.out.print("Borramos la cancion con id: ");
                                //CD.delCancion(sc.nextInt());
                               break;
                            case 5: // Eliminar todas las canciones
                                System.out.print("\n");
                                System.out.println("Borramos toda las canciones del sistema");
                                CD.delAllCanciones(); 
                                break;
                            case 6:// Cargar Canciones fichero
                                System.out.print("\n");
                                System.out.println("Cargamos las Canciones del fichero GestionDatos/Entrada/EntradaCanciones.txt \n");
                                String path = "GestionDatos/Entrada/EntradaCanciones.txt";
                                FileManager fm = new FileManager(path);
                                ArrayList<String> l = fm.readFile();
                                for (String line : l){
                                    String dataLine[] = line.split(":");
                                    if(CD.existsCancion(dataLine[0], dataLine[1])) {
                                        System.out.println("Ya existe una cancion con Titulo: ");
                                    }
                                    else {
                                        int nEstilos = Integer.parseInt(dataLine[4]);
                                        Set<String> Estilos = new HashSet<>();
                                        for(int i = 1; i <= nEstilos; ++i){
                                            Estilos.add(dataLine[4+i]);
                                        }
                                        ++id;
                                        CD.addCancion(dataLine[0],dataLine[1],dataLine[2],
                                                      Integer.parseInt(dataLine[3]),Estilos);
                                    }
                                }
                                
                                break;
                            case 7:
                                System.out.print("\n");
                                System.out.println("Guardamos las Canciones del fichero GestionDatos/Entrada/SalidaCanciones.txt\n");
                                String path2 = "GestionDatos/Entrada/SalidaCanciones.txt";
                                FileManager fm2 = new FileManager(path2);
                                ArrayList<String> l2 = new ArrayList<>();
                                ArrayList<Cancion> lc2 = CD.getAll();
                                String linia;
                                for(Cancion c: lc2){
                                    Set<String> Estilos = c.getEstilo();
                                    linia = c.getTitulo()+":"+c.getAutor()+":"+c.getAlbum()+":"+c.getAnyo()+":"+c.getEstilo().size();
                                    for(String s : Estilos){
                                        linia += ":"+s;
                                    }
                                    l2.add(linia);
                                    linia = new String();
                                }
                                fm2.writeFile(l2);
                                break;
                            default:
                                break;
                        }
                        System.out.print("\n");
                    }
                    break;
                case 2:
                    int opu = -1;
                    while(opu != 0) {
                        menuUsuario();
                        opu = sc.nextInt();
                        switch (opu) {
                            case 1: // Añadir usuario y con sus escuchas
                                System.out.print("\n");
                                System.out.print("Nombre usuario: " );
                                String user_nombre = sc.next();
                                System.out.print("Numero de canciones escuchadas por el usuario: " );
                                int n_escu = sc.nextInt();
                                System.out.print("Introduce los Ids de las canciones: " );
                                Set<Integer> escuchas = new HashSet<>();
                                for(int i = n_escu; i > 0; --i){
                                    escuchas.add(sc.nextInt());
                                }
                                CD.addUsuario(user_nombre, escuchas);
                                break;
                            case 2: // Listar usuarios
                                System.out.println("");
                                System.out.print("Todas los usuarios del sistema son: \n");
                                ArrayList<String> ls = CD.getNombreUsuarios();
                                for(String s : ls){
                                    System.out.print("Nombre: "+s+"\n");
                                    System.out.print("Escuchas: ");
                                    System.out.println(CD.getEscuchaUsuario(s));
                                }
                                break;
                            case 3: // Modificar usuario
                                System.out.print("\n");
                                System.out.print("Nombre usuario a modificar: " );
                                String nm = sc.next();
                                System.out.print("Nuevo Nombre: " );
                                String nn = sc.next();
                                System.out.print("Numero de canciones escuchadas por el usuario: " );
                                int nn_escu = sc.nextInt();
                                System.out.print("Introduce los Ids de las canciones: " );
                                Set<Integer> nn_escuchas = new HashSet<>();
                                for(int i = nn_escu; i > 0; --i){
                                    nn_escuchas.add(sc.nextInt());
                                }
                                CD.modUsuario(nm, nn, nn_escuchas);
                                break;
                            case 4:
                                System.out.print("\n");
                                System.out.print("Nombre usuario a eliminar: " );
                                CD.delUsuario(sc.next());
                                break;
                            case 5:
                                System.out.println("Borramos todos los usuarios del sistema");
                                CD.delAllUsuarios();
                                break;
                            case 6:// Cargar Usuarios fichero
                                System.out.print("\n");
                                System.out.println("Cargamos los Usuarios y las Escuchas del fichero GestionDatos/Entrada/EntradaUsuarios.txt");
                                String path = "GestionDatos/Entrada/EntradaUsuarios.txt";
                                FileManager fm = new FileManager(path);
                                ArrayList<String> l = fm.readFile();
                                for (String line : l){
                                    String dataLine[] = line.split(":");
                                    int nEscuchas = Integer.parseInt(dataLine[1]);
                                    Set<Integer> Escuchas = new HashSet<>();
                                    for(int i = 1; i <= nEscuchas; ++i){
                                        Escuchas.add(Integer.parseInt(dataLine[1+i]));
                                    }
                                    CD.addUsuario(dataLine[0],Escuchas);
                                }
                                
                                break;
                            case 7: //Guardamos los Usuarios fichero
                                System.out.print("\n");
                                System.out.println("Guardamos los Usuarios al fichero fichero GestionDatos/Entrada/SalidaUsuarios.txt");
                                String path2 = "GestionDatos/Entrada/SalidaUsuarios.txt";
                                FileManager fm2 = new FileManager(path2);
                                ArrayList<String> l2 = new ArrayList<>();
                                ArrayList<String> nameUsuarios= CD.getNombreUsuarios();
                                String linia;
                                for(String s: nameUsuarios){
                                    ArrayList<Integer> idEscuchas = CD.getEscuchaUsuario(s);
                                    linia = s+":"+idEscuchas.size();
                                    for(int idE : idEscuchas){
                                        linia += ":"+idE;
                                    }
                                    l2.add(linia);
                                    linia = new String();
                                }
                                fm2.writeFile(l2);
                                break;
                                
                            default:
                                break;
                        }
                        System.out.print("\n");
                    }
                    break;
                case 3:
                    int opcom = -1;
                    while(opcom != 0) {
                        menuComunidad();
                        opcom = sc.nextInt();
                        switch (opcom) {
                            case 1: // Crear Comunidad 
                                System.out.print("\n");
                                System.out.print("Nombre del Cjto_Comunidades: " );
                                String ncom = sc.next();
                                System.out.print("Numero de Criterios: " );
                                int numc = sc.nextInt();
                                System.out.print("Introduce los criterios por prioridad con su valor: " );
                                ArrayList<ArrayList<String>> ls = new ArrayList<>();
                                for(int i = numc; i > 0; --i){
                                    ArrayList<String> c = new ArrayList<>();
                                    c.add(sc.next());
                                    c.add(sc.next());
                                    ls.add(c);
                                }
                                CD.newCjtoComunidad(ncom, ls);
                                break;
                                
                            case 2: // Ver nombre
                                System.out.print("\n");
                                System.out.println(CD.getNomComunidades());                                
                                break;
                                
                            case 3: // Ver Criterios
                                System.out.print("\n");
                                System.out.println("Criterios de la Comunidad:");
                                ArrayList<ArrayList<String>> crit = CD.getCriterios();
                                for(ArrayList<String> al : crit){
                                    System.out.println(al);
                                }
                                break;
                                
                            case 4: // Print Graph
                                System.out.print("\n");
                                Graph<Integer,Double> g = CD.getGraphComunidad();
                                System.out.println("GRAFO GENERADO");
                                System.out.println("Vertices:");
                                ArrayList<Integer> v = g.getVertexs();
                                System.out.println(v);
                                System.out.println("Aristas:");
                                for(Integer it : v){
                                    HashMap<Integer,Double> al = g.getEdges(it);
                                    Set<Integer> als = al.keySet();
                                    for(int alit : als){
                                        System.out.print("Origen: "+ v.get(it) +" Destino: "+ alit + " Valor: "+ al.get(alit) + "\n");
                                    }
                                }
                                System.out.println("");
                                break;
                                
                            case 5: // Modificar Cjto_Comunidad
                                System.out.print("\n");
                                System.out.print("Nuevo nombre del Cjto_Comunidades: ");
                                String ncom2 = sc.next();
                                System.out.print("Numero de nuevos Criterios: ");
                                int numc2 = sc.nextInt();
                                System.out.print("Introduce los criterios por prioridad con su valor: " );
                                ArrayList<ArrayList<String>> ls2 = new ArrayList<>();
                                for(int i = numc2; i > 0; --i){
                                    ArrayList<String> c = new ArrayList<>();
                                    c.add(sc.next());
                                    c.add(sc.next());
                                    ls2.add(c);
                                }
                                CD.newCjtoComunidad(ncom2, ls2); 
                                break;
                                
                            case 6: // Ver Comunidades
                                System.out.print("\n");
                                ArrayList<ArrayList<Integer>> res = CD.getRes();
                                if(res.isEmpty()){
                                    System.out.print("No existen Comunidades\n");
                                }
                                else{
                                    int count_print = 0;
                                    for (ArrayList<Integer> aux : res) {
                                        System.out.print("Comunidad "+count_print+": ");
                                        System.out.println(aux);
                                        count_print++;
                                    }
                                }
                                break;
                                
                            case 7: // Añadir elemento a una Comunidad
                                System.out.print("\n");
                                System.out.print("Nombre de la Cancion: ");
                                int nc = sc.nextInt();
                                System.out.print("Numero de la Comunidad Destino: ");
                                int numcom = sc.nextInt();
                                if(!CD.getRes().isEmpty()) CD.addComunidad(numcom, nc);
                                else System.out.print("No existen Comunidades\n");
                                break;
                                
                            case 8: // Eliminar un elemento de una Comunidad
                                System.out.print("\n");
                                System.out.print("Nombre de la Cancion: ");
                                int nc2 = sc.nextInt();
                                System.out.print("Numero de la Comunidad Destino: ");
                                int numcom2 = sc.nextInt();
                                if(!CD.getRes().isEmpty()) CD.delComunidad(numcom2, nc2);
                                else System.out.print("No existen Comunidades\n");
                                break;
                                
                            case 9:
                                /*System.out.print("\n");
                                System.out.println("Cargamos las Comunidades del fichero GestionDatos/Entrada/EntradaComunidades.txt");
                                String path = "GestionDatos/Entrada/EntradaComunidades.txt";
                                FileManager fm = new FileManager(path);
                                ArrayList<String> l = fm.readFile();
                                for (String line : l){
                                    String dataLine[] = line.split(":");
                                    int nCom = Integer.parseInt(dataLine[1]);
                                    List<String> Comunidades = new ArrayList<>();
                                    for(int i = 1; i <= nCom; ++i){
                                        Comunidades.add(dataLine[1+i]);
                                    }
                                    CD.addComunidad(dataLine[0],Comunidades);
                                }
                                break;*/
                            case 10:
                                System.out.print("\n");
                                System.out.println("Guardamos las Comunidades en el fichero GestionDatos/Entrada/SalidaComunidades.txt");
                                String path2 = "GestionDatos/Entrada/SalidaComunidades.txt";
                                FileManager fm2 = new FileManager(path2);
                                ArrayList<String> pr = new ArrayList<>();
                                pr.add(CD.getPrintComunidades());
                                fm2.writeFile(pr);
                                break;
                            default:
                                break;
                        }
                        System.out.print("\n");
                    }
                    break;
                case 4: // Algoritmos
                    int opal = -1;
                    while(opal != 0) {
                        menuAlgoritmos();
                        opal = sc.nextInt();
                        switch (opal) {
                            case 1: // Clique
                                System.out.print("\n");
                                System.out.print("Porcentaje: ");
                                //ArrayList<ArrayList<Integer>> res = CD.calcClique(sc.nextInt());
                                ArrayList<ArrayList<Integer>> res = new ArrayList<>();
                                Integer cont = 0;
                                for(ArrayList<Integer> ali : res){
                                    System.out.print("Conjunto "+cont+": ");
                                    System.out.println(ali);
                                    ++cont;
                                }
                                System.out.print("\n");
                                break;
                            case 2: // Newman
                                System.out.print("\n");
                                System.out.println("No disponible :( \n");
                                break;
                            case 3: // Louvain
                                System.out.print("\n");
                                System.out.println("No disponible :( \n");
                                break;
                            case 4:
                                System.out.print("\n");
                                ArrayList<ArrayList<Integer>> res_to_print = CD.getRes();
                                int count_print = 0;
                                for (ArrayList<Integer> aux : res_to_print) {
                                        System.out.print("Comunidad "+count_print+": ");
                                        System.out.println(aux);
                                         count_print++;
                                }
                                   
                                System.out.print("\n");
                                break;
                            case 5:
                                System.out.print("\n");
                                String path2 = "GestionDatos/Entrada/SalidaAlgoritmo.txt";
                                FileManager fm2 = new FileManager(path2);
                                ArrayList<String> l2 = new ArrayList<>();
                                ArrayList<ArrayList<Integer>> res2 = CD.getRes();
                                System.out.println("Guardamos el resultado del algoritmo en GestionDatos/Entrada/SalidaAlgoritmo.txt");
                                String linia;
                                Integer cont2 = 0;
                                for(ArrayList<Integer> ali : res2){
                                    linia = "Conjunto "+cont2+": ";
                                    linia += ali;
                                    l2.add(linia);
                                    ++cont2;
                                    linia = new String();
                                }
                                fm2.writeFile(l2);
                                break;
                                
                            default:
                                break;
                        }
                    }
                    break;
                default:
                    break;
            }
            System.out.print("\n");
        }

     }

}
