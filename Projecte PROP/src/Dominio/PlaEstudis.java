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


    public int getHoraInici() {
        return horaInici;
    }

    public int getHoraFi() {
        return horaFi;
    }

    public int getHoraCanviFranja() {
        return horaCanviFranja;
    }

    public void setHoraInici(int hora) {
        this.horaInici = hora;
    }

    public void setHoraFi(int hora) {
        this.horaFi = hora;
    }

    public void setHoraCanviFranja(int hora) {
        this.horaCanviFranja = hora;
    }

    public void afegirAula(Aula a) {
        cjtAules.afegirAula(a);
    }


}
