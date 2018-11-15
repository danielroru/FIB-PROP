package Dominio;

import java.util.*;

public class Horari {
    private Set<UAH> horari;
    private HashMap<Sessio, Set<UAH>> horariAlg;

    public Horari() {
        horari = new HashSet<>();
        horariAlg = new HashMap<>();
    }

    public Set<UAH> getHorari() {
        return horari;
    }

    public boolean existeixSessio(Sessio s) {
        return horariAlg.containsKey(s);
    }

    public boolean existeixUAH(UAH uah) {
        return horariAlg.(uah);
    }

    public Set<UAH> getUAHbySessio(Sessio s) {
        return horariAlg.get(s);
    }

    public void assignarUAH(Sessio se, UAH uah) {
        if (!uah.teSessio()) {
            uah.setSessio(se);
        }
        Set<UAH> temp;

        if (horariAlg.containsKey(se)) {
            temp = horariAlg.get(se);
            temp.add(uah);
            horariAlg.put(se, temp);
        }
        else {
            temp = new HashSet<>();
            temp.add(uah);
            horariAlg.put(se,temp);
        }
    }

    public void eliminarUAH(Sessio se, UAH uah) {
        if (uah.teSessio()) {
            uah.eliminaSessio();
        if (horariAlg.containsKey(se)) {
            horariAlg.remove(se);
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
