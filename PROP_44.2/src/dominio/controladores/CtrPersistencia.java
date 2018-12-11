package dominio.controladores;

import dominio.JSON.JSONArray;
import dominio.JSON.JSONObject;
import dominio.JSON.parser.JSONParser;
import dominio.JSON.parser.ParseException;
import dominio.classes.Assignatura;
import dominio.classes.PlaEstudis;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class CtrPersistencia {

    public static void carregarAssignatures(String path) {
        JSONParser parser = new JSONParser();
        try {

            JSONArray arrayAssignatures = (JSONArray) parser.parse(new FileReader(path));

            for (int i = 0; i < arrayAssignatures.size(); i++) {

                Assignatura a = new Assignatura();

                JSONObject jsonObject = (JSONObject) arrayAssignatures.get(i);

                String nom = (String) jsonObject.get("nom");
                a.setNom(nom);

                int nivell = (int) (long) jsonObject.get("nivell");
                if (nivell < 0) throw new Exception("El nivell de l'assignatura " + nom + " no pot ser inferior a 0");
                a.setNivell(nivell);

                int nHoresT = (int) (long) jsonObject.get("nHoresT");
                if (nHoresT < 0) throw new Exception("El nHoresT de l'assignatura " + nom + " no pot ser inferior a 0");
                a.setnHoresT(nHoresT);
                int nHoresL = (int) (long) jsonObject.get("nHoresL");
                if (nHoresL < 0) throw new Exception("El nHoresL de l'assignatura " + nom + " no pot ser inferior a 0");
                a.setnHoresL(nHoresL);
                int nHoresP = (int) (long) jsonObject.get("nHoresP");
                if (nHoresP < 0) throw new Exception("El nHoresP de l'assignatura " + nom + " no pot ser inferior a 0");
                a.setnHoresP(nHoresP);

                int nGrupsT = (int) (long) jsonObject.get("nGrupsT");
                if (nGrupsT < 0) throw new Exception("El nGrupsT de l'assignatura " + nom + " no pot ser inferior a 0");
                a.setnGrupsT(nGrupsT);
                int nGrupsL = (int) (long) jsonObject.get("nGrupsL");
                if (nGrupsL < 0) throw new Exception("El nGrupsL de l'assignatura " + nom + " no pot ser inferior a 0");
                if (nGrupsL > 9) throw new Exception("El nGrupsL de l'assignatura " + nom + " no pot ser superior a 9");
                a.setnGrupsL(nGrupsL);
                int nGrupsP = (int) (long) jsonObject.get("nGrupsP");
                if (nGrupsP < 0) throw new Exception("El nGrupsP de l'assignatura " + nom + " no pot ser inferior a 0");
                if (nGrupsP > 9) throw new Exception("El nGrupsP de l'assignatura " + nom + " no pot ser superior a 9");
                a.setnGrupsP(nGrupsP);

                int nGrupsMati = (int) (long) jsonObject.get("nGrupsMati");
                if (nGrupsMati < 0) throw new Exception("El nGrupsMati de l'assignatura " + nom + " no pot ser inferior a 0");
                if (nGrupsMati > nGrupsT) throw new Exception("El nGrupsMati de l'assignatura " + nom + " no pot ser superior al nGrupsT");
                a.setnGrupsMati(nGrupsMati);

                int nAlumnesT = (int) (long) jsonObject.get("nAlumnesT");
                if (nAlumnesT < 0) throw new Exception("El nAlumnesT de l'assignatura " + nom + " no pot ser inferior a 0");
                a.setnAlumnesT(nAlumnesT);
                int nAlumnesL = (int) (long) jsonObject.get("nAlumnesL");
                if (nAlumnesL < 0) throw new Exception("El nAlumnesL de l'assignatura " + nom + " no pot ser inferior a 0");
                if (nAlumnesL > nAlumnesT) throw new Exception("El nAlumnesL de l'assignatura " + nom + " no pot ser superior nAlumnesT");
                a.setnAlumnesL(nAlumnesL);
                int nAlumnesP = (int) (long) jsonObject.get("nAlumnesP");
                if (nAlumnesP < 0) throw new Exception("El nAlumnesP de l'assignatura " + nom + " no pot ser inferior a 0");
                if (nAlumnesP > nAlumnesT) throw new Exception("El nAlumnesP de l'assignatura " + nom + " no pot ser superior nAlumnesT");
                a.setnAlumnesP(nAlumnesP);

                int horesBlocT = (int) (long) jsonObject.get("horesBlocT");
                if (horesBlocT < 0) throw new Exception("El horesBlocT de l'assignatura " + nom + " no pot ser inferior a 0");
                if (horesBlocT > nHoresT) throw new Exception("El horesBlocT de l'assignatura " + nom + " no pot ser superior a nHoresT");
                a.setHoresBlocT(horesBlocT);
                int horesBlocL = (int) (long) jsonObject.get("horesBlocL");
                if (horesBlocL < 0) throw new Exception("El horesBlocL de l'assignatura " + nom + " no pot ser inferior a 0");
                if (horesBlocL > nHoresT) throw new Exception("El horesBlocL de l'assignatura " + nom + " no pot ser superior a nHoresL");
                a.setHoresBlocL(horesBlocL);
                int horesBlocP = (int) (long) jsonObject.get("horesBlocP");
                if (horesBlocP < 0) throw new Exception("El horesBlocP de l'assignatura " + nom + " no pot ser inferior a 0");
                if (horesBlocP > nHoresT) throw new Exception("El horesBlocP de l'assignatura " + nom + " no pot ser superior a nHoresP");
                a.setHoresBlocP(horesBlocP);

                JSONArray arrayCorrequisits = (JSONArray) jsonObject.get("correquisits");

                Set<String> setCore = new HashSet<>();

                for (Object co : arrayCorrequisits) {
                    String assig = co.toString();
                    if (assig.equals(nom)) throw new Exception("L'assignatura " + nom + " no pot ser correquisit d'ella mateixa");
                    setCore.add(assig);
                }

                a.setCorrequisits(setCore);

                PlaEstudis.afegirAssignatura(a);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
