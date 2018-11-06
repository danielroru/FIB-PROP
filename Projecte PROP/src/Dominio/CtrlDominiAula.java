package Dominio;

import java.util.List;
import java.util.Map;

public class CtrlDominiAula {

    private Map<String,Aula> Aules;

    /////////////////////////////////////////////////////////////////
    /// CONSTRUCTORES
    /////////////////////////////////////////////////////////////////

    public CtrlDominiAula() {
        Aules = new Map<String, Aula>();
    }

    /////////////////////////////////////////////////////////////////
    /// CONSULTORES
    /////////////////////////////////////////////////////////////////

    public List<Aula> llistarAules() {
        List<Aula> resultat = new List<>(Aules.values());
        return resultat;
    }

    public boolean existeixAula(String id) {
        return Aules.containsKey(id);
    }

    /////////////////////////////////////////////////////////////////
    /// MODIFICADORES
    /////////////////////////////////////////////////////////////////

    public int void afegirAula(String id, int capacitat, Aula.TipusAula tipus) {

        if (!existeixAula(id)) {
            Aula a = new Aula(id, capacitat, tipus);
            Aules.put(id, a);
        }

    }

    public void modificarAula(String id) {

    }

    public void eliminarAula(String id) {
        Aules.remove(id);
    }


    Aula.TipusAula tipus = null;
    int numTipusAula = scanner.nextInt();

        if (numTipusAula == 1 || numTipusAula == 2) {
        tipus = numTipusAula == 1 ? Aula.TipusAula.TEORIA : Aula.TipusAula.LABORATORI;
    }

        CD.afegirAula(id, capacitat, tipus);
        System.out.println("-- AULA AFEGIDA CORRECTAMENT --");

}
