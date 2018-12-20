package dominio.controladores;

import java.util.*;

import dominio.classes.*;
import javafx.util.Pair;

public class CtrlDomini {

    private static CtrlDomini instance = new CtrlDomini();

    private static CtrlPresentacio ctrlPresentacio = CtrlPresentacio.getInstance();

    private static CtrlDominiCarregarDades ctrlDominiCarregarDades = CtrlDominiCarregarDades.getInstance();
    private static CtrlDominiGenerarHorari ctrlDominiGenerarHorari = CtrlDominiGenerarHorari.getInstance();
    private static CtrlDominiGuardarHorari ctrlDominiGuardarHorari = CtrlDominiGuardarHorari.getInstance();
    private static CtrlDominiCarregarHorari ctrlDominiCarregarHorari = CtrlDominiCarregarHorari.getInstance();

    private static CtrlPersistencia ctrlPersistencia = CtrlPersistencia.getInstance();

    private static Horari ultimHorari;
    private static PlaEstudis plaEstudis = PlaEstudis.getInstance();

    private CtrlDomini() {

    }

    public static void carregarDadesAules(String fitxer) {
        ctrlDominiCarregarDades.carregarAules(fitxer);
    }

    public static void carregarDadesAssignatures(String fitxer) {
        ctrlDominiCarregarDades.carregarAssignatures(fitxer);
    }

    public static void carregarDadesPlaEstudis(String fitxer) {
        ctrlDominiCarregarDades.carregarPlaEstudis(fitxer);
    }

    public static CtrlDomini getInstance() {
        return instance;
    }

    /*
    *   ------------
    *   Opcions Menú
    *   ------------
    * */


    // [ Opció 2 ] Generar Horari

    public static ArrayList<Pair<String, String[][][]>> generarHorari() {

        ultimHorari = ctrlDominiGenerarHorari.generarHorari();
        ArrayList<Pair<String, String[][][]>> horari = ctrlDominiGenerarHorari.escriureHorari();
        return horari;

    }


    // [ Opció 3 ] Guardar Horari

    public static void guardarHorari(String text) {

        ctrlDominiGuardarHorari.guardarHorari(ultimHorari.getHorari(), text);
    }

    // [ Opció 4 ] Carregar Horari

    public static ArrayList<Pair<String, String[][][]>> carregarHorari(String text) {
        Map<String, Matriu> horari = ctrlDominiCarregarHorari.carregarHorari(ultimHorari, text);
        ultimHorari.setHorari(horari);
        ArrayList<Pair<String, String[][][]>> horariEscriure = ultimHorari.passarString();
        return horariEscriure;
    }


    /*
     *   ----------------
     *   Informació Vista
     *   ----------------
     * */


    // Retorna informació de l'Aula

    //

    public static String[] getAula(String id) {
        String[] info = new String[3];
        ConjuntAules cjtAules = plaEstudis.getConjuntAules();
        Aula aula = cjtAules.getAula(id);
        info[0] = aula.getId();
        info[1] = String.valueOf(aula.getCapacitat());
        info[2] = String.valueOf(aula.getTipusAula());
        return info;
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

    public static String[] llistarAules() {
        ConjuntAules cjtAules = plaEstudis.getConjuntAules();
        String[] llistaAules = new String[cjtAules.getAules().size()];
        int i = 0;
        for(Aula aula : cjtAules.getAules()) {
            llistaAules[i] = aula.getId();
        }
        return llistaAules;
    }

    public static String[] llistarAssigs() {
        ConjuntAssignatures cjtAssig = plaEstudis.getConjuntAssignatures();
        String[] llistaAssig = new String[cjtAssig.getAssignatures().size()];
        int i = 0;
        for(Assignatura assig : cjtAssig.getAssignatures()) {
            llistaAssig[i] = assig.getNom();
        }
        return llistaAssig;
    }

}
