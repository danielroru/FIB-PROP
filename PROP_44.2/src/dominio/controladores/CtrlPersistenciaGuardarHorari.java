package dominio.controladores;

import persistencia.JSONArray;
import persistencia.JSONObject;
import dominio.classes.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class CtrlPersistenciaGuardarHorari {

    private static CtrlPersistenciaGuardarHorari instance = new CtrlPersistenciaGuardarHorari();
    private static Map<String, Matriu> horari;

    private CtrlPersistenciaGuardarHorari() {}

    public static CtrlPersistenciaGuardarHorari getInstance() {
        return instance;
    }

    public static void guardarHorari(Map<String, Matriu> ultimHorari, String nomFitxer) {

        horari = ultimHorari;

        // Array general
        JSONArray aules = new JSONArray();

        for (String nomAula : horari.keySet()) {
            JSONObject aula = new JSONObject();

            // Afegim nova aula a l'array
            aula.put("nomAula", nomAula);
            Matriu m = horari.get(nomAula);

            JSONArray dies = new JSONArray();
            for (int i = 0; i < Enumeracio.Dia.values().length; i++) {
                JSONObject dia = new JSONObject();
                dia.put("dia", i);
                JSONArray hores = new JSONArray();
                JSONArray caselles = new JSONArray();
                for (int j = PlaEstudis.getHoraInici(); j < PlaEstudis.getHoraFi(); j++) {
                    if (m.getCasella(i,j) != null) {
                        Casella c = m.getCasella(i,j);
                        JSONObject hora = new JSONObject();
                        hora.put("hora", j);
                        hora.put("nomAssig", c.getNomAssig());
                        hora.put("numGrup", c.getNumGrup());
                        hora.put("tipus", c.getTipus().toString());
                        caselles.add(hora);
                    }
                }
                hores.add(caselles);
                dia.put("hores", caselles);
                dies.add(dia);
            }
            aula.put("dies", dies);

            // Afegim aula a l'array general
            aules.add(aula);
        }

        // try-with-resources statement based on post comment below :)

        try {
            //TODO
            FileWriter file = new FileWriter("src/presentacio/Horaris/" + nomFitxer + ".json");
            file.write(aules.toJSONString());
            System.out.println("Horari Guardat");
            //System.out.println("\nJSON Object: " + aules);
            file.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
