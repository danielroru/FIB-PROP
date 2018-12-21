package dominio.controladores;

import dominio.persistencia.*;

import dominio.persistencia.CarregarDades.*;
import dominio.persistencia.EditarDades.*;
import dominio.persistencia.GestionarHoraris.*;
import dominio.persistencia.GestionarHoraris.AltresVistesGestionarHoraris.vistaGenerarHorari;
import dominio.persistencia.EditarDades.AltresVistesEditarDades.*;

import javafx.util.Pair;

import java.util.ArrayList;

public class CtrlPresentacio {

    private static CtrlPresentacio instance = new CtrlPresentacio();
    private static CtrlDomini cD = CtrlDomini.getInstance();

    private static int dadesAssig = 0;
    private static int dadesAules = 0;
    private static int dadesPlaEstudis = 0;
    private static boolean complet = false;

    private CtrlPresentacio() {

    }

    public static CtrlPresentacio getInstance() {
        return instance;
    }


    public static String[] getAula(String id) {
        return cD.getAula(id);
    }


    public static String[] getAssig(String nom) {
        return cD.getAssig(nom);
    }


    public static String[] getHores() {
        return cD.getHores();
    }


    // Retornem tots els ID de les Aules

    public static String[] llistarAules() {
        return cD.llistarAules();
    }

    // Retornem tots els noms de les Assignatures

    public static String[] llistarAssigs() {
        return cD.llistarAssigs();
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

    public void vistaCarregarDades() {
        vistaCarregarDades vCD = new vistaCarregarDades();
    }

    //   · Carregar Directori

    public static void carregarDirectori(String fitxer) {
        cD.carregarDirectori(fitxer);
        complet = true;
    }


    public void carregarDadesAules(String fitxer) {
        cD.carregarDadesAules(fitxer);
        dadesAules = 1;
        if ((dadesAssig + dadesAules + dadesPlaEstudis) == 3) complet = true;
    }

    public void carregarDadesAssignatures(String fitxer) {
        cD.carregarDadesAssignatures(fitxer);
        dadesAssig = 1;
        if ((dadesAssig + dadesAules + dadesPlaEstudis) == 3) complet = true;
    }

    public void carregarDadesPlaEstudis(String fitxer) {
        cD.carregarDadesPlaEstudis(fitxer);
        dadesPlaEstudis = 1;
        if ((dadesAssig + dadesAules + dadesPlaEstudis) == 3) complet = true;
    }

    // ------------------------
    // ------------------------
    // Opció 2 : Gestionar Horaris

    public void vistaGestionarHoraris() {
        vistaGestionarHoraris vGH = new vistaGestionarHoraris();
    }

    // ------------------------
    // ------------------------
    // Opció 2 : Generar Horari

    //  · vistaGenerarHorari()
    //      És allà on hi ha la vista.

    public void generarHorari() {
        String seleccionar = null;
        ArrayList<Pair<String, String[][][]>> horari = cD.generarHorari();
        vistaHorari(horari, seleccionar, complet);
    }


    // Vista Horari

    public void vistaHorari(ArrayList<Pair<String, String[][][]>> horari, String seleccionar, boolean complet) {
        vistaGenerarHorari vGenerarH = new vistaGenerarHorari(horari, seleccionar, complet);
    }


    // ------------------------
    // ------------------------
    // Opció 3: Guardar Horari

    public void guardarHorari(String text) {
        cD.guardarHorari(text);
    }

    // ------------------------
    // ------------------------
    // Opció 4 : Carregar Horari

    public void carregarHorari(String text) {
        ArrayList<Pair<String, String[][][]>> horari = cD.carregarHorari(text);
        vistaHorari(horari, null, complet);
    }


    // ------------------------
    // ------------------------
    // Opció 6 : Editar Dades


    public void anarVistaEditarDades() {
        vistaEditarDades vED = new vistaEditarDades();
    }

    public void anarVistaEditarAula() {
        vistaEditarAula vEA = new vistaEditarAula();
    }

    public void anarVistaEditarAssignatures() {
        vistaEditarAssignatures vEA = new vistaEditarAssignatures();
    }

    public void anarVistaEditarPlaEstudis() {
        vistaEditarPlaEstudis vEPE = new vistaEditarPlaEstudis();
    }



}