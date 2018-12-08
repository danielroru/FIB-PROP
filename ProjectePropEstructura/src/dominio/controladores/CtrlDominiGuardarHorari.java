package dominio.controladores;

import dominio.classes.*;

import java.util.Map;


public class CtrlDominiGuardarHorari {

    private static CtrlDominiGuardarHorari instance = new CtrlDominiGuardarHorari();
    private static CtrlPersistencia ctrlPersistencia = CtrlPersistencia.getInstance();


    private CtrlDominiGuardarHorari() {}

    public static CtrlDominiGuardarHorari getInstance() {
        return instance;
    }

    public void guardarHorari(Map<String, Matriu> ultimHorari) {
        try {
            if (ultimHorari.size() == 0) throw new Exception ("    ERROR: Encara no has generat cap horari");
            inout io = new inout();

            io.write("Quin nom li vols posar?");
            String nomFitxer = io.readline();

            ctrlPersistencia.guardarHorari(ultimHorari, nomFitxer);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
