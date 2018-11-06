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


}
