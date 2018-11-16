package Dominio;

import java.util.*;

public class Horari {

    private Map<Sessio, ArrayList<UAH>> assignacio;

    private Map<String, Matriu> horari;

    public Map<Sessio, ArrayList<UAH>> getAssignacio() {
        return assignacio;
    }

    public void setAssignacio(Map<Sessio, ArrayList<UAH>> assignacio) {
        this.assignacio = assignacio;
    }

    public Horari() {
        assignacio = new HashMap<>();
        horari = new HashMap<>();
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

        int i = uah.getDia().ordinal();
        int j = uah.getHora();

        Casella c = new Casella();

        c.setNomAssig(se.getAssignatura().getNom());
        c.setNumGrup(se.getIdGrup());
        c.setTipus(se.getTipus());

        Matriu m;

        if (horari.containsKey(uah.getAula())) {
            m = horari.get(uah.getAula());
        }
        else {
            m = new Matriu();
        }

        m.assignarCasella(i,j,c);

        horari.put(uah.getAula().getId(),m);
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
                    duracio = s.getAssignatura().getnHoresT();
                    break;
                case LABORATORI:
                    duracio = s.getAssignatura().getnHoresL();
                    break;
                case PROBLEMES:
                    duracio = s.getAssignatura().getnHoresP();
                    break;
            }
            if (assignacio.get(s).size() == duracio)
                return true;
        }
        return false;
    }

    public void mapejaHorari() {
        //for (Aula a : PlaEstudis.getConjuntAules().getAules()) HashMap
        for (Sessio s : assignacio.keySet()) {
            for (UAH uah : assignacio.get(s)) {
                String nomAula = uah.getAula().getId();
                int i = uah.getDia().ordinal();
                int j = uah.getHora();
                Casella c = new Casella(s.getAssignatura().getNom(), s.getIdGrup(), s.getTipus());
                if (horari.containsKey(nomAula))
                    horari.get(nomAula).assignarCasella(i, j, c);
                else {
                    Matriu m = new Matriu();
                    m.assignarCasella(i, j, c);
                    horari.put(nomAula, m);
                }
            }
        }
    }

    public Map<String, Matriu> getHorari() {
        return horari;
    }

    public void imprimirHorari() throws Exception {
        inout io = new inout();
        for (String aula : horari.keySet()) {
            io.writeln("");
            io.writeln("");
            io.writeln("---------------");
            io.writeln("Aula " + aula);
            io.writeln("---------------");
            io.writeln("");

            io.write("               ");
            for (Enumeracio.Dia dia : Enumeracio.Dia.values()) {
                io.write(dia.toString());
                for (int i = dia.toString().length(); i < 15; i++) {
                    io.write(" ");
                }
            }
            io.writeln("");
            for (int hora = PlaEstudis.getHoraInici(); hora < PlaEstudis.getHoraFi(); hora++) {
                io.write(hora + "h");
                int xifres = hora / 10 == 0 ? 1 : 2;
                for (int j = xifres+1; j < 15; j++) {
                    io.write(" ");
                }
                for (Enumeracio.Dia dia : Enumeracio.Dia.values()) {

                    Casella c = horari.get(aula).getCasella(dia.ordinal(),hora);

                    if (c != null) {

                        String result = null;
                        String result2 = null;
                        String sigla = null;
                        switch (c.getTipus()) {
                            case TEORIA:
                                sigla = "T";
                                break;
                            case LABORATORI:
                                sigla = "L";
                                break;
                            case PROBLEMES:
                                sigla = "P";
                                break;
                        }
                        result = "[" + c.getNomAssig() + "]";
                        io.write(result);
                        int k = 0;
                        for (k = result.length(); k < 8; k++) {
                            io.write(" ");
                        }
                        result2 = c.getNumGrup() + " " + sigla;
                        io.write(result2);
                        for (int j = k + result2.length(); j < 15; j++) {
                            io.write(" ");
                        }
                    }




                }
                io.writeln("");
            }
        }

    }
}