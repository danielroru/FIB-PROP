import com.sun.deploy.util.OrderedHashSet;

import java.util.*;

public class Horari {
    private Set<UAH> horari;

    public Horari() {
        horari = new HashSet<>();
    }

    public Set<UAH> getHorari() {
        return horari;
    }

    public boolean existeixUAH(UAH uah) {
        return horari.contains(uah);
    }

    public void assignarUAH(Sessio se, UAH uah) {
        if (!uah.teSessio()) {
            uah.setSessio(se);
            horari.add(uah);
        }

    }

    public void eliminarUAH(Sessio se, UAH uah) {
        if (uah.teSessio()) {
            uah.eliminaSessio();
            horari.remove(uah);
        }
    }

    public boolean valida(Sessio s, UAH uah) {
        return RestriccioBinaria.validaSolucio(this, s, uah);
    }

    public boolean esfallo() {
        return this.horari.isEmpty();
    }


    public List<UAH> ordena() {
        List<UAH> llista = new LinkedList<UAH>();
        llista.addAll(horari);
        Collections.<UAH>sort(llista);
        return llista;

    }
}