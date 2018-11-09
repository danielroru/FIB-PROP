package Dominio;

import java.io.FileNotFoundException;
import java.io.FileReader;

import java.io.IOException;
import java.util.Scanner;

import JSON.JSONArray;
import JSON.JSONObject;
import JSON.parser.JSONParser;
import JSON.parser.ParseException;



public class Main {

    /////////////////////////////////////////////////////////////////
    /// GENERAR HORARI
    /////////////////////////////////////////////////////////////////

    private static void menuPrincipal() throws Exception {

        inout io = new inout();

        int accio = -1;

        while (accio != 0) {
            escriureMenuPrincipal();
            accio = io.readint();
            switch (accio) {
                case 1:
                    generarHorari();
                    break;
                case 2:
                    mostrarHorari();
                    break;
                default:
                    break;
            }
        }
    }

    private static void generarHorari () {

    }

    private static void mostrarHorari () {

    }


    private static void escriureMenuPrincipal() {
        System.out.println("////////////////////////////////");
        System.out.println("//  Menú principal");
        System.out.println("////////////////////////////////");
        System.out.println("");
        System.out.println("1] Generar Horari");
        System.out.println("2] Mostrar Horari");
        System.out.println("0] Sortir de l'aplicació");
    }

    private static void escriureError(int nError) {
        switch (nError){
            case 1:
                System.out.println("Error: Indica una de les opcions!");
                break;
        }
    }

    public static void main(String[] args) throws Exception {

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


                Enumeracio.TipusAula tAula = tipus.equals("TEORIA") ? Enumeracio.TipusAula.TEORIA : Enumeracio.TipusAula.LABORATORI;

                a.setId(id);
                a.setCapacitat(capacitat);
                a.setTipus(tAula);

                pe.afegirAula(a);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }


        try {


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

                a.setHoresBlocT((int) (long) jsonObject.get("horesBlocT"));
                a.setHoresBlocL((int) (long) jsonObject.get("horesBlocL"));
                a.setHoresBlocP((int) (long) jsonObject.get("horesBlocP"));

                pe.afegirAssignatura(a);

            }


        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (ParseException e) {
            e.printStackTrace();
        }

        try {

            JSONObject ObjectPlaEstudis = (JSONObject) parser.parse(new FileReader("./src/Dades/plaestudis.json"));

            pe.setHoraInici((int) (long) ObjectPlaEstudis.get("horaInici"));
            pe.setHoraFi((int) (long) ObjectPlaEstudis.get("horaFi"));
            pe.setHoraCanviFranja((int) (long) ObjectPlaEstudis.get("horaCanviFranja"));

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (ParseException e) {
            e.printStackTrace();
        }

        menuPrincipal();
    }
}
