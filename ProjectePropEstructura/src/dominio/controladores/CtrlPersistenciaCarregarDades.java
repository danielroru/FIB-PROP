package dominio.controladores;

import dominio.JSON.JSONArray;
import dominio.JSON.JSONObject;
import dominio.JSON.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class CtrlPersistenciaCarregarDades {

    private static CtrlPersistenciaCarregarDades instance = new CtrlPersistenciaCarregarDades();


    private CtrlPersistenciaCarregarDades() {}

    public static CtrlPersistenciaCarregarDades getInstance() {
        return instance;
    }

    // Conjunt d'Aules [ Matriu de String ]

    // aules[x][0] = id
    // aules[x][1] = capacitat
    // aules[x][2] = tipus

    public static String[][] carregarAules(){
        String[][] aules = null;
        // Aquí posem 1 per defecte - 'hi ha d'anar folder'
        String dataPath = "src/persistencia/dades/" + 1 + "/";
        JSONParser parser = new JSONParser();

        try {
            JSONArray arrayAules = (JSONArray) parser.parse(new FileReader(dataPath + "aules.json"));
            aules = new String[arrayAules.size()][3];
            for (int i = 0; i < arrayAules.size(); i++) {

                JSONObject jsonObject = (JSONObject) arrayAules.get(i);

                aules[i][0] = (String) jsonObject.get("id");
                aules[i][1] = String.valueOf((int) (long) jsonObject.get("capacitat"));
                aules[i][2] = (String) jsonObject.get("tipus");

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return aules;

    }

    ///////////////////////////////////////
    // Problema amb correquisits         //
    // (de moment no hi ha correquisits) //
    ///////////////////////////////////////

    // Conjunt d'Assignatures [ Matriu de String ]

    // [+] Tenc 2 Pregunts:
    // [·] Correquisits
    // [·] En Borja va dir que hi havia molts atributs dins sa classe,
    // feim una altra classe?

    // assignatures[x][0] = nom
    // assignatures[x][1] = nivell
    // assignatures[x][2] = nHoresT
    // assignatures[x][3] = nHoresL
    // assignatures[x][4] = nHoresP
    // assignatures[x][5] = nGrupsT
    // assignatures[x][6] = nGrupsL
    // assignatures[x][7] = nGrupsP
    // assignatures[x][8] = nGrupsMati
    // assignatures[x][9] = nAlumnesT
    // assignatures[x][10] = nAlumnesL
    // assignatures[x][11] = nAlumnesP
    // assignatures[x][12] = horesBlocT
    // assignatures[x][13] = horesBlocL
    // assignatures[x][14] = horesBlocP

    public static String[][] carregarAssignatures() {

        String[][] assignatures = null;

        // Aquí posem 1 per defecte - 'hi ha d'anar folder'
        String dataPath = "src/persistencia/dades/" + 1 + "/";
        JSONParser parser = new JSONParser();

        try {
            JSONArray arrayAssignatures = (JSONArray) parser.parse(new FileReader(dataPath + "assignatures.json"));
            assignatures = new String[arrayAssignatures.size()][15];

            for (int i = 0; i < arrayAssignatures.size(); i++) {


                JSONObject jsonObject = (JSONObject) arrayAssignatures.get(i);

                assignatures[i][0] = (String) jsonObject.get("nom");
                assignatures[i][1] = String.valueOf((int) (long) jsonObject.get("nivell"));

                assignatures[i][2] = String.valueOf((int) (long) jsonObject.get("nHoresT"));
                assignatures[i][3] = String.valueOf((int) (long) jsonObject.get("nHoresL"));
                assignatures[i][4] = String.valueOf((int) (long) jsonObject.get("nHoresP"));

                assignatures[i][5] = String.valueOf((int) (long) jsonObject.get("nGrupsT"));
                assignatures[i][6] = String.valueOf((int) (long) jsonObject.get("nGrupsL"));
                assignatures[i][7] = String.valueOf((int) (long) jsonObject.get("nGrupsP"));

                assignatures[i][8] = String.valueOf((int) (long) jsonObject.get("nGrupsMati"));

                assignatures[i][9] = String.valueOf((int) (long) jsonObject.get("nAlumnesT"));
                assignatures[i][10] = String.valueOf((int) (long) jsonObject.get("nAlumnesL"));
                assignatures[i][11] = String.valueOf((int) (long) jsonObject.get("nAlumnesP"));

                assignatures[i][12] = String.valueOf((int) (long) jsonObject.get("horesBlocT"));
                assignatures[i][13] = String.valueOf((int) (long) jsonObject.get("horesBlocL"));
                assignatures[i][14] = String.valueOf((int) (long) jsonObject.get("horesBlocP"));

                /*
                Com fer lu dels correquisits ¿?

                for (int j = 0; j < jsonObject.size(); j++) {
                    // Com llegir varis correquisits ¿?¿?
                    assignatures[i][j] = (String) jsonObject.get("correquisits");
                }
                */
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }


        return assignatures;

    }


    // plaEstudis[0] = horaInici
    // plaEstudis[1] = horaFi
    // plaEstudis[2] = horaCanviFranja

    public static String[] carregarPlaEstudis(){

        String[] plaEstudis = new String[3];

        // Aquí posem 1 per defecte - 'hi ha d'anar folder'
        String dataPath = "src/persistencia/dades/" + 1 + "/";

        JSONParser parser = new JSONParser();
        try {
            JSONObject plaEstudisOjbect = (JSONObject) parser.parse(new FileReader(dataPath + "plaEstudis.json"));

            plaEstudis[0] = String.valueOf((int) (long) plaEstudisOjbect.get("horaInici"));
            plaEstudis[1] = String.valueOf((int) (long) plaEstudisOjbect.get("horaFi"));
            plaEstudis[2] = String.valueOf((int) (long) plaEstudisOjbect.get("horaCanviFranja"));

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return plaEstudis;

    }
}
