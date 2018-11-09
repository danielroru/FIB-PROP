package Dominio;

import java.io.FileNotFoundException;
import java.io.FileReader;

import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;


import JSON.JSONArray;
import JSON.JSONObject;
import JSON.parser.JSONParser;
import JSON.parser.ParseException;


public class Main {

    /////////////////////////////////////////////////////////////////
    /// GENERAR HORARI
    /////////////////////////////////////////////////////////////////

    private void menuGenerarHorari() {
        Scanner scanner = new Scanner(System.in);
        boolean on = true;
        int accio;

        while (on) {
            accio = scanner.nextInt();
            switch (accio) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    on = false;
                    break;
                default:
                    escriureError(1);
                    break;
            }
        }
    }

    private static void generarHorari () {

    }

    private static void mostrarHorari () {

    }


    private static void escriureMenuPrincipal() {
        System.out.println("");
        System.out.println("1] Gestió Configuració");
        System.out.println("2] Generar Horari");
        System.out.println("3] Gestió Pla d'Estudis");
        System.out.println("0] Sortir de l'aplicació");
    }

    private static void escriureError(int nError) {
        switch (nError){
            case 1:
                System.out.println("Error: Indica una de les opcions!");
                break;
        }
    }

    public static void main(String[] args) {
        JSONParser parser = new JSONParser();

        try {
            JSONArray arrayAules = (JSONArray) parser.parse(new FileReader("./src/Dades/aules.json"));

            for (int i = 0; i < arrayAules.size(); i++) {
                JSONObject jsonObject = (JSONObject) arrayAules.get(i);

                String id = (String) jsonObject.get("id");
                System.out.println("id: " + id);

                Integer capacitat = (int) (long) jsonObject.get("capacitat");
                System.out.println("capacitat: " + capacitat);

                String tipus = (String) jsonObject.get("tipus");
                System.out.println("tipus: " + tipus);

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}
