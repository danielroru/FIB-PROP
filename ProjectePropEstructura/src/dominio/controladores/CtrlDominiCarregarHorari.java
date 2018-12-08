package dominio.controladores;

import dominio.classes.*;
import java.util.Map;

public class CtrlDominiCarregarHorari {

    private static CtrlDominiCarregarHorari instance = new CtrlDominiCarregarHorari();

    private CtrlDominiCarregarHorari() {}

    public static CtrlDominiCarregarHorari getInstance() {
        return instance;
    }

    public static void carregarHorari(Horari ultimHorari) {
        try {
            if (PlaEstudis.isNull()) throw new Exception ("    ERROR: Encara no has carregat les dades de persistència");
            inout io = new inout();

            io.write("Quin fitxer vols carregar?");
            String path = io.readline();

            ultimHorari.llegirHorari(path);
            ultimHorari.imprimirHorari();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
