package Dominio;

import JSON.JSONArray;
import JSON.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
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

    public void guardarHorari(){
        // Array general
        JSONArray aules = new JSONArray();

        for (String nomAula : horari.keySet()) {
            JSONObject aula = new JSONObject();

            // Afegim nova aula a l'array
            aula.put("nomAula", nomAula);
            Matriu m  = horari.get(nomAula);

                // Array de dies
                JSONArray dies = new JSONArray();


                // Dies dins de l'aula
                for (int i = 0; i < Enumeracio.Dia.values().length; i++) {
                    // Objecte dia
                    JSONObject dia = new JSONObject();
                        // Array hores
                        JSONArray hores = new JSONArray();
                        // Hores dins del dia
                        for (int j = PlaEstudis.getHoraInici(); j < PlaEstudis.getHoraFi(); j++) {
                            JSONObject hora = new JSONObject();
                                Casella c = m.getCasella(i,j);
                                if (c != null) {
                                    JSONObject cas = new JSONObject();
                                        cas.put("nomAssig", c.getNomAssig());
                                        cas.put("numGrup", c.getNumGrup());
                                        cas.put("tipus", c.getTipus().toString());
                                    hora.put(j, cas);
                                    hores.add(hora);
                                }
                        }
                    dia.put(Enumeracio.Dia.values()[i].toString(),hores);
                    dies.add(dia);
                }

                aula.put("dies", dies);


            // Afegim aula a l'array general
            aules.add(aula);
        }

        // try-with-resources statement based on post comment below :)

        try {
            FileWriter file = new FileWriter("./src/Dades/Horaris/horari.json");
            file.write(aules.toJSONString());
            System.out.println("Successfully Copied JSON Object to File...");
            System.out.println("\nJSON Object: " + aules);
            file.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}