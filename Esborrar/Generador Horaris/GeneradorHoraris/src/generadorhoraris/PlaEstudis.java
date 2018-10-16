/*
 * Generador d'horaris. Pràctica PROP 2018-19 T
 * Jesús Mercadal, Júlia Bosch i Marc Casellas
 */
package generadorhoraris;

/**
 *
 * @author marccasellas
 */
public class PlaEstudis {
    
    private int horaInici;
    private int horaFi;
    private int horaCanviFranja;
    
    public PlaEstudis() {
        
    }
    
    public PlaEstudis(int horaInici, int horaFi, int horaCanviFranja) {
        this.horaInici = horaInici;
        this.horaFi = horaFi;
        this.horaCanviFranja = horaCanviFranja;
    }
    
    public int getHoraInici() {
        return this.horaInici;
    }
    
    public int getHoraFi() {
        return this.horaFi;
    }
    
    public int getHoraCanviFranja() {
        return this.horaCanviFranja;
    }
}
