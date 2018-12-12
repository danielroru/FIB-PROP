package dominio.controladores;

import java.util.*;

import dominio.classes.*;

/*
        1] Carregar Set De Persistencia
        2] Generar Horari
        3] Guardar Horari
        4] Carregar Horari
        0] Sortir de l'aplicació
*/

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

    public static CtrlDomini getInstance() {
        return instance;
    }


    /*
    *   ------------
    *   Opcions Menú
    *   ------------
    * */

    // [ Opció 1 ] Carreguem Dades

    public static void carregarDades() {
        ctrlDominiCarregarDades.carregarDades();
    }

    // [ Opció 2 ] Generar Horari

    public static void generarHorari() {

        ultimHorari = ctrlDominiGenerarHorari.generarHorari();
        String[] horari = ctrlDominiGenerarHorari.escriureHorari();
        ctrlPresentacio.imprimirHorari(horari);

    }

    // [ Opció 3 ] Guardar Horari

    public static void guardarHorari() {
        ctrlDominiGuardarHorari.guardarHorari(ultimHorari.getHorari());
    }

    // [ Opció 4 ] Carregar Horari

    public static void carregarHorari() {
        Map<String, Matriu> horari = ctrlDominiCarregarHorari.carregarHorari(ultimHorari);
        ultimHorari.setHorari(horari);
        String[] horariEscriure = ultimHorari.passarString();
        ctrlPresentacio.imprimirHorari(horariEscriure);
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

