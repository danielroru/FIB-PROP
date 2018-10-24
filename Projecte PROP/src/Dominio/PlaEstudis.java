package Dominio;

import java.util.*;

public class PlaEstudis {

    // Atributs2
    private Set<String> setAssignatures = new HashSet<String>();
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
/*
    public int getNAula() {
        return nAula;
    }

    public int getNNivell() {
        return nNivell;
    }
*/

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
/*
    public void setNNivells(int num) {
        this.nNivell = num;
    }

    public void setNAula(int num) {
        this.nAula = num;
    }
    */

    public void addAssignatura(String nom) {
        setAssignatures.add(nom);
    }

    // Otros Métodos


    void crearAssignatura() {
        Assignatura as = GeneradorHorari.crearAssignatura(this);
        setAssignatures.add(as.getNom());
        if (setAssignatures.contains(as.getNom())) System.out.println("El PE conté "+ as.getNom());
    }

}
