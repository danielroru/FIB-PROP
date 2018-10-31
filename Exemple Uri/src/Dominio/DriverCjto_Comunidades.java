/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import GestionDatos.FileManager;
import java.util.*;

/**
 *
 * @author carlos.piris
 */
public class DriverCjto_Comunidades {
    
    public static void menu() {
        System.out.print("OPCIONES\n"
                + " 0 Quit \n"
                + " 1 Ver nombre Comunidad \n"
                + " 2 Ver Criterios \n"
                + " 3 Ver el grafo de una Comunidad \n"
                + " 4 Calcular resultados \n"
                + " 5 Ver resultados \n"
                + " 6 Añadir un elemento a una Comunidad \n"
                + " 7 Eliminad un elemento de una Comunidad \n");
    }
    
    public static void cargarDatos(Cjto_Comunidades cco, Scanner sc){
        
        Cjto_Canciones cc = new Cjto_Canciones(); // Creamos un cjto de canciones
        int id = 0;
        Cjto_Escuchas ce = new Cjto_Escuchas();
        int cont = 0;
        Cjto_Usuarios cu = new Cjto_Usuarios();
        
        String path = "GestionDatos/Entrada/EntradaCanciones.txt";
        /*FileManager fm = new FileManager(path);
        ArrayList<String> l = fm.readFile();
        for (String line : l){
            String dataLine[] = line.split(":");
            int nEstilos = Integer.parseInt(dataLine[4]);
            Set<String> Estilos = new HashSet<>();
            for(int i = 1; i <= nEstilos; ++i){
                Estilos.add(dataLine[5+i]);
            }
            Cancion c = new Cancion(Integer.parseInt(dataLine[0]),dataLine[1],dataLine[2],dataLine[3],
                          Integer.parseInt(dataLine[4]),Estilos);
            cc.addCancion(c);
        }*/
        FileManager fm = new FileManager(path);
        ArrayList<String> l = fm.readFile();
        for (String line : l){
            String dataLine[] = line.split(":");
            if(cc.existsCancion(dataLine[0], dataLine[1])) {
                System.out.println("Ya existe una cancion con Titulo: ");
            }
            else {
                int nEstilos = Integer.parseInt(dataLine[4]);
                Set<String> Estilos = new HashSet<>();
                for(int i = 1; i <= nEstilos; ++i){
                    Estilos.add(dataLine[4+i]);
                }
                Cancion c = new Cancion(id,dataLine[0],dataLine[1],dataLine[2],Integer.parseInt(dataLine[3]),Estilos);
                cc.addCancion(c);
                ++id;
            }
        }
        path = "GestionDatos/Entrada/EntradaUsuarios.txt";
        fm = new FileManager(path);
        l = fm.readFile();
        
        for (String line : l){
            String dataLine[] = line.split(":");
            Set<Integer> S = new HashSet<>();
            String usuario = dataLine[0];
                int numCan = Integer.parseInt(dataLine[1]);
                for(int i = 0; i < 2*numCan; i+=2){
                    String tit = dataLine[2+i];
                    String aut = dataLine[3+i];
                    if(cc.existsCancion(tit, aut)) {
                        int idCan = cc.retCancion(tit, aut).getId();
                        S.add(idCan);
                    } 
                }
                Escucha e = new Escucha(cont, S);
                Usuario u = new Usuario(usuario, cont);
                ++cont;
                ce.addEscucha(e);
                cu.addUsuario(u);
        }
        for( Escucha e: ce.getAllEscuchas()){
             System.out.print(e.getListCanciones());
        }
        ArrayList<ArrayList<String>> crit = new ArrayList<>();
        System.out.print("Numero de criterios?, introducelos por prioridad y con su peso: ");
        for(int i = sc.nextInt(); i > 0; --i){
            ArrayList<String> c = new ArrayList<>();
            c.add(sc.next());
            c.add(sc.next());
            crit.add(c);
        }
        cco.setCriterios(crit);
        cco.genGraph(cc, ce, cu.getAllUsuarios().size());
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Habilitamos la entrada
        int option = -1;
        System.out.print("\n");
        System.out.print("Nombre del Conjunto de Comunidades: ");
        Cjto_Comunidades cco = new Cjto_Comunidades(sc.next()); // Creamos un cjto de Comunidades
        cargarDatos(cco, sc);
        System.out.println("Se cargan automaticamente los archivos de entrada de Canciones y Usuarios \n");
        while (option != 0) {
            menu();
            option = sc.nextInt(); // Leemos la opcion a realizar
            switch (option) {
                case 1: // Ver nombre Cjto_Comunidades
                    System.out.println(cco.getId());
                    break;
                
                case 2: // Ver criterios
                    System.out.println("Criterios de la Comunidad:");
                    List<ArrayList<String>> crit = cco.getCriterios();
                    for(ArrayList<String> al : crit){
                        System.out.println(al);
                    }
                    break;
                case 3: // Ver grafo
                    System.out.print("\n");
                    Graph<Integer, Double> g = cco.getGraph();
                    ArrayList<Integer> v = g.getVertexs();
                    System.out.println("Vertices del Grafo: ");
                    System.out.println(v);
                    System.out.println("Aristas del Grafo: ");
                    for(Integer it : v){
                        HashMap<Integer,Double> al = g.getEdges(it);
                        Set<Integer> als = al.keySet();
                        for(int alit : als){
                            System.out.print("Origen: "+ (v.get(it)+1) +" Destino: "+ (alit+1) + " Valor: "+ al.get(alit) + "\n");
                        }
                    }
                    break;
                    
                case 4: // Calcular resultados
                    /*CliquePercolation cp = new CliquePercolation();
                    System.out.print("Introduzca el Porcentaje: ");
                    cp.setP(sc.nextInt());
                    cp.calc(cco.getGraph());
                    cco.setResult(cp.obtain());*/
                    Louvain l = new Louvain();
                    System.out.print("Introduzca el Porcentaje: ");
                    l.setP(sc.nextInt());
                    l.calc(cco.getGraph());
                    cco.setResult(l.obtain());
                    int cont = 0;
                    for(ArrayList<Integer> co : cco.getResult()){
                        System.out.print("Comunidad "+cont+": ");
                        System.out.println(co);
                        ++cont;
                    }
                    System.out.print("\n");
                    break;
                    
                case 5: // Ver Comunidades
                    int cont2 = 0;
                    for(ArrayList<Integer> co : cco.getResult()){
                        System.out.print("Comunidad "+cont2+": ");
                        System.out.println(co);
                        ++cont2;
                    }
                    System.out.print("\n");
                    break;
                    
                case 6: // Añadir elemento a una Comunidad
                    System.out.print("\n");
                    System.out.print("Id del elemento a anadir: ");
                    int n = sc.nextInt();
                    System.out.print("Comunidad destino: ");
                    int dest = sc.nextInt();
                    cco.addResult(dest, n);
                    System.out.print("\n"); 
                    break;
                    
                case 7: // Eliminar elemento de una comunidad
                    System.out.print("\n");
                    System.out.print("Id del elemento a eliminar: " );
                    int n2 = sc.nextInt();
                    System.out.print("Comunidad destino: ");
                    int dest2 = sc.nextInt();
                    cco.delResult(dest2, n2);
                    break;
               
                    
                default:
                    break;

            }
            System.out.println("\n");
        }
    }
}
