package dominio.controladores;

import java.io.IOException;
import java.util.*;

import dominio.JSON.parser.ParseException;
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

    private static PlaEstudis pE;
    private static Horari ultimHorari;


    private CtrlDomini() {

    }

    public static CtrlDomini getInstance() {
        return instance;
    }


    // [ Opció 1 ] Carreguem Dades

    public static void carregarDades() {
        ctrlDominiCarregarDades.carregarDades();
    }

    // [ Opció 2 ] Generar Horari

    public static void generarHorari() {

        ultimHorari = ctrlDominiGenerarHorari.generarHorari();
    }

    // [ Opció 3 ] Guardar Horari

    public static void guardarHorari() {
        ctrlDominiGuardarHorari.guardarHorari(ultimHorari.getHorari());
    }

    // [ Opció 4 ] Carregar Horari

    public static void carregarHorari() {
        ctrlDominiCarregarHorari.carregarHorari(ultimHorari);
    }

}

