package dominio.controladores;

import dominio.swing.*;

import dominio.swing.CarregarDades.*;
import dominio.swing.EditarDades.*;
import dominio.swing.GestionarHoraris.*;
import dominio.swing.EditarDades.AltresVistesEditarDades.*;

import dominio.swing.GestionarHoraris.AltresVistesGestionarHoraris.vistaGenerarHorari;
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


    /*
    *
    *   MIRAR ERRORS SI NO HI HA INFO CORRECTE
    *   --------------------------------------
    *
    * */

    /* Retorna Informació de l'Aula:
    *
    *       · [0] ID
    *       · [1] Capacitat
    *       · [2] Tipus
    * */
    public static String[] getAula(String id) {
        String[] info = cD.getAula(id);
        return info;
    }


    /* Retorna Informació de l'Assignatura:
     *
     *       · [0] Nom
     *
     *       · [1] Hores Teoria
     *       · [2] Hores Laboratori
     *       · [3] Hores Problemes
     *
     *       · [4] Grups Teoria
     *       · [5] Grups Laboratori
     *       · [6] Grups Problemes
     *
     *       · [7] Grups Matins
     *
     *       · [8] Hores Bloc Teoria
     *       · [9] Hores Bloc Laboratori
     *       · [10] Hores Bloc Problemes
     *
     *       · [11] Alumnes Teoria
     *       · [12] Alumnes Laboratori
     *       · [13] Alumnes Problemes
     *
     *       · [14] Nivell
     *
     *       · [15] "Correquisits"
     *
     * */
    public static String[] getAssig(String nom) {
        String[] info = cD.getAssig(nom);
        return info;
    }

    /* Retorna Informació de Hores Pla Estudis :
     *
     *       · [0] Hora Inici
     *       · [1] Hora Fi
     *       · [2] Hora Canvi Franja
     *
     * */

    public static String[] getHores() {
        String[] info = cD.getHores();
        return info;
    }


    // Retornem tots els ID de les Aules

    public static String[] llistarAules() {
        String[] llista = cD.llistarAules();
        return llista;
    }

    // Retornem tots els noms de les Assignatures

    public static String[] llistarAssigs() {
        String[] llista = cD.llistarAssigs();
        return llista;
    }


    /* S'ha de tenir en conta els Horaris
     * creats amb les condicions anteriors
     * hauria de donar error ¿? */

    public static void modificarAula() {}
    public static void modificarAssig() {}
    public static void modificarHores() {}

    public static void borrarAula(){}
    public static void borrarAssig(){}



    // ------------------------

    // Vista Menú Principal

    // Aquí cridem a la Vista Principal
    // On hi ha el Menú en cada opció

    public static void inicialitzarPresentacio() {

        vistaPrincipal vPrincipal = new vistaPrincipal();

    }
    // ------------------------
    // ------------------------
    // Opció 1 : Carregar Dades

    //   · carregarDades:
    //          És allà on hi ha la vista.

    public void vistaCarregarDades() {
        vistaCarregarDades vCD = new vistaCarregarDades();
    }


    //   · carregarInformacio:
    //          És la crida CD per carregar fitxer.
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
    // Opció 5 : Modificar Horari

    //  · vistaModificarHorari()
    //      És allà on hi ha la vista.


    // ------------------------
    // ------------------------
    // Opció 6 : Editar Dades


    //  · vistaEditarDades()
    //      És allà on hi ha la vista.

    public void vistaEditarDades() {
        //cD.editarDades();
        vistaEditarDades vED = new vistaEditarDades();
    }

    public void vistaEditarPlaEstudis() {
        vistaEditarPlaEstudis vEPE = new vistaEditarPlaEstudis();
    }

    public void vistaEditarAssignatures() {
        vistaEditarAssignatures vEA = new vistaEditarAssignatures();
    }

}
