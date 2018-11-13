package Dominio;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Horari {

    private Map<Sessio, Set<UAH>> horari;

    public Horari() {
        horari = new HashMap<>();
    }

    public Horari(Horari h) {
        horari = h.getHorari();
    }

    public Map<Sessio, Set<UAH>> getHorari() {
        return horari;
    }

    public void setHorari(Map<Sessio, Set<UAH>> horari) {
        this.horari = horari;
    }

    public void assignarUAH(Sessio se, UAH uah) {

        Set<UAH> temp;

        if (horari.containsKey(se)) {
            temp = horari.get(se);
            temp.add(uah);
            horari.put(se, temp);
        }
        else {
            temp = new HashSet<>();
            temp.add(uah);
            horari.put(se,temp);
        }

    }

    // TODO remove nomès una
    public void eliminarUAH(Sessio se) {
        if (horari.containsKey(se)) {
            horari.remove(se);
        }
    }

    public boolean valida(Sessio s, UAH uah) {
        return RestriccioBinaria.validaSolucio(this, s, uah);
    }

    public boolean esfallo() {
        return this.horari.isEmpty();
    }
}
