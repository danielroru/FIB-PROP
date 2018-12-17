package dominio.controladores;

import dominio.classes.*;
import dominio.vistes.inout;

import java.util.Map;


public class CtrlDominiGuardarHorari {

    private static CtrlDominiGuardarHorari instance = new CtrlDominiGuardarHorari();
    private static CtrlPersistencia ctrlPersistencia = CtrlPersistencia.getInstance();


    private CtrlDominiGuardarHorari() {}

    public static CtrlDominiGuardarHorari getInstance() {
        return instance;
    }

    public void guardarHorari(Map<String, Matriu> ultimHorari, String text) {
        try {
            if (ultimHorari.size() == 0) throw new Exception ("    ERROR: Encara no has generat cap horari");
            ctrlPersistencia.guardarHorari(ultimHorari, text);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
