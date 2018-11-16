package Dominio;

import java.io.FileNotFoundException;
import java.io.FileReader;

import java.io.FileWriter;
import java.io.IOException;
import java.security.Timestamp;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import JSON.JSONArray;
import JSON.JSONObject;
import JSON.parser.JSONParser;
import JSON.parser.ParseException;



public class Main {

    private static inout io = new inout();

    /////////////////////////////////////////////////////////////////
    /// GENERAR HORARI
    /////////////////////////////////////////////////////////////////

    private static void menuGenerarHorari() throws Exception {

        int accio = -1;

        while (accio != 0) {
            escriureMenuPrincipal();
            accio = io.readint();

            switch (accio) {
                case 1:
                    carregarDades();
                    break;
                case 2:
                    CtrlDomini.generarHorari();
                    break;
                case 3:
                    CtrlDomini.guardarHorari();
                    break;
                case 4:
                    CtrlDomini.llegirHorari();
                    break;
                default:
                    break;
            }
        }

    }

    private static void carregarAules(String dataPath) {
        JSONParser parser = new JSONParser();

        try {
            JSONArray arrayAules = (JSONArray) parser.parse(new FileReader(dataPath + "aules.json"));

            for (int i = 0; i < arrayAules.size(); i++) {

                Aula a = new Aula();

                JSONObject jsonObject = (JSONObject) arrayAules.get(i);

                String id = (String) jsonObject.get("id");

                Integer capacitat = (int) (long) jsonObject.get("capacitat");
                    if (capacitat < 0) throw new Exception("La capacitat de l'aula " + id + "  no pot ser inferior a 0");

                String tipus = (String) jsonObject.get("tipus");
                    if (!tipus.equals("TEORIA") && !tipus.equals("LABORATORI")) throw new Exception("El tipus d'aula de " + id + " no és ni TEORIA ni LABORATORI");

                Enumeracio.TipusAula tAula = tipus.equals("TEORIA") ? Enumeracio.TipusAula.TEORIA : Enumeracio.TipusAula.LABORATORI;



                a.setId(id);
                a.setCapacitat(capacitat);
                a.setTipus(tAula);

                PlaEstudis.getConjuntAules().afegirAula(a);

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

    private static void carregarAssignatures(String dataPath) {
        JSONParser parser = new JSONParser();
        try {

            JSONArray arrayAssignatures = (JSONArray) parser.parse(new FileReader(dataPath + "assignatures.json"));

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

    private static void carregarPlaEstudis(String dataPath) {
        JSONParser parser = new JSONParser();
        try {
            JSONObject plaEstudisOjbect = (JSONObject) parser.parse(new FileReader(dataPath + "plaEstudis.json"));

            int horaInici = (int) (long) plaEstudisOjbect.get("horaInici");
                if (horaInici < 0) throw new Exception("L'hora d'inici no pot ser inferior a 0");
                if (horaInici > 23) throw new Exception("L'hora d'inici no pot ser superior a 23");
                PlaEstudis.setHoraInici(horaInici);

            int horaFi = (int) (long) plaEstudisOjbect.get("horaFi");
                if (horaFi < 0) throw new Exception("L'hora de fi no pot ser inferior a 0");
                if (horaFi > 23) throw new Exception("L'hora de fi no pot ser superior a 23");
                if (horaFi < horaInici) throw new Exception("L'hora d'inici no pot ser superior a l'hora fi");
                PlaEstudis.setHoraFi(horaFi);

            int horaCanviFranja = (int) (long) plaEstudisOjbect.get("horaCanviFranja");
                if (horaCanviFranja < horaInici || horaCanviFranja > horaFi) throw new Exception("L'hora de canvi de franja no està entre l'hora d'inici i la de fi");
                if (horaCanviFranja < 0) throw new Exception("L'hora no pot ser inferior a 0");
                if (horaCanviFranja > 23) throw new Exception("L'hora no pot ser superior a 23");
                PlaEstudis.setHoraCanviFranja(horaCanviFranja);
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
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void carregarDades() throws Exception {
        String dataPath = new String();
        io.writeln("- Selecciona el conjunt de dades que vols carregar");
        io.writeln("");
        String folder = new String();
        folder = io.readname();
        dataPath = "./src/Dades/" + folder + "/";

        PlaEstudis.reset();

        carregarAules(dataPath);
        carregarAssignatures(dataPath);
        carregarPlaEstudis(dataPath);
    }

    private static void escriureMenuPrincipal() throws Exception {
        io.writeln("////////////////////////////");
        io.writeln("// MENÚ PRINCIPAL");
        io.writeln("////////////////////////////");
        io.writeln("");
        io.writeln("1] Carregar Set De Dades");
        io.writeln("2] Generar Horari");
        io.writeln("3] Guardar Horari");
        io.writeln("4] Carregar Horari");
        io.writeln("0] Sortir de l'aplicació");
    }

    private void escriureError(int nError) throws Exception {
        switch (nError){
            case 1:
                io.writeln("Error: Indica una de les opcions!");
                break;
        }
    }

    public static void main(String[] args) throws Exception {

        menuGenerarHorari();
    }
}
