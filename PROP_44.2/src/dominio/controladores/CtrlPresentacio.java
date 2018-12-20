package dominio.controladores;

import dominio.swing.*;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Set;

public class CtrlPresentacio {

    private static CtrlPresentacio instance = new CtrlPresentacio();
    private static CtrlDomini cD = CtrlDomini.getInstance();


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

    public static Set<String> llistarAules() {
        return cD.llistarAules();
    }

    // Retornem tots els noms de les Assignatures

    public static String[] llistarAssigs() {
        return cD.llistarAssigs();
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
        //cD.carregarDades();
        dominio.swing.A_CarregarDades.vistaCarregarDades vCD = new dominio.swing.A_CarregarDades.vistaCarregarDades();
    }

    //   · carregarInformacio:
    //          És la crida CD per carregar fitxer.
    public void carregarDades(String fitxer) {
        cD.carregarDades(fitxer);
        System.out.println("OK!");
        complet = true;
        inicialitzarPresentacio();
    }


    // ------------------------
    // ------------------------
    // Opció 2 : Generar Horari

    //  · vistaGenerarHorari()
    //      És allà on hi ha la vista.

    public void vistaGenerarHorari() {
        ArrayList<Pair<String, String[][][]>> horari = cD.generarHorari();
        dominio.swing.B_GenerarHorari.vistaGenerarHorari vGenerarH = new dominio.swing.B_GenerarHorari.vistaGenerarHorari(horari, complet);
        System.out.println("OK!");
    }

    //  · generarHorari()
    //      Crea l'Horari.

    public void generarHorari() {
        cD.generarHorari();
        System.out.println("OK!");
    }


    // ------------------------
    // ------------------------
    // Opció 3 : Guardar Horari

    //  · vistaGuardarHorari()
    //      És allà on hi ha la vista.


    public void vistaGuardarHorari() {
        //cD.guardarHorari();
        dominio.swing.C_GuardarHorari.vistaGuardarHorari vGuardarH = new dominio.swing.C_GuardarHorari.vistaGuardarHorari();
    }

    //  · guardarHorari()
    //      Guarda l'Horari.

    public void guardarHorari(String text) {
        cD.guardarHorari(text);
        dominio.swing.C_GuardarHorari.vistaGuardarHorari vGenerarH = new dominio.swing.C_GuardarHorari.vistaGuardarHorari();
        System.out.println("OK!");
    }

    // ------------------------
    // ------------------------
    // Opció 4 : Carregar Horari

    //  · vistaCarregarHorari()
    //      És allà on hi ha la vista.

    public void vistaCarregarHorari() {
        //cD.carregarHorari();
        dominio.swing.D_CarregarHorari.vistaCarregarHorari vCH = new dominio.swing.D_CarregarHorari.vistaCarregarHorari();
    }

    //  · carregarHorari()
    //      Carrega l'Horari.

    public void carregarHorari(String text) {
        //cD.guardarHorari(text);
        dominio.swing.A_CarregarDades.vistaCarregarDades vGenerarH = new dominio.swing.A_CarregarDades.vistaCarregarDades();
        System.out.println("OK!");
    }

    // ------------------------
    // ------------------------
    // Opció 5 : Modificar Horari

    //  · vistaModificarHorari()
    //      És allà on hi ha la vista.

    public void vistaModificarHorari() {
        //cD.modificarHorari();
        dominio.swing.E_ModificarHorari.vistaModificarHorari vMH = new dominio.swing.E_ModificarHorari.vistaModificarHorari();
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
        dominio.swing.F_EditarDades.vistaEditarDades vED = new dominio.swing.F_EditarDades.vistaEditarDades();
    }

    //  · editarDades()
    //      S'Editen les Dades


    // ------------------------
    // ------------------------
}
