// Marc Casellas

package Dominio;

import java.util.*;

public class CtrlDominiAula {

    private Map<String,Aula> Aules;

    /////////////////////////////////////////////////////////////////
    /// CONSTRUCTORES
    /////////////////////////////////////////////////////////////////

    public CtrlDominiAula() {
        Aules = new HashMap<String, Aula>();
    }

    /////////////////////////////////////////////////////////////////
    /// CONSULTORES
    /////////////////////////////////////////////////////////////////

    public Vector<String> llistarAules() {

        Vector<String> resultat = new Vector<String>();

        Set<String> m = Aules.keySet();
        Iterator<String> it = ((Set) m).iterator();
        while(it.hasNext()){
            String id = (String) it.next();
            Aula a = Aules.get(id);
            resultat.add(id);
            resultat.add(String.valueOf(a.getCapacitat()));
            resultat.add(a.getTipusAula());
        }
        return resultat;

    }

    public Vector<String> getAula(String id) {

        Vector<String> resultat = new Vector<String>();

        Aula a = Aules.get(id);
        resultat.add(id);
        resultat.add(String.valueOf(a.getCapacitat()));
        resultat.add(a.getTipusAula());

        return resultat;

    }

    private boolean existeixAula(String id) {
        return Aules.containsKey(id);
    }

    /////////////////////////////////////////////////////////////////
    /// MODIFICADORES
    /////////////////////////////////////////////////////////////////

    public int afegirAula(String id, Vector<String> dades) {

        if (existeixAula(id)) return 1;

        else {
            if (id != dades.get(0)) return 2;

            else {
                Aula a = new Aula();
                if (!a.setId(id)) return -1;
                if (!a.setCapacitat(Integer.valueOf(dades.get(1)))) return -1;
                if (!a.setTipusAula(dades.get(2))) return -1;

                Aules.put(id, a);
            }
        }

        return 0;
    }

    public int modificarAula(String id, Vector<String> dades) {

        if (!existeixAula(id)) return 1;

        else {
            Aula a = Aules.get(id);

            a.setId(dades.get(0));
            a.setCapacitat(Integer.valueOf(dades.get(1)));
            a.setTipusAula(dades.get(2));

            if (id != a.getId()) {
                Aules.remove(id);
                id = dades.get(0);
            }

            Aules.put(id, a);
        }

        return 0;
    }

    public int eliminarAula(String id) {

        if (!existeixAula(id)) return 1;

        else {
            Aules.remove(id);
        }

        return 0;
    }
}
