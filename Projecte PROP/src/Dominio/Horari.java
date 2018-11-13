package Dominio;

import java.util.*;

public class Horari {

    private Map<Sessio, Set<UAH>> horari;

    public Map<Sessio, Set<UAH>> getHorari() {
        return horari;
    }

    public void setHorari(Map<Sessio, Set<UAH>> horari) {
        this.horari = horari;
    }

    public Horari() {
        horari = new HashMap<>();
    }

    public Horari(Horari h) {
        horari = h.getHorari();
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

    public void escriure() {
        for (Sessio s : horari.keySet()) {
            System.out.println(s.getNomAssig() + " " + s.getIdGrup() + " " + s.getTipus());
            System.out.println("----" + horari.get(s).size() +  "----");
            for (UAH uah : horari.get(s)) {
                System.out.println(uah.getDia());
                System.out.println(uah.getHora());
                System.out.println(uah.getIdAula());
            }

        }
    }
    public boolean assignacioCompelta(Sessio s) {
        if(horari.containsKey(s)) {
            if (horari.get(s).size() == s.getDuracio())
                return true;
        }
        return false;
    }
}
