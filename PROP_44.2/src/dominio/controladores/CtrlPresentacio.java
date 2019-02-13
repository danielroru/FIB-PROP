package dominio.controladores;

import dominio.classes.Assignatura;
import presentacio.*;

import presentacio.CarregarDades.*;
import presentacio.EditarDades.*;
import presentacio.GestionarHoraris.*;
import presentacio.GestionarHoraris.vistaVeureHorari;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CtrlPresentacio {

    private static int dadesAssig = 0;
    private static int dadesAules = 0;
    private static int dadesPlaEstudis = 0;
    private static boolean complet = false;

    private static CtrlDomini ctrlDomini = new CtrlDomini();;


    public CtrlPresentacio() {
    }


    public static String[] getAssig(String nom) {
        return CtrlDomini.getAssig(nom);
    }


    public static String[] getHores() {
        return CtrlDomini.getHores();
    }


    // Retornem tots els ID de les Aules

    public static HashSet<String> llistarAules() {
        return CtrlDomini.llistarAules();
    }

    // Retornem tots els noms de les Assignatures

    public static HashSet<String> llistarAssigs() {
        return CtrlDomini.llistarAssigs();
    }


    public static void modificarAula() {}
    public static void modificarAssig() {}
    public static void modificarHores() {}

    public static void borrarAula(){}
    public static void borrarAssig(){}



    // ------------------------

    // Vista Menú Principal


    public static void inicialitzarPresentacio() {
        vistaPrincipal vPrincipal = new vistaPrincipal();

    }
    // ------------------------
    // ------------------------
    // Opció 1 : Carregar Dades

    public static void vistaCarregarDades() {
        vistaCarregarDades vCD = new vistaCarregarDades();
    }

    //   · Carregar Directori

    public static void carregarDirectori(String fitxer) {
        CtrlDomini.carregarDirectori(fitxer);
        complet = true;
    }


    public static void carregarDadesAules(String fitxer) {
        CtrlDomini.carregarDadesAules(fitxer);
        dadesAules = 1;
        if ((dadesAssig + dadesAules + dadesPlaEstudis) == 3) complet = true;
    }

    public static void carregarDadesAssignatures(String fitxer) {
        CtrlDomini.carregarDadesAssignatures(fitxer);
        dadesAssig = 1;
        if ((dadesAssig + dadesAules + dadesPlaEstudis) == 3) complet = true;
    }

    public static void carregarDadesPlaEstudis(String fitxer) {
        CtrlDomini.carregarDadesPlaEstudis(fitxer);
        dadesPlaEstudis = 1;
        if ((dadesAssig + dadesAules + dadesPlaEstudis) == 3) complet = true;
    }

    // ------------------------
    // ------------------------
    // Gestionar Horaris

    public static void vistaGestionarHoraris() {
        vistaGestionarHoraris vGH = new vistaGestionarHoraris();
    }

    // ------------------------
    // ------------------------
    // Generar Horari

    //  · vistaGenerarHorari()
    //      És allà on hi ha la vista.

    public static void generarHorari() {
        String seleccionar = null;
        ArrayList<Pair<String, String[][][]>> horari = CtrlDomini.generarHorari();
        vistaHorari(horari, seleccionar, complet);
    }


    // Vista Horari

    public static void vistaHorari(ArrayList<Pair<String, String[][][]>> horari, String seleccionar, boolean complet) {
        vistaVeureHorari vGenerarH = new vistaVeureHorari(horari, seleccionar, complet);
    }


    // ------------------------
    // ------------------------
    // Modificar Horari


    public static void modificarDades(String oldDia, String oldHora, String oldAula,
                               String newDia, String newHora, String newAula) {

        ArrayList<Pair<String, String[][][]>> horari = CtrlDomini.modificarDades(oldDia, oldHora, oldAula, newDia, newHora, newAula);
        vistaHorari(horari, null, complet);
    }

    // ------------------------
    // ------------------------
    // Guardar Horari

    public static void guardarHorari(String text) {
        CtrlDomini.guardarHorari(text);
    }

    // ------------------------
    // ------------------------
    // Carregar Horari

    public static void carregarHorari(String text) {
        ArrayList<Pair<String, String[][][]>> horari = CtrlDomini.carregarHorari(text);
        vistaHorari(horari, null, complet);
    }


    // ------------------------
    // ------------------------
    // Editar Dades


    public static void anarVistaEditarDades() {
        vistaEditarDades vED = new vistaEditarDades(complet);
    }


    public static void anarVistaEditarAssignatures(String[] assigatura) {

        vistaEditarAssignatures vEA = new vistaEditarAssignatures(assigatura, complet);
    }

    public static void anarVistaEditarAula(String[] assigatura) {

        vistaEditarAula vEA = new vistaEditarAula(assigatura, complet);
    }

    public static void anarVistaEditarPlaEstudis() {
        vistaEditarPlaEstudis vEPE = new vistaEditarPlaEstudis(complet);
    }

    public static String[] getAula(String id) {
        return CtrlDomini.getAula(id);
    }

    public static  String[] informacioAssignatura (String assignatura) {
       String[] assig = CtrlDomini.getAssig(assignatura);
       return assig;
    }

    public static String[] informacioAula (String aula) {
        String[] resultat = CtrlDomini.getAula(aula);
        return resultat;
    }

    public static void guardarAssignatura(String[] info) {
        CtrlDomini.guardarAssignatura(info);
    }

    public static void guardarAula(String[] info) {
        CtrlDomini.guardarAula(info);
    }

    public static String[] cercaInfoPE() {
        String[] info = CtrlDomini.cercarInfoPE();
        return info;
    }

    public static void editarInformacio(String[] info) {
        CtrlDomini.editarInformacio(info);
    }

}
