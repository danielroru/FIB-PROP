package dominio.controladores;

import dominio.swing.*;

import javafx.util.Pair;

import java.util.ArrayList;

public class CtrlPresentacio {

    private static CtrlPresentacio instance = new CtrlPresentacio();
    private static CtrlDomini ctrlDomini = CtrlDomini.getInstance();


    private static boolean complet = false;

    private CtrlPresentacio() {

    }

    public static CtrlPresentacio getInstance() {
        return instance;
    }


    public static void carregarSetByCarpeta(String path) {
        CtrlDominiCarregarDades.carregarDadesByFolder(path);
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
        String[] info = ctrlDomini.getAula(id);
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
        String[] info = ctrlDomini.getAssig(nom);
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
        String[] info = ctrlDomini.getHores();
        return info;
    }


    // Retornem tots els ID de les Aules

    public static String[] llistarAules() {
        String[] llista = ctrlDomini.llistarAules();
        return llista;
    }

    // Retornem tots els noms de les Assignatures

    public static String[] llistarAssigs() {
        String[] llista = ctrlDomini.llistarAssigs();
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
        //ctrlDomini.carregarDades();
        vistaCarregarDades vCD = new vistaCarregarDades();
    }

   /*
    public void carregarDades(String fitxer) {
        ctrlDomini.carregarDades(fitxer);
        complet = true;
        inicialitzarPresentacio();
    }
*/

    // ------------------------
    // ------------------------
    // Opció 2 : Generar Horari

    //  · vistaGenerarHorari()
    //      És allà on hi ha la vista.

    public void vistaGenerarHorari() {
        String seleccionar = null;
        ArrayList<Pair<String, String[][][]>> horari = ctrlDomini.generarHorari();
        vistaGenerarHorari vGenerarH = new vistaGenerarHorari(horari, seleccionar, complet);
    }




    // ------------------------
    // ------------------------
    // Opció 3 : Guardar Horari

    //  · vistaGuardarHorari()
    //      És allà on hi ha la vista.


    public void vistaGuardarHorari() {
        //ctrlDomini.guardarHorari();
        vistaGuardarHorari vGuardarH = new vistaGuardarHorari();
    }

    //  · guardarHorari()
    //      Guarda l'Horari.

    public void guardarHorari(String text) {
        ctrlDomini.guardarHorari(text);
        vistaGuardarHorari vGenerarH = new vistaGuardarHorari();
    }

    // ------------------------
    // ------------------------
    // Opció 4 : Carregar Horari

    //  · vistaCarregarHorari()
    //      És allà on hi ha la vista.

    public void vistaCarregarHorari() {
        //ctrlDomini.carregarHorari();
        vistaCarregarHorari vCH = new vistaCarregarHorari();
    }

    //  · carregarHorari()
    //      Carrega l'Horari.

    public void carregarHorari(String text) {
        //ctrlDomini.guardarHorari(text);
        vistaCarregarDades vGenerarH = new vistaCarregarDades();
    }

    // ------------------------
    // ------------------------
    // Opció 5 : Modificar Horari

    //  · vistaModificarHorari()
    //      És allà on hi ha la vista.

    public void vistaModificarHorari() {
        //ctrlDomini.modificarHorari();
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
        //ctrlDomini.editarDades();
        vistaEditarDades vED = new vistaEditarDades();
    }

    //  · editarDades()
    //      S'Editen les Dades


    // ------------------------
    // ------------------------
}
