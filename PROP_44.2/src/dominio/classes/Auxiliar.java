package dominio.classes;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Auxiliar {
    private int horaInici;
    private int horaFi;
    private int horaFranja;
    private Map<String, Matriu> horari;

    public Auxiliar() {

    }

    public int getHoraInici() {
        return horaInici;
    }

    public void setHoraInici(int horaInici) {
        this.horaInici = horaInici;
    }

    public int getHoraFi() {
        return horaFi;
    }

    public void setHoraFi(int horaFi) {
        this.horaFi = horaFi;
    }

    public int getHoraFranja() {
        return horaFranja;
    }

    public void setHoraFranja(int horaFranja) {
        this.horaFranja = horaFranja;
    }

    public Map<String, Matriu> getHorari() {
        return horari;
    }

    public void setHorari(Map<String, Matriu> horari) {
        this.horari = horari;
    }
}
