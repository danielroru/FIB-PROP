package Dominio;

import java.util.*;

public class PlaEstudis {

    // Atributs2
    private Set<Assignatura> setAssignatures = new HashSet<Assignatura>();
    private int horaInici;
    private int horaFi;
    private int horaCanviFranja;
    private int nAula;
    private int nNivell;

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

    public PlaEstudis(int horaInici, int horaFi, int horaCanviFranja, int nNivell, int nAula) {
        this.horaInici = horaInici;
        this.horaFi = horaFi;
        this.horaCanviFranja = horaCanviFranja;
        this.nNivell = nNivell;
        this.nAula = nAula;
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

    public int getNAssignatures() {
        return setAssignatures.size();
    }

    public int getNAula() {
        return nAula;
    }

    public int getNNivell() {
        return nNivell;
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

    public void setNNivells(int num) {
        this.nNivell = num;
    }

    public void setNAula(int num) {
        this.nAula = num;
    }

    public void addAssignatura(Assignatura as) {
        setAssignatures.add(as);
    }

    // Otros Métodos

    public void crearAula() {
        ++nAula;
    }

    public void crearNivell() {
        ++nNivell;
    }

    public void eliminarAula() {
        --nAula;
    }

    public void eliminarNivell() {
        --nNivell;
    }

    void crearAssignatura() {
        Assignatura as = Utils.crearAssignatura(this );
        setAssignatures.add(as);
        if (setAssignatures.contains(as)) System.out.println("El PE conté "+ as.getNom());
    }

}
