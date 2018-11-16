package Dominio;

import java.util.Comparator;

public class UAH implements Comparable<UAH> {

    // Atributs
    private String nomAssig;
    private int numGrup;
    private Enumeracio.TipusSessio tipus;

    // Mètodes

    // Constructores

    public UAH() {
    }

    public UAH(String nomAssig, int numGrup, Enumeracio.TipusSessio tipus) {
        this.nomAssig = nomAssig;
        this.numGrup = numGrup;
        this.tipus = tipus;
    }
    

    /* Comparació pel sort
    public int compareTo(UAH uah1) {

        int compareAula = (this.aula.getId()).compareTo(uah1.getAula().getId());
        int compareHora = ((Integer)this.getHora()).compareTo((Integer)uah1.getHora());
        int compareDia = (this.dia).compareTo(uah1.getDia());

        // 3-level comparison using if-else block
        if(compareAula == 0) {
            return ((compareHora == 0) ? compareDia : compareHora);
        }
        else {
            return compareAula;
        }
    }
    */

}
