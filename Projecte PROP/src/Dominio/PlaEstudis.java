package Dominio;

import java.util.*;

public class PlaEstudis {

    private ConjuntAssignatures cjtAssignatures;
    private ConjuntAules cjtAules;

    private int horaInici;
    private int horaFi;
    private int horaCanviFranja;


    public PlaEstudis(){
        cjtAssignatures = new ConjuntAssignatures();
        cjtAules = new ConjuntAules();
    }
/*
    public PlaEstudis(int horaInici, int horaFi, int horaCanviFranja) {
        this.horaInici = horaInici;
        this.horaFi = horaFi;
        this.horaCanviFranja = horaCanviFranja;
    }
*/


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

    public void afegirAula(Aula a) {
        cjtAules.afegirAula(a);
    }

    public void afegirAssignatura(Assignatura a) {
        cjtAssignatures.afegirAssignatura(a);
    }
    
    // Conjunt Assignatures
    public ConjuntAssignatures getCjtAssig() {
        return cjtAssignatures;
    }

    public void setCjtAssignatures(ConjuntAssignatures cjtAssignatures) {
        this.cjtAssignatures = cjtAssignatures;
    }

    // Conjunt Aula
    public  Set<Aula> getCjtAules() {
        return cjtAules.getConjuntAules();
    }

    public void setCjtAules(Map<String,Aula> cjtAssig) {
        this.cjtAules = cjtAules;
    }

}
