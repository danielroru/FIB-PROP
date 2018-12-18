package dominio.controladores;

import dominio.swing.*;

import dominio.swing.A_CarregarDades.*;
import dominio.swing.B_GenerarHorari.*;
import dominio.swing.C_GuardarHorari.*;
import dominio.swing.D_CarregarHorari.*;
import dominio.swing.E_ModificarHorari.*;
import dominio.swing.F_EditarDades.*;

import dominio.vistes.*;
import javafx.util.Pair;

import java.util.ArrayList;

public class CtrlPresentacio {

    private static CtrlPresentacio instance = new CtrlPresentacio();
    private static CtrlDomini cD = CtrlDomini.getInstance();
    private static VistaPrincipal vP = VistaPrincipal.getInstance();
    private static VistaEscriureHorari vEH = VistaEscriureHorari.getInstance();

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

    public static void imprimirHorari(ArrayList<Pair<String, String[][][]>> horari) {
        vEH.imprimirHorari(horari);
    }


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
        //cD.carregarDades();
        vistaCarregarDades vCD = new vistaCarregarDades();
    }

    //   · carregarInformacio:
    //          És la crida CD per carregar fitxer.
    public void carregarDades(String fitxer) {
        cD.carregarDades(fitxer);
        complet = true;
        inicialitzarPresentacio();
    }


    // ------------------------
    // ------------------------
    // Opció 2 : Generar Horari

    //  · vistaGenerarHorari()
    //      És allà on hi ha la vista.

    public void vistaGenerarHorari() {
        String seleccionar = null;
        ArrayList<Pair<String, String[][][]>> horari = cD.generarHorari();
        vistaGenerarHorari vGenerarH = new vistaGenerarHorari(horari, seleccionar, complet);
    }




    // ------------------------
    // ------------------------
    // Opció 3 : Guardar Horari

    //  · vistaGuardarHorari()
    //      És allà on hi ha la vista.


    public void vistaGuardarHorari() {
        //cD.guardarHorari();
        vistaGuardarHorari vGuardarH = new vistaGuardarHorari();
    }

    //  · guardarHorari()
    //      Guarda l'Horari.

    public void guardarHorari(String text) {
        cD.guardarHorari(text);
        vistaGuardarHorari vGenerarH = new vistaGuardarHorari();
    }

    // ------------------------
    // ------------------------
    // Opció 4 : Carregar Horari

    //  · vistaCarregarHorari()
    //      És allà on hi ha la vista.

    public void vistaCarregarHorari() {
        //cD.carregarHorari();
        vistaCarregarHorari vCH = new vistaCarregarHorari();
    }

    //  · carregarHorari()
    //      Carrega l'Horari.

    public void carregarHorari(String text) {
        //cD.guardarHorari(text);
        vistaCarregarDades vGenerarH = new vistaCarregarDades();
    }

    // ------------------------
    // ------------------------
    // Opció 5 : Modificar Horari

    //  · vistaModificarHorari()
    //      És allà on hi ha la vista.

    public void vistaModificarHorari() {
        //cD.modificarHorari();
        vistaModificarHorari vMH = new vistaModificarHorari();
    }

    //  · modificarHorari()
    //      Es Modifica l'Horari


    // ------------------------
    // ------------------------
    // Opció 6 : Editar Dades


    //  · vistaEditarDades()
    //      És allà on hi ha la vista.

    public void vistaEditarDades() {
        //cD.editarDades();
        vistaEditarDades vED = new vistaEditarDades();
    }

    //  · editarDades()
    //      S'Editen les Dades


    // ------------------------
    // ------------------------
}
