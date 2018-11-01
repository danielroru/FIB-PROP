package Dominio;

import GestionDatos.FileManager;
import java.util.*;
/**
 *
 * @author marc.mauri.ruiz
 */
public class DriverCliquePercolation {
    
    private static Graph<Integer,Double> grafo = new Graph<>();
    private static ArrayList< ArrayList<Integer> > conjuntos = new ArrayList<>();
    
    private static void write_graph (ArrayList< ArrayList<Integer> > g) {
        for (ArrayList<Integer> aux : g) {
            for (Integer node : aux) {
                System.out.print(node + " ");
            }
            System.out.print("\n");
        }
    }
    
    public static void main(String[] args) {
        int idmax = 0;
        
        System.out.println("\n---DRIVER CLIQUE PERCOLATION---");
        CliquePercolation cp = new CliquePercolation();
        
        int caso = -1;
        while(caso != 0){
            System.out.println("\nELIGE OPCION:");
            System.out.println("1-> Escribir grafo");
            System.out.println("2-> Cargar grafo desde fichero externo");
            System.out.println("3-> Calcular algoritmo");
            System.out.println("4-> Escribir resultado");
            System.out.println("5-> Guardar resultado algoritmo en fichero externo");
            System.out.println("6-> Salir");
            Scanner leer = new Scanner(System.in);
            caso = leer.nextInt();
            System.out.print("\n");
            switch(caso){
                case 1:
                    System.out.println("---ESCRIBIR GRAFO---\n");
                    grafo = new Graph<>();
                    System.out.print("Escribe el numero de nodos del grafo:");
                    int nodes = leer.nextInt();
                    System.out.println("Escribe el id de todos los nodos (n1 n2 ...):");
                    for (int i = 0; i < nodes; i++) {
                        int idSong = leer.nextInt();
                        grafo.addVertex(idSong);
                    }
                    System.out.print("\nEscribe el numero de aristas:");
                    int aristas = leer.nextInt();
                    System.out.println("Escribe todas las aristas siguiendo el patron "
                            + "nodo_origen nodo_destino peso\n");
                    
                    for (int i = 0; i < aristas; i++) {
                        int a = leer.nextInt();
                        int b = leer.nextInt();
                        double c = leer.nextDouble();
                        grafo.addEdge(a, b, c);
                    }
                    break;
                    
                case 2:// Cargar Grafo para Algoritmo fichero
                    System.out.print("\n");
                    System.out.println("Cargamos el grafo para el algoritmo desde GestionDatos/Entrada/EntradaCliquePercolation.txt");
                    String path = "GestionDatos/Entrada/EntradaCliquePercolation.txt";
                    FileManager fm = new FileManager(path);
                    ArrayList<String> l = fm.readFile();
                    grafo = new Graph<>();
                    int count1 = 0;
                    int nodes_llista = 0;
                    int aristas_llista = 0;
                    for (String line : l){
                        if (count1 == 0) {
                            nodes_llista = Integer.parseInt(line);
                        }
                        else if (count1 == 1) {
                            String dataLine[] = line.split(":");
                            for (int i = 0; i < nodes_llista; i++) grafo.addVertex(Integer.parseInt(dataLine[i]));
                        }
                        else {
                            String dataLine[] = line.split(":");
                            grafo.addEdge(Integer.parseInt(dataLine[0]), Integer.parseInt(dataLine[1]), Double.parseDouble(dataLine[2]));
                        }
                        count1++;
                    }

                    break;
                    
                case 3:
                    System.out.println("---CALCULAR ALGORITMO---\n");
                    System.out.println("Escribe la probabilidad P. (0 nada estricto, 100 muy estricto)'\n");
                    int p = leer.nextInt();
                    cp.setP(p);
                    cp.calc(grafo);
                    //System.out.println("Algorito calculado :D\n");
                    conjuntos = new ArrayList<>();
                    conjuntos = cp.obtain();
                    break;

                case 4:
                    System.out.println("---RESULTADO ALGORITMO---\n");
                    write_graph(conjuntos);
                    break;
                    
                case 5: //Guardamos el resultado de la ejecucion del algoritmo
                    System.out.print("\n");
                    System.out.println("Guardamos el resultado de la ejecucion del algoritmo al fichero fichero GestionDatos/Entrada/SalidaCliquePercolation.txt");
                    String path2 = "GestionDatos/Entrada/SalidaCliquePercolation.txt";
                    FileManager fm2 = new FileManager(path2);
                    ArrayList<String> l2 = new ArrayList<>();
                    String linia = new String();
                    int count2 = 0;
                    for(ArrayList<Integer> s: conjuntos){
                        if (count2 < 10) linia = "Conjunto0"+count2;
                        else linia = "Conjunto"+count2;
                        for (Integer idCancion: s) {
                            linia += ":"+idCancion;
                        }
                        l2.add(linia);
                        linia = new String();
                        count2++;
                    }
                    fm2.writeFile(l2);
                    break;

                case 6:
                    System.out.println("---GOODBYE---");
                    System.out.print("\n");
                    caso = 0;
                    break;
            }
                    
        }
                

    }
}
