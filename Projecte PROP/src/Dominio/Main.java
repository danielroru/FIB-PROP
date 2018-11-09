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

        PlaEstudis pe = new PlaEstudis();

        JSONParser parser = new JSONParser();


        try {
            JSONArray arrayAules = (JSONArray) parser.parse(new FileReader("./src/Dades/aules.json"));

            for (int i = 0; i < arrayAules.size(); i++) {

                Aula a = new Aula();

                JSONObject jsonObject = (JSONObject) arrayAules.get(i);

                String id = (String) jsonObject.get("id");
                Integer capacitat = (int) (long) jsonObject.get("capacitat");
                String tipus = (String) jsonObject.get("tipus");

                Enumeracio.TipusAula tAula = tipus == "TEORIA" ? Enumeracio.TipusAula.TEORIA : Enumeracio.TipusAula.LABORATORI;

                a.setId(id);
                a.setCapacitat(capacitat);
                a.setTipus(tAula);

                pe.afegirAula(a);

            }

            JSONArray arrayAssignatures = (JSONArray) parser.parse(new FileReader("./src/Dades/assignatures.json"));

            for (int i = 0; i < arrayAssignatures.size(); i++) {

                Assignatura a = new Assignatura();

                JSONObject jsonObject = (JSONObject) arrayAssignatures.get(i);

                a.setNom((String) jsonObject.get("nom"));

                a.setNivell((int) (long) jsonObject.get("nivell"));

                a.setnHoresT((int) (long) jsonObject.get("nHoresT"));
                a.setnHoresL((int) (long) jsonObject.get("nHoresL"));
                a.setnHoresP((int) (long) jsonObject.get("nHoresP"));

                a.setnGrupsT((int) (long) jsonObject.get("nGrupsT"));
                a.setnGrupsL((int) (long) jsonObject.get("nGrupsL"));
                a.setnGrupsP((int) (long) jsonObject.get("nGrupsP"));


                a.setnGrupsMati((int) (long) jsonObject.get("nGrupsMati"));
                a.setnGrupsTarda((int) (long) jsonObject.get("nGrupsTarda"));

                a.setHoresBlocT((int) (long) jsonObject.get("horesBlocT"));
                a.setHoresBlocL((int) (long) jsonObject.get("horesBlocL"));
                a.setHoresBlocP((int) (long) jsonObject.get("horesBlocP"));

                pe.afegirAssignatura(a);

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
