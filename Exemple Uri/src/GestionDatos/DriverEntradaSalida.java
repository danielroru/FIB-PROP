/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionDatos;

import java.util.*;
import java.io.*;
/**
 *
 * @author alexcuello
 */
public class DriverEntradaSalida {
    
    public static void main(String[] args) {
        System.out.println("Lectura y escriptura de fitxer");
        Scanner sc = new Scanner(System.in);
        String filename = sc.next();
        String path = "GestionDatos/Entrada/Entrada.txt";
        FileManager fm = new FileManager(path);
        ArrayList<String> l = fm.readFile();
        System.out.print(l);
        String line = l.get(0);
        String dataLine[] = line.split("#|:");
        
        // PARA ESCRIBIR EN FICHERO
        String path2 = "GestionDatos/Entrada/Salida.txt";
        FileManager fm2 = new FileManager(path2);
        String s = dataLine[0];
        l.clear();
        l.add(dataLine[1]);
        fm2.writeFile(l);
        
    }
}
