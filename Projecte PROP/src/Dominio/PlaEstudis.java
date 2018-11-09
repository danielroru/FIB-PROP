package Dominio;

import java.util.*;

public class PlaEstudis {
    private ConjuntAssignatures cjtAssignatures = new ConjuntAssignatures();
    private ConjuntAules cjtAules = new ConjuntAules();
    // Atributs2
    private int horaInici;
    private int horaFi;
    private int horaCanviFranja;

    // Mètodes

    // Constructores

    /*
     Constructora de PlaEstudis
     * @param horaInici
     * @param horaFi
     * @param horaCanviFranja
     * @param nNivell
     * @param nAula
     */

    public PlaEstudis(){

    }

    public PlaEstudis(int horaInici, int horaFi, int horaCanviFranja) {
        this.horaInici = horaInici;
        this.horaFi = horaFi;
        this.horaCanviFranja = horaCanviFranja;
//        this.nNivell = nNivell;
//        this.nAula = nAula;
    }

    // Hora Inici, Fi, Canvi Franja.

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

    // Conjunt Assignatures
    public Set<Assignatura> getCjtAssig() {
        return this.cjtAssignatures.getConjuntAssignatures();
    }

    public void setCjtAssignatures(ConjuntAssignatures cjtAssignatures) {
        this.cjtAssignatures = cjtAssignatures;
    }

    // Conjunt Aula
    public  Map<String,Aula> getCjtAules() {
        return this.cjtAules.getConjuntAules();
    }

    public void setCjtAules(Map<String,Aula> cjtAssig) {
        this.cjtAules = cjtAules;
    }

}
