package Dominio;

import java.util.*;

public class PlaEstudis {

    private ConjuntAssignatures cjtAssignatures = new ConjuntAssignatures();

    private static int horaInici;
    private static int horaFi;
    private static int horaCanviFranja;


    private PlaEstudis(){
    }



    // Consultores
    public static int getHoraInici() {
        return horaInici;
    }
    public static int getHoraFi() {
        return horaFi;
    }
    public static int getHoraCanviFranja() {
        return horaCanviFranja;
    }


    // Modificadores
    public static void setHoraInici(int hora) {
        this.horaInici = hora;
    }
    public static void setHoraFi(int hora) {
        this.horaFi = hora;
    }
    public static void setHoraCanviFranja(int hora) {
        this.horaCanviFranja = hora;
    }


    // Conjunt Aules

    public static void afegirAssignatura(Assignatura a) {
        cjtAssignatures.afegirAssignatura(a);
    }
    
    // Conjunt Assignatures
    public static ConjuntAssignatures getCjtAssig() {
        return cjtAssignatures;
    }

    public static Map<Integer, Set<Assignatura>> getCjtNivells() {
        return cjtAssignatures.getConjuntNivells();
    }

    public void setCjtAssignatures(ConjuntAssignatures cjtAssignatures) {
        this.cjtAssignatures = cjtAssignatures;
    }


}
