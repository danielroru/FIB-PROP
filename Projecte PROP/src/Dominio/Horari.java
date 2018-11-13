package Dominio;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Horari {
    private Map<UAH, Sessio> horari;
    private Map<Sessio, Set<UAH>> assignacio;

    public Horari() {
        horari = new HashMap<>();
        assignacio = new HashMap<>();

        for (Map.Entry<Sessio, Set<UAH>> entry : assignacio.entrySet()) {
            //entry.
        }
    }

    public Map<UAH, Sessio> getHorari() {
        return horari;
    }

    public Map<Sessio, Set<UAH>> getAssignacio() {
        return assignacio;
    }

    public Sessio getSessiobyUAH(UAH uah) {
        return horari.get(uah);
    }

    public boolean existeixSessio(Sessio s) {
        return assignacio.containsKey(s);
    }

    public Set<UAH> getUAHbySessio(Sessio s) {
        return assignacio.get(s);
    }

    public boolean existeixUAH(UAH uah) {
        return horari.containsKey(uah);
    }

    public void assignarUAH(Sessio se, UAH uah) {
        if (!horari.containsKey(uah)) {
            horari.put(uah,se);
        }


        Set<UAH> temp;

        if (assignacio.containsKey(se)) {
            temp = assignacio.get(se);
        }
        else {
            temp = new HashSet<>();
        }

        temp.add(uah);
        assignacio.put(se, temp);
    }

    public void eliminarUAH(Sessio se, UAH uah) {
        if (horari.containsKey(uah)) {
            horari.remove(uah);
        }

        if (assignacio.containsKey(se)) {
            assignacio.remove(se);
        }
    }

    public boolean valida(Sessio s, UAH uah) {
        return RestriccioBinaria.validaSolucio(this, s, uah);
    }

    public boolean esfallo() {
        return this.horari.isEmpty();
    }
}
