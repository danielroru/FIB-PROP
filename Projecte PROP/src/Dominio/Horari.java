package Dominio;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Horari {

    private Map<Sessio, Set<UAH>> horari;

    public Horari() {}

    public void assigarUAH(Sessio se, UAH uah) {
        if (horari.isEmpty()) {
            horari = new HashMap<Sessio, Set<UAH>>();
        }

        Set<UAH> temp;

        if (horari.containsKey(se)) {
            temp = horari.get(se);
            temp.add(uah);
            horari.replace(se, temp);
        }
        else {
            temp = new HashSet<>();
            temp.add(uah);
            horari.put(se,temp);
        }
    }

    // TODO remove nomès una
    public void eliminarUAH(Sessio se, UAH uah) {
        if (horari.containsKey(se)) {
            horari.values().clear();
        }
    }
}