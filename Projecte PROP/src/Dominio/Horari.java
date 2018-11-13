package Dominio;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Horari {
    private Set<UAH> horari;
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

    public boolean existeixSessio(Sessio s) {
        return assignacio.containsKey(s);
    }

    public Set<UAH> getUAHbySessio(Sessio s) {
        return assignacio.get(s);
    }

    public boolean existeixUAH(UAH uah) {
        return horari.contains(uah);
    }

    public void assignarUAH(Sessio se, UAH uah) {
        if (!uah.teSessio()) {
            uah.setSessio(se);
        }

    }

    public void eliminarUAH(Sessio se, UAH uah) {
        if (uah.teSessio()) {
            uah.eliminaSessio();
        }
    }

    public boolean valida(Sessio s, UAH uah) {
        return RestriccioBinaria.validaSolucio(this, s, uah);
    }

    public boolean esfallo() {
        return this.horari.isEmpty();
    }
}
