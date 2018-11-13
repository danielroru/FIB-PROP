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
    public void setHoraInici(int hora) {
        this.horaInici = hora;
    }
    public void setHoraFi(int hora) {
        this.horaFi = hora;
    }
    public void setHoraCanviFranja(int hora) {
        this.horaCanviFranja = hora;
    }


    // Conjunt Aules

    public static void afegirAssignatura(Assignatura a) {
        this.cjtAssignatures.afegirAssignatura(a);
    }
    
    // Conjunt Assignatures
    public static Set<Assignatura> getCjtAssig() {
        return this.cjtAssignatures.getConjuntAssignatures();
    }

    public void setCjtAssignatures(ConjuntAssignatures cjtAssignatures) {
        this.cjtAssignatures = cjtAssignatures;
    }


}
