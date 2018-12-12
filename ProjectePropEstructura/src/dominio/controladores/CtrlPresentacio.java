package dominio.controladores;

import dominio.vistes.*;

public class CtrlPresentacio {

    private static CtrlPresentacio instance = new CtrlPresentacio();
    private static CtrlDomini cD = CtrlDomini.getInstance();
    private static VistaPrincipal vP = VistaPrincipal.getInstance();
    private static VistaEscriureHorari vEH = VistaEscriureHorari.getInstance();

    private CtrlPresentacio() {

    }

    public static CtrlPresentacio getInstance() {
        return instance;
    }


    public static void inicialitzarPresentacio() {
        int accio;
        do {
            vP.menuPrincipal();
            try {
                accio = vP.readint();
            }
            catch (Exception e) {
                accio = 0;
                System.out.println("Error al seleccionar la opció");
            }
            switch (accio) {
                case 1:
                    cD.carregarDades();
                    break;
                case 2:
                    cD.generarHorari();
                    break;
                case 3:
                    cD.guardarHorari();
                    break;
                case 4:
                    cD.carregarHorari();
                    break;
                default:
                    accio = 0;
                    break;
            }


        } while (accio != 0);
    }

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

    public static void imprimirHorari(String[] horari) {
        vEH.imprimirHorari(horari);
    }

}
