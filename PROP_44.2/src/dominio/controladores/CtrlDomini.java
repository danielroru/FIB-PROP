package dominio.controladores;

import java.util.*;

import dominio.classes.*;
import javafx.util.Pair;

public class CtrlDomini {

    private static PlaEstudis plaEstudis;

    public CtrlDomini() {
        plaEstudis = new PlaEstudis();
    }

    public static void carregarDirectori(String path) {
        CtrlDominiCarregarDades.carregarDadesByFolder(path);
    }

    public static void carregarDadesAules(String path) {
        CtrlDominiCarregarDades.carregarAules(path);
    }

    public static void carregarDadesAssignatures(String path) {
        CtrlDominiCarregarDades.carregarAssignatures(path);
    }

    public static void carregarDadesPlaEstudis(String path) {
        CtrlDominiCarregarDades.carregarPlaEstudis(path);
    }

    /*
    *   ------------
    *   Opcions Menú
    *   ------------
    * */


    // [ Opció 2 ] Generar Horari

    public static ArrayList<Pair<String, String[][][]>> generarHorari() {

        CtrlDomini.getPlaEstudis().setUltimHorari(CtrlDominiGenerarHorari.generarHorari());
        ArrayList<Pair<String, String[][][]>> horari = CtrlDominiGenerarHorari.escriureHorari();
        return horari;

    }


    // [ Opció 3 ] Guardar Horari

    public static void guardarHorari(String text) {

        CtrlDominiGuardarHorari.guardarHorari(plaEstudis, text);
    }

    // [ Opció 4 ] Carregar Horari

    public static ArrayList<Pair<String, String[][][]>> carregarHorari(String path) {
        CtrlDomini.getPlaEstudis().setUltimHorari(CtrlDominiCarregarHorari.carregarHorari(path));


        ArrayList<Pair<String, String[][][]>> horariEscriure = CtrlDomini.getPlaEstudis().getUltimHorari().passarString();

        return horariEscriure;

    }

    // [ Opció 5 ] Modificar Horari

    public static ArrayList<Pair<String, String[][][]>> modificarDades(String oldDia, String oldHora, String oldAula,
                                      String newDia, String newHora, String newAula) {
        plaEstudis.setUltimHorari(CtrlDominiGenerarHorari.modificarDades(oldDia, oldHora, oldAula, newDia, newHora, newAula,plaEstudis.getUltimHorari()));
        ArrayList<Pair<String, String[][][]>> horariEscriure = plaEstudis.getUltimHorari().passarString();
        return horariEscriure;
    }




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

    public static String[] getAssig(String nom) {
        String[] info = new String[19];
        ConjuntAssignatures cjtAssig = plaEstudis.getConjuntAssignatures();
        Assignatura assig = cjtAssig.getAssignatura(nom);
        info[0] = assig.getNom();
        info[1] = String.valueOf(assig.getNivell());
        info[2] = String.valueOf(assig.getnHoresT());
        info[3] = String.valueOf(assig.getnHoresL());
        info[4] = String.valueOf(assig.getnHoresP());
        info[5] = String.valueOf(assig.getnGrupsT());
        info[6] = String.valueOf(assig.getnGrupsL());
        info[7] = String.valueOf(assig.getnGrupsP());
        info[8] = String.valueOf(assig.getnGrupsMati());
        info[9] = String.valueOf(assig.getnAlumnesT());
        info[10] = String.valueOf(assig.getnAlumnesL());
        info[11] = String.valueOf(assig.getnAlumnesP());
        info[12] = String.valueOf(assig.getHoresBlocT());
        info[13] = String.valueOf(assig.getHoresBlocL());
        info[14] = String.valueOf(assig.getHoresBlocP());
        return info;
    }

    public static String[] getHores() {
        String[] horariPE = new String[3];
        horariPE[0] = String.valueOf(plaEstudis.getHoraInici());
        horariPE[1] = String.valueOf(plaEstudis.getHoraFi());
        horariPE[2] = String.valueOf(plaEstudis.getHoraCanviFranja());
        return horariPE;
    }

    public static HashSet<String> llistarAules() {
       return plaEstudis.llistarAules();
    }

    public static HashSet<String> llistarAssigs() {
        return plaEstudis.llistarAssignatures();
    }


    public static String[] getAula(String id) {

        String[] result = new String[3];

        Aula a = plaEstudis.getConjuntAules().getAula(id);

        result[0] = a.getId();
        result[1] = Integer.toString(a.getCapacitat());
        result[2] = a.getTipusAula().toString();

        return result;



    }

    public static PlaEstudis getPlaEstudis() {
        return plaEstudis;
    }


}
