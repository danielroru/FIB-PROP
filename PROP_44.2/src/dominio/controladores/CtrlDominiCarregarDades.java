package dominio.controladores;


import com.google.gson.Gson;
import persistencia.parser.ParseException;
import dominio.classes.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashSet;

public class CtrlDominiCarregarDades {

    private static CtrlDominiCarregarDades instance = new CtrlDominiCarregarDades();
    private static CtrlPersistencia ctrlPersistencia = CtrlPersistencia.getInstance();

    private static PlaEstudis pE = PlaEstudis.getInstance();

    private CtrlDominiCarregarDades() {}

    public static CtrlDominiCarregarDades getInstance() {
        return instance;
    }



    // Carreguem les dades de la Controladora de Persistencia

    // Funcionalitat Principal
    //////////////////////////

    public static void carregarDadesByFolder(String path) {
        carregarAules(path + "/aules.json");
        carregarAssignatures(path + "/assignatures.json");
        carregarPlaEstudis(path + "/plaEstudis.json");

    }

    // Aules
    //////////////////////

    // aules[x][0] = id
    // aules[x][1] = capacitat
    // aules[x][2] = tipus

    public static void carregarAules(String path) {

        String[][] aules = ctrlPersistencia.carregarAules(path);

        // Comprovació Errors Aules
        try {
            for (String[] a : aules) {

                if (Integer.parseInt(a[1]) < 0)
                    throw new Exception("La capacitat de l'aula " + a[0] + "  no pot ser inferior a 0");
                if (!a[2].equals("TEORIA") && !a[2].equals("LABORATORI"))
                    throw new Exception("El tipus d'aula de " + a[0] + " no és ni TEORIA ni LABORATORI");
                Enumeracio.TipusAula tAula = a[2].equals("TEORIA") ? Enumeracio.TipusAula.TEORIA : Enumeracio.TipusAula.LABORATORI;

                // Creració de l'Aula
                Aula aula = new Aula();
                aula.setId(a[0]);
                aula.setCapacitat(Integer.parseInt(a[1]));
                aula.setTipus(tAula);


                // Afagir en el Conjunt d'Aules

                PlaEstudis.getConjuntAules().afegirAula(aula);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (Writer writer = new FileWriter("/../data/dades/proves/Output.json")) {
            Aula a = new Aula();
            a.setCapacitat(30);
            Gson gson = new Gson();
            gson.toJson(PlaEstudis.getConjuntAules(), writer);
        }

        catch (Exception e) {
            e.printStackTrace();
        }

    }


    // Assignatures
    //////////////////////

    // Comprovació Errors Assignatures

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

    public static void carregarAssignatures(String path) {

        ArrayList<ArrayList<String>> assignatures = ctrlPersistencia.carregarAssignatures(path);

        try {
            for (ArrayList<String> a : assignatures) {

                String nom = a.get(0);

                if (Integer.parseInt(a.get(1)) < 0) throw new Exception("El nivell de l'assignatura " + nom + " no pot ser inferior a 0");
                if (Integer.parseInt(a.get(2)) < 0) throw new Exception("El nHoresT de l'assignatura " + nom + " no pot ser inferior a 0");
                if (Integer.parseInt(a.get(3)) < 0) throw new Exception("El nHoresL de l'assignatura " + nom + " no pot ser inferior a 0");
                if (Integer.parseInt(a.get(4)) < 0) throw new Exception("El nHoresP de l'assignatura " + nom + " no pot ser inferior a 0");
                if (Integer.parseInt(a.get(5)) < 0) throw new Exception("El nGrupsT de l'assignatura " + nom + " no pot ser inferior a 0");
                if (Integer.parseInt(a.get(6)) < 0) throw new Exception("El nGrupsL de l'assignatura " + nom + " no pot ser inferior a 0");
                if (Integer.parseInt(a.get(6)) > 9) throw new Exception("El nGrupsL de l'assignatura " + nom + " no pot ser superior a 9");
                if (Integer.parseInt(a.get(7)) < 0) throw new Exception("El nGrupsP de l'assignatura " + nom + " no pot ser inferior a 0");
                if (Integer.parseInt(a.get(7)) > 9) throw new Exception("El nGrupsP de l'assignatura " + nom + " no pot ser superior a 9");
                if (Integer.parseInt(a.get(8)) < 0) throw new Exception("El nGrupsMati de l'assignatura " + nom + " no pot ser inferior a 0");
                if (Integer.parseInt(a.get(8)) > Integer.parseInt(a.get(5))) throw new Exception("El nGrupsMati de l'assignatura " + nom + " no pot ser superior al nGrupsT");
                if (Integer.parseInt(a.get(9)) < 0) throw new Exception("El nAlumnesT de l'assignatura " + nom + " no pot ser inferior a 0");
                if (Integer.parseInt(a.get(10)) < 0) throw new Exception("El nAlumnesL de l'assignatura " + nom + " no pot ser inferior a 0");
                if (Integer.parseInt(a.get(10)) > Integer.parseInt(a.get(9))) throw new Exception("El nAlumnesL de l'assignatura " + nom + " no pot ser superior nAlumnesT");
                if (Integer.parseInt(a.get(11)) < 0) throw new Exception("El nAlumnesP de l'assignatura " + nom + " no pot ser inferior a 0");
                if (Integer.parseInt(a.get(11)) > Integer.parseInt(a.get(9))) throw new Exception("El nAlumnesP de l'assignatura " + nom + " no pot ser superior nAlumnesT");
                if (Integer.parseInt(a.get(12)) < 0) throw new Exception("El horesBlocT de l'assignatura " + nom + " no pot ser inferior a 0");
                if (Integer.parseInt(a.get(12)) > Integer.parseInt(a.get(2))) throw new Exception("El horesBlocT de l'assignatura " + nom + " no pot ser superior a nHoresT");
                if (Integer.parseInt(a.get(13)) < 0) throw new Exception("El horesBlocL de l'assignatura " + nom + " no pot ser inferior a 0");
                if (Integer.parseInt(a.get(13)) > Integer.parseInt(a.get(2))) throw new Exception("El horesBlocL de l'assignatura " + nom + " no pot ser superior a nHoresL");
                if (Integer.parseInt(a.get(14)) < 0) throw new Exception("El horesBlocP de l'assignatura " + nom + " no pot ser inferior a 0");
                if (Integer.parseInt(a.get(14)) > Integer.parseInt(a.get(2))) throw new Exception("El horesBlocP de l'assignatura " + nom + " no pot ser superior a nHoresP");


                // Creració de l'Aula
                Assignatura assig = new Assignatura();
                assig.setNom(a.get(0));
                assig.setNivell(Integer.parseInt(a.get(1)));

                assig.setnHoresT(Integer.parseInt(a.get(2)));
                assig.setnHoresL(Integer.parseInt(a.get(3)));
                assig.setnHoresP(Integer.parseInt(a.get(4)));

                assig.setnGrupsT(Integer.parseInt(a.get(5)));
                assig.setnGrupsL(Integer.parseInt(a.get(6)));
                assig.setnGrupsP(Integer.parseInt(a.get(7)));

                assig.setnGrupsMati(Integer.parseInt(a.get(8)));

                assig.setnAlumnesT(Integer.parseInt(a.get(9)));
                assig.setnAlumnesL(Integer.parseInt(a.get(10)));
                assig.setnAlumnesP(Integer.parseInt(a.get(11)));

                assig.setHoresBlocT(Integer.parseInt(a.get(12)));
                assig.setHoresBlocL(Integer.parseInt(a.get(13)));
                assig.setHoresBlocP(Integer.parseInt(a.get(14)));

                if (a.size() > 15) {
                    HashSet<String> setCore = new HashSet<>();

                    for (int i = 15; i < a.size(); i++) {
                        setCore.add(a.get(i));
                    }

                    assig.setCorrequisits(setCore);
                }

                // Afagir en el Conjunt d'Aules

                pE.getConjuntAssignatures().afegirAssignatura(assig);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Pla Estudis
    //////////////////////

    // plaEstudis[0] = horaInici
    // plaEstudis[1] = horaFi
    // plaEstudis[2] = horaCanviFranja

    public static void carregarPlaEstudis(String path) {

        String[] plaEstudis = ctrlPersistencia.carregarPlaEstudis(path);
        try {

            if (Integer.parseInt(plaEstudis[0]) < 0) throw new Exception("L'hora d'inici no pot ser inferior a 0");
            if (Integer.parseInt(plaEstudis[0]) > 23) throw new Exception("L'hora d'inici no pot ser superior a 23");
            if (Integer.parseInt(plaEstudis[1]) < 0) throw new Exception("L'hora de fi no pot ser inferior a 0");
            if (Integer.parseInt(plaEstudis[1]) > 23) throw new Exception("L'hora de fi no pot ser superior a 23");
            if (Integer.parseInt(plaEstudis[1]) < Integer.parseInt(plaEstudis[0])) throw new Exception("L'hora d'inici no pot ser superior a l'hora fi");
            if (Integer.parseInt(plaEstudis[2]) < Integer.parseInt(plaEstudis[0]) || Integer.parseInt(plaEstudis[2]) > Integer.parseInt(plaEstudis[1]))
                throw new Exception("L'hora de canvi de franja no està entre l'hora d'inici i la de fi");
            if (Integer.parseInt(plaEstudis[2]) < 0) throw new Exception("L'hora no pot ser inferior a 0");
            if (Integer.parseInt(plaEstudis[2]) > 23) throw new Exception("L'hora no pot ser superior a 23");

            pE.setHoraInici(Integer.parseInt(plaEstudis[0]));
            pE.setHoraFi(Integer.parseInt(plaEstudis[1]));
            pE.setHoraCanviFranja(Integer.parseInt(plaEstudis[2]));

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

}
