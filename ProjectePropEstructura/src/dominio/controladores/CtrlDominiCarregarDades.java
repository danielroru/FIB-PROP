package dominio.controladores;


import dominio.JSON.parser.ParseException;
import dominio.classes.*;

import java.io.IOException;

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

    public void carregarDades() {

        String[][] aules = ctrlPersistencia.carregarAules();
        String[][] assignatures = ctrlPersistencia.carregarAssignatures();
        String[] plaEstudis = ctrlPersistencia.carregarPlaEstudis();

        // Inicialitzem tots els valors de Pla d'Estudi
        pE.reset();

        carregarAules(aules);
        carregarAssignatures(assignatures);
        carregarPlaEstudis(plaEstudis);

    }

    // Aules
    //////////////////////

    // aules[x][0] = id
    // aules[x][1] = capacitat
    // aules[x][2] = tipus

    private void carregarAules(String[][] aules) {

        ConjuntAules cjtAules = ConjuntAules.getInstance();

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

                cjtAules.afegirAula(aula);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (Exception e) {
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

    private void carregarAssignatures(String[][] assignatures) {

        try {
            for (String[] a : assignatures) {

                if (Integer.parseInt(a[1]) < 0) throw new Exception("El nivell de l'assignatura " + a[0] + " no pot ser inferior a 0");
                if (Integer.parseInt(a[2]) < 0) throw new Exception("El nHoresT de l'assignatura " + a[0] + " no pot ser inferior a 0");
                if (Integer.parseInt(a[3]) < 0) throw new Exception("El nHoresL de l'assignatura " + a[0] + " no pot ser inferior a 0");
                if (Integer.parseInt(a[4]) < 0) throw new Exception("El nHoresP de l'assignatura " + a[0] + " no pot ser inferior a 0");
                if (Integer.parseInt(a[5]) < 0) throw new Exception("El nGrupsT de l'assignatura " + a[0] + " no pot ser inferior a 0");
                if (Integer.parseInt(a[6]) < 0) throw new Exception("El nGrupsL de l'assignatura " + a[0] + " no pot ser inferior a 0");
                if (Integer.parseInt(a[6]) > 9) throw new Exception("El nGrupsL de l'assignatura " + a[0] + " no pot ser superior a 9");
                if (Integer.parseInt(a[7]) < 0) throw new Exception("El nGrupsP de l'assignatura " + a[0] + " no pot ser inferior a 0");
                if (Integer.parseInt(a[7]) > 9) throw new Exception("El nGrupsP de l'assignatura " + a[0] + " no pot ser superior a 9");
                if (Integer.parseInt(a[8]) < 0) throw new Exception("El nGrupsMati de l'assignatura " + a[0] + " no pot ser inferior a 0");
                if (Integer.parseInt(a[8]) > Integer.parseInt(a[5])) throw new Exception("El nGrupsMati de l'assignatura " + a[0] + " no pot ser superior al nGrupsT");
                if (Integer.parseInt(a[9]) < 0) throw new Exception("El nAlumnesT de l'assignatura " + a[0] + " no pot ser inferior a 0");
                if (Integer.parseInt(a[10]) < 0) throw new Exception("El nAlumnesL de l'assignatura " + a[0] + " no pot ser inferior a 0");
                if (Integer.parseInt(a[10]) > Integer.parseInt(a[9])) throw new Exception("El nAlumnesL de l'assignatura " + a[0] + " no pot ser superior nAlumnesT");
                if (Integer.parseInt(a[11]) < 0) throw new Exception("El nAlumnesP de l'assignatura " + a[0] + " no pot ser inferior a 0");
                if (Integer.parseInt(a[11]) > Integer.parseInt(a[9])) throw new Exception("El nAlumnesP de l'assignatura " + a[0] + " no pot ser superior nAlumnesT");
                if (Integer.parseInt(a[12]) < 0) throw new Exception("El horesBlocT de l'assignatura " + a[0] + " no pot ser inferior a 0");
                if (Integer.parseInt(a[12]) > Integer.parseInt(a[2])) throw new Exception("El horesBlocT de l'assignatura " + a[0] + " no pot ser superior a nHoresT");
                if (Integer.parseInt(a[13]) < 0) throw new Exception("El horesBlocL de l'assignatura " + a[0] + " no pot ser inferior a 0");
                if (Integer.parseInt(a[13]) > Integer.parseInt(a[2])) throw new Exception("El horesBlocL de l'assignatura " + a[0] + " no pot ser superior a nHoresL");
                if (Integer.parseInt(a[14]) < 0) throw new Exception("El horesBlocP de l'assignatura " + a[0] + " no pot ser inferior a 0");
                if (Integer.parseInt(a[14]) > Integer.parseInt(a[2])) throw new Exception("El horesBlocP de l'assignatura " + a[0] + " no pot ser superior a nHoresP");


                // Creració de l'Aula
                Assignatura assig = new Assignatura();
                assig.setNom(a[0]);
                assig.setNivell(Integer.parseInt(a[1]));

                assig.setnHoresT(Integer.parseInt(a[2]));
                assig.setnHoresL(Integer.parseInt(a[3]));
                assig.setnHoresP(Integer.parseInt(a[4]));

                assig.setnGrupsT(Integer.parseInt(a[5]));
                assig.setnGrupsL(Integer.parseInt(a[6]));
                assig.setnGrupsP(Integer.parseInt(a[7]));

                assig.setnGrupsMati(Integer.parseInt(a[8]));

                assig.setnAlumnesT(Integer.parseInt(a[9]));
                assig.setnAlumnesL(Integer.parseInt(a[10]));
                assig.setnAlumnesP(Integer.parseInt(a[11]));

                assig.setHoresBlocT(Integer.parseInt(a[12]));
                assig.setHoresBlocL(Integer.parseInt(a[13]));
                assig.setHoresBlocP(Integer.parseInt(a[14]));

                // Afagir en el Conjunt d'Aules

                pE.afegirAssignatura(assig);

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

    private void carregarPlaEstudis(String[] plaEstudis) {

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
