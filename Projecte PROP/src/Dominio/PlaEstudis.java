package Dominio;

import java.util.*;

public class PlaEstudis {

    private ConjuntAssignatures cjtAssignatures;

    private int horaInici;
    private int horaFi;
    private int horaCanviFranja;


    public PlaEstudis(){
        cjtAssignatures = new ConjuntAssignatures();
    }


    // Consultores
    public int getHoraInici() {
        return horaInici;
    }
    public int getHoraFi() {
        return horaFi;
    }
    public int getHoraCanviFranja() {
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

    public void afegirAssignatura(Assignatura a) {
        cjtAssignatures.afegirAssignatura(a);
    }
    
    // Conjunt Assignatures
    public ConjuntAssignatures getCjtAssig() {
        return cjtAssignatures;
    }

    public Map<Integer, Set<Assignatura>> getCjtNivells() {
        return cjtAssignatures.getConjuntNivells();
    }

    public void setCjtAssignatures(ConjuntAssignatures cjtAssignatures) {
        this.cjtAssignatures = cjtAssignatures;
    }


}
