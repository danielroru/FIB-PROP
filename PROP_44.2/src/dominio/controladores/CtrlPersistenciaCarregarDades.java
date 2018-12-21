package dominio.controladores;

import persistencia.JSONArray;
import persistencia.JSONObject;
import persistencia.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

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

    public static String[][] carregarAules(String dataPath){
        String[][] aules = null;

        JSONParser parser = new JSONParser();

        try {
            JSONArray arrayAules = (JSONArray) parser.parse(new FileReader(dataPath));
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

    public static ArrayList<ArrayList<String>> carregarAssignatures(String dataPath) {

        ArrayList<ArrayList<String>> assignatures = new ArrayList<ArrayList<String>>();

        JSONParser parser = new JSONParser();

        try {

            ArrayList<String> assignatura = new ArrayList<>();
            JSONArray arrayAssignatures = (JSONArray) parser.parse(new FileReader(dataPath));

            for (int i = 0; i < arrayAssignatures.size(); i++) {


                JSONObject jsonObject = (JSONObject) arrayAssignatures.get(i);

                assignatura.add((String) jsonObject.get("nom"));

                assignatura.add(String.valueOf((int) (long) jsonObject.get("nivell")));

                assignatura.add(String.valueOf((int) (long) jsonObject.get("nHoresT")));
                assignatura.add(String.valueOf((int) (long) jsonObject.get("nHoresL")));
                assignatura.add(String.valueOf((int) (long) jsonObject.get("nHoresP")));

                assignatura.add(String.valueOf((int) (long) jsonObject.get("nGrupsT")));
                assignatura.add(String.valueOf((int) (long) jsonObject.get("nGrupsL")));
                assignatura.add(String.valueOf((int) (long) jsonObject.get("nGrupsP")));

                assignatura.add(String.valueOf((int) (long) jsonObject.get("nGrupsMati")));

                assignatura.add(String.valueOf((int) (long) jsonObject.get("nAlumnesT")));
                assignatura.add(String.valueOf((int) (long) jsonObject.get("nAlumnesL")));
                assignatura.add(String.valueOf((int) (long) jsonObject.get("nAlumnesP")));

                assignatura.add(String.valueOf((int) (long) jsonObject.get("horesBlocT")));
                assignatura.add(String.valueOf((int) (long) jsonObject.get("horesBlocL")));
                assignatura.add(String.valueOf((int) (long) jsonObject.get("horesBlocP")));

                // Assignem els correquisits
                JSONArray arrayCorrequisits = (JSONArray) jsonObject.get("correquisits");

                for (Object co : arrayCorrequisits) {
                    String assig = co.toString();
                    assignatura.add(assig);
                }

                assignatures.add(assignatura);
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

    public static String[] carregarPlaEstudis(String dataPath){

        String[] plaEstudis = new String[3];

        JSONParser parser = new JSONParser();
        try {
            JSONObject plaEstudisOjbect = (JSONObject) parser.parse(new FileReader(dataPath));

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
