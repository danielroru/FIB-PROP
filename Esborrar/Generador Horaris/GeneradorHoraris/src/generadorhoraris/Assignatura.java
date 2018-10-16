/*
 * Generador d'horaris. Pràctica PROP 2018-19 T
 * Jesús Mercadal, Júlia Bosch i Marc Casellas
 */
package generadorhoraris;

/**
 *
 * @author marccasellas
 */
public class Assignatura {
    // Identificació
    private int id;
    private String nom;

    // Hores de classe
    private int HoresT;
    private int HoresL;
    private int HoresP;

    // Número de grups
    private int nGrupsT;
    private int nGrupsL;
    private int nGrupsP;
    
    // Grups de tardes
    private int nGrupsTarda;
    
    // Agrupació de blocs     
    private int HoresBloc = 2;
    
    /****************************
    *    FUNCIONS               *
    ****************************/
    
    // Constructora
    public Assignatura() {
              
    }
    
    public Assignatura(String nom, int HoresT, int HoresL, int HoresP, int nGrupsT, int nGrupsL, int nGrupsP, int nGrupsTarda) {
        
        // Assignar una nova
        this.id = 0;
        this.HoresT = HoresT;
        this.HoresL = HoresL;
        this.HoresP = HoresP;
        this.nGrupsT = nGrupsT;
        this.nGrupsL = nGrupsL;
        this.nGrupsP = nGrupsP;
        this.nGrupsTarda = nGrupsTarda;
    }
    
}
