package dominio.controladores;

import dominio.JSON.JSONArray;
import dominio.JSON.JSONObject;
import dominio.JSON.parser.JSONParser;
import dominio.JSON.parser.ParseException;
import dominio.classes.*;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CtrlPersistenciaCarregarHorari {

    private static CtrlPersistenciaCarregarHorari instance = new CtrlPersistenciaCarregarHorari();

    private CtrlPersistenciaCarregarHorari() {}

    public static CtrlPersistenciaCarregarHorari getInstance() {
        return instance;
    }

    public static Map<String, Matriu> llegirHorari(String nomfitxer) {
        Map<String, Matriu> horari = new HashMap<>();

        JSONParser parser = new JSONParser();

        try {
            //TODO
            JSONArray arrayAules = (JSONArray) parser.parse(new FileReader("src/persistencia/Horaris/" + nomfitxer + ".json"));

            for (int z = 0; z < arrayAules.size(); z++) {

                Matriu m = new Matriu();

                JSONObject jsonAula = (JSONObject) arrayAules.get(z);

                JSONArray jsonDies = (JSONArray) jsonAula.get("dies");

                for (int i = 0; i < jsonDies.size(); i++) {
                    JSONObject jsonDia = (JSONObject) jsonDies.get(i);
                    JSONArray jsonHores = (JSONArray) jsonDia.get("hores");

                    for (int j = 0; j < jsonHores.size(); j++){
                        if (jsonHores != null) {
                            JSONObject jsonCasella = (JSONObject) jsonHores.get(j);
                            int numeroGrup = (int) (long) jsonCasella.get("numGrup");
                            String nomAssig = (String) jsonCasella.get("nomAssig");
                            String tipus = (String) jsonCasella.get("tipus");

                            Enumeracio.TipusSessio tipusS = Enumeracio.TipusSessio.TEORIA;

                            switch (tipus) {
                                case "TEORIA" :
                                    tipusS = Enumeracio.TipusSessio.TEORIA;
                                    break;
                                case "LABORATORI" :
                                    tipusS = Enumeracio.TipusSessio.LABORATORI;
                                    break;
                                case "PROBLEMES" :
                                    tipusS = Enumeracio.TipusSessio.PROBLEMES;
                                    break;
                            }
                            Casella cas = new Casella();
                            cas.setNumGrup(numeroGrup);
                            cas.setNomAssig(nomAssig);
                            cas.setTipus(tipusS);
                            int hora = (int) (long) jsonCasella.get("hora");
                            m.assignarCasella(i,hora,cas);

                        }

                    }
                }
                String nomAula = (String) jsonAula.get("nomAula");
                horari.put(nomAula,m);
            }


        } catch (FileNotFoundException e) {
            System.out.println("    ERROR: No existeix el fitxer que demanes");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return horari;
    }

}
