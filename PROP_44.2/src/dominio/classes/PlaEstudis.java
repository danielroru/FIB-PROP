package dominio.classes;

import dominio.controladores.CtrlDomini;
import sun.util.resources.cldr.ta.CurrencyNames_ta;

import java.util.HashSet;
import java.util.Set;

public class PlaEstudis {

    private int horaInici = -1;
    private int horaFi = -1;
    private int horaCanviFranja = -1;

    private ConjuntAssignatures cjtAssignatures ;
    private ConjuntAules cjtAules;

    private Horari ultimHorari;


    public PlaEstudis() {
        cjtAssignatures = new ConjuntAssignatures();
        cjtAules = new ConjuntAules();

        horaInici = -1;
        horaFi = -1;
        horaCanviFranja = -1;

        ultimHorari = new Horari();
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


    public boolean isNull() {
        return horaInici == -1 && horaFi == -1 && horaCanviFranja == -1;
    }

    // Modificadores
    public void setHoraInici(int hora) {
        horaInici = hora;
    }
    public void setHoraFi(int hora) {
        horaFi = hora;
    }
    public void setHoraCanviFranja(int hora) {
        horaCanviFranja = hora;
    }


    /**
     * Obtenim un conjunt d'aules
     * @return retornem un ConjuntAules
     */
    public ConjuntAules getConjuntAules() {
        return cjtAules;
    }

    /**
     * Obtenim un conjunt d'assignatures
     * @return retornem un ConjuntAssignatures
     */
    public ConjuntAssignatures getConjuntAssignatures() {
        return cjtAssignatures;
    }

    public void setCjtAssignatures(ConjuntAssignatures cjt) {
        cjtAssignatures = cjt;
    }

    public void setCjtAules(ConjuntAules cjt) {
        cjtAules = cjt;
    }

    public HashSet<String> llistarAules() {
        return cjtAules.llistarAules();
    }

    public HashSet<String> llistarAssignatures() {
        return cjtAssignatures.llistarAssignatures();
    }

    public static void editarAssignatura(Assignatura a) {
        CtrlDomini.getPlaEstudis().getConjuntAssignatures().afegirAssignatura(a);
    }

    public static void editarAula(Aula a) {
        CtrlDomini.getPlaEstudis().getConjuntAules().afegirAula(a);
    }

    public Horari getUltimHorari() {
        return ultimHorari;
    }

    public void setUltimHorari(Horari ultimHorari) {
        this.ultimHorari = ultimHorari;
    }
}
