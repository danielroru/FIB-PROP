package Dominio;

import java.util.HashSet;
import java.util.Set;

public class Assignatura {

    // Atributs
    private String nom;

    private int nHoresT;
    private int nHoresL;
    private int nHoresP;

    // Número de grups
    private int nGrupsT;
    private int nGrupsL;
    private int nGrupsP;

    // Grups de matí/tarda
    private int nGrupsMati;

    // Agrupació de blocs
    private int horesBlocT;
    private int horesBlocL;
    private int horesBlocP;

    private int nAlumnesT;
    private int nAlumnesL;
    private int nAlumnesP;

    private int nivell;

    private Set<String> correquisits = new HashSet<>();

    // Mètodes

    // Constructores

    public Assignatura() {

    }

    // Constructora amb nivell
    public Assignatura(String nom, int nHoresT, int nHoresL, int nHoresP,
                       int nGrupsT, int nGrupsL, int nGrupsP, int nGrupsTarda,
                       int nGrupsMati, int nAlumnesT, int nAlumnesL, int nAlumnesP, int horesBlocT, int horesBlocL, int horesBlocP, int nivell) {

        this.nom = nom;

        // Quantitat d'hores
        this.nHoresT = nHoresT;
        this.nHoresL = nHoresL;
        this.nHoresP = nHoresP;

        // Quantitat de grups
        this.nGrupsT = nGrupsT;
        this.nGrupsL = nGrupsL; // Respecte el número de grups
        this.nGrupsP = nGrupsP; // Respecte el número de grups

        // Quantitat grups matí
        this.nGrupsMati = nGrupsMati;

        // Alumnes
        this.horesBlocT = horesBlocT;
        this.horesBlocL = horesBlocL;
        this.horesBlocP = horesBlocP;

        // Agrupació de les hores de classe amb blocs
        this.nAlumnesT = nAlumnesT;
        this.nAlumnesL = nAlumnesL;
        this.nAlumnesP = nAlumnesP;


        this.nivell = nivell;
    }

    public Assignatura(Assignatura as) {

        this.nom = as.getNom();

        // Quantitat d'hores
        this.nHoresT = as.getnHoresT();
        this.nHoresL = as.getnHoresL();
        this.nHoresP = as.getnHoresP();

        // Quantitat de grups
        this.nGrupsT = as.getnGrupsT();
        this.nGrupsL = as.getnGrupsL(); // Respecte el número de grups
        this.nGrupsP = as.getnGrupsP(); // Respecte el número de grups

        // Quantitat grups matí
        this.nGrupsMati = as.getnGrupsMati();

        // Alumnes
        this.nAlumnesT = as.getnAlumnesT();
        this.nAlumnesL = as.getnAlumnesL();
        this.nAlumnesP = as.getnAlumnesP();

        // Agrupació de les hores de classe amb blocs
        this.horesBlocT = as.getHoresBlocT();
        this.horesBlocL = as.getHoresBlocL();
        this.horesBlocP = as.getHoresBlocP();

        this.nivell = as.getNivell();

    }

    // Consultores


    public String getNom() {
        return nom;
    }

    public int getnHoresT() {
        return nHoresT;
    }

    public int getnHoresL() {
        return nHoresL;
    }

    public int getnHoresP() {
        return nHoresP;
    }

    public int getnGrupsT() {
        return nGrupsT;
    }

    public int getnGrupsL() {
        return nGrupsL;
    }

    public int getnGrupsP() {
        return nGrupsP;
    }

    public int getnGrupsMati() {
        return nGrupsMati;
    }

    public int getHoresBlocT() {
        return horesBlocT;
    }

    public int getHoresBlocL() {
        return horesBlocL;
    }

    public int getHoresBlocP() {
        return horesBlocP;
    }

    public int getnAlumnesT() {
        return nAlumnesT;
    }

    public int getnAlumnesL() {
        return nAlumnesL;
    }

    public int getnAlumnesP() {
        return nAlumnesP;
    }

    public int getNivell() {
        return nivell;
    }

    public ConjuntAssignatures getCorrequisits() {
        ConjuntAssignatures correquisits = new ConjuntAssignatures();
        for (String s : this.correquisits) {
            correquisits.afegirAssignatura(PlaEstudis.getConjuntAssignatures().getAssignatura(s));
        }
        return correquisits;
    }



    //Modificadores


    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setnHoresT(int nHoresT) {
        this.nHoresT = nHoresT;
    }

    public void setnHoresL(int nHoresL) {
        this.nHoresL = nHoresL;
    }

    public void setnHoresP(int nHoresP) {
        this.nHoresP = nHoresP;
    }

    public void setnGrupsT(int nGrupsT) {
        this.nGrupsT = nGrupsT;
    }

    public void setnGrupsL(int nGrupsL) {
        this.nGrupsL = nGrupsL;
    }

    public void setnGrupsP(int nGrupsP) {
        this.nGrupsP = nGrupsP;
    }

    public void setnGrupsMati(int nGrupsMati) {
        this.nGrupsMati = nGrupsMati;
    }

    public void setHoresBlocT(int horesBlocT) {
        this.horesBlocT = horesBlocT;
    }

    public void setHoresBlocL(int horesBlocL) {
        this.horesBlocL = horesBlocL;
    }

    public void setHoresBlocP(int horesBlocP) {
        this.horesBlocP = horesBlocP;
    }

    public void setnAlumnesT(int nAlumnesT) {
        this.nAlumnesT = nAlumnesT;
    }

    public void setnAlumnesL(int nAlumnesL) {
        this.nAlumnesL = nAlumnesL;
    }

    public void setnAlumnesP(int nAlumnesP) {
        this.nAlumnesP = nAlumnesP;
    }

    public void setNivell(int nivell) {
        this.nivell = nivell;
    }

    public void setCorrequisits(Set<String> correquisits) {
        this.correquisits = correquisits;
    }
}
