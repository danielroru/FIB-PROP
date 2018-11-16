package Dominio;

import java.util.*;

public class Estructura {

    private Map<Sessio, ArrayList<UAH>> assignacio;

    public Map<Sessio, ArrayList<UAH>> getAssignacio() {
        return assignacio;
    }

    public void setAssignacio(Map<Sessio, ArrayList<UAH>> assignacio) {
        this.assignacio = assignacio;
    }

    public Estructura() {
        assignacio = new HashMap<>();
    }

    public Estructura(Estructura h) {
        assignacio = h.getAssignacio();
    }

    public void assignarUAH(Sessio se, UAH uah) {

        ArrayList<UAH> temp;

        if (assignacio.containsKey(se)) {
            temp = assignacio.get(se);
            temp.add(uah);
            assignacio.put(se, temp);
        }
        else {
            temp = new ArrayList<>();
            temp.add(uah);
            assignacio.put(se,temp);
        }
    }

    public void eliminarUAH(Sessio se, UAH uah) {
        if (assignacio.containsKey(se)) {
            if (assignacio.get(se).contains(uah))
                assignacio.get(se).remove(uah);

            if (assignacio.get(se).isEmpty())
                assignacio.remove(se);
        }
    }

    public boolean valida(Sessio s, UAH uah) {
        return RestriccioBinaria.validaSolucio(this, s, uah);
    }

    public boolean esfallo() {
        return this.assignacio.isEmpty();
    }

    public boolean existeixUAH(Sessio s, UAH uah) {
        for (Sessio se : assignacio.keySet())
            for (UAH uah1 : assignacio.get(se))
                if ((uah == uah1) && (s != se)) return true;

        return false;
    }

    public void escriure() {
        for (Sessio s : assignacio.keySet()) {
            System.out.println(s.getAssignatura().getNom() + " " + s.getIdGrup() + " " + s.getTipus());
            System.out.println("----" + assignacio.get(s).size() +  "----");
            for (UAH uah : assignacio.get(s)) {
                System.out.println(uah.getDia());
                System.out.println(uah.getHora());
                System.out.println(uah.getAula().getId() + "\n");
            }

        }
    }
    public boolean assignacioCompelta(Sessio s) {
        if(assignacio.containsKey(s)) {
            int duracio = 0;
            switch (s.getTipus()) {
                case TEORIA:
                    s.getAssignatura().getnHoresT();
                    break;
                case LABORATORI:
                    s.getAssignatura().getnHoresL();
                    break;
                case PROBLEMES:
                    s.getAssignatura().getnHoresP();
                    break;
            }
            if (assignacio.get(s).size() == duracio) return true;
        }
        return false;
    }
}