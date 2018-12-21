package dominio.classes;

import dominio.controladores.CtrlDomini;
import dominio.controladores.CtrlDominiGenerarHorari;
import javafx.util.Pair;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class Horari {

    private Sessio fallo = null;

    private Map<Sessio, ArrayList<UAH>> assignacio;

    private Map<String, Matriu> horari;

    public Map<Sessio, ArrayList<UAH>> getAssignacio() {
        return assignacio;
    }

    public void setAssignacio(Map<Sessio, ArrayList<UAH>> assignacio) {
        this.assignacio = assignacio;
    }


    /**
     * Constructora per defecte
     */
    public Horari() {
        assignacio = new HashMap<>();
        horari = new HashMap<>();
    }


    public boolean esFallo() {
        return this.fallo != null;
    }

    public void setFallada(Sessio s) {
        this.fallo = s;
    }

    public void noEsFallo() {
        this.fallo = null;
    }

    public Sessio getFallo() { return this.fallo; }

    public void setHorari(Map<String, Matriu> horari) {
        this.horari = horari;
    }

    /**
     * Assigna la UAH uah a la sessió se
     * @param se sessió a la que volem assignar la UAH
     * @param uah que volem assignar a la sessió
     * @post la instància conté l'assignació entre se i uah
     */
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

    /**
     * Elimina la UAH uah de la sessió se
     * @param se sessió a la que volem eliminar la UAH
     * @param uah que volem eliminar de la sessió
     * @post la instància s'ha modificat i ja no conté l'assignació entre se i uah
     */
    public void eliminarUAH(Sessio se, UAH uah) {
        if (assignacio.containsKey(se)) {
            if (assignacio.get(se).contains(uah))
                assignacio.get(se).remove(uah);

            if (assignacio.get(se).isEmpty())
                assignacio.remove(se);
        }
    }

    public int comptaAssignacions() {
        int compt = 0;
        for (Sessio s : assignacio.keySet()) {
            compt += assignacio.get(s).size();
        }
        return compt;
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

    //TODO ELIMINAR
    /*
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
    */
    public boolean assignacioCompleta(Sessio s) {
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

    public boolean conflicteSessio(Sessio s, UAH uah) {
        if (assignacio.containsKey(s)) {
            for (UAH uah2 : assignacio.get(s)) {
                if (RestriccioBinaria.coincideixenUAH(uah, uah2))
                    return true;
            }
        }
        return false;
    }

    public void mapejaHorari() {
        for (Sessio s : assignacio.keySet()) {
            //io.writeln(s.getAssignatura().getNom() + " " + s.getIdGrup() + " " + s.getTipus());
            for (UAH uah : assignacio.get(s)) {
                String nomAula = uah.getAula().getId();
                int i = uah.getDia().ordinal();
                int j = uah.getHora();
                //io.writeln(nomAula + " " + uah.getDia() + " " + j + "\n");
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

    //TODO DELETE

    public void imprimirHorari() {
        try {
            int nSess = 0;
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
                for (int hora = CtrlDomini.getPlaEstudis().getHoraInici(); hora < CtrlDomini.getPlaEstudis().getHoraFi(); hora++) {
                    io.write(hora + "h       ");
                    for (Enumeracio.Dia dia : Enumeracio.Dia.values())
                        if (horari.get(aula).getCasella(dia.ordinal(), hora) == null)
                            io.write("    --------    ");
                        else {
                            ++nSess;
                            String nomAssig = horari.get(aula).getCasella(dia.ordinal(), hora).getNomAssig();
                            int grup = horari.get(aula).getCasella(dia.ordinal(), hora).getNumGrup();
                            String sigla = "?";
                            switch (horari.get(aula).getCasella(dia.ordinal(), hora).getTipus()) {
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
                            io.write("    " + nomAssig + " " + grup + " " + sigla + "    ");
                        }




                    io.writeln("");
                }
            }
            io.writeln("");
            CtrlDominiGenerarHorari.comptaSessions();
            io.writeln(nSess + " sessions imprimides");
        }
        catch (Exception e) {
            System.out.println("No s'ha pogut imprimir l'horari");
        }


    }



    // String[Aula][Dia][Hora][Assig]
    public ArrayList<Pair<String, String[][][]>> passarString() {

        int nAules = horari.keySet().size();
        int nDies = 5;
        int nHores = CtrlDomini.getPlaEstudis().getHoraFi() - CtrlDomini.getPlaEstudis().getHoraInici();
        int nAssig = CtrlDomini.getPlaEstudis().getConjuntAssignatures().getAssignatures().size();


        // Como lo puedo declarar ¿?
        // Problema:
        //
        //      · Necesito info de la Matriz por Assignatura.
        //      · Pair<String, String[][][]> <- Como se declara ¿?

        ArrayList<Pair<String, String[][][]>> horariText = new ArrayList<Pair<String, String[][][]>>();

        for (String aula : horari.keySet()) {
            String[][][] horariAula = new String[nDies][nHores][nAssig];
            for (int hora = CtrlDomini.getPlaEstudis().getHoraInici(); hora < CtrlDomini.getPlaEstudis().getHoraFi(); ++hora) {
                for (int dia = 0; dia < nDies; ++dia) {

                    if(horari.get(aula).getCasella(dia, hora) != null) {
                        horariAula[dia][hora-CtrlDomini.getPlaEstudis().getHoraInici()][0] = horari.get(aula).getCasella(dia, hora).getNomAssig();
                        horariAula[dia][hora-CtrlDomini.getPlaEstudis().getHoraInici()][1] = String.valueOf(horari.get(aula).getCasella(dia, hora).getNumGrup());
                        horariAula[dia][hora-CtrlDomini.getPlaEstudis().getHoraInici()][2] = "?";
                        switch (horari.get(aula).getCasella(dia, hora).getTipus()) {
                            case TEORIA:
                                horariAula[dia][hora-CtrlDomini.getPlaEstudis().getHoraInici()][2] = "T";
                                break;
                            case LABORATORI:
                                horariAula[dia][hora-CtrlDomini.getPlaEstudis().getHoraInici()][2] = "L";
                                break;
                            case PROBLEMES:
                                horariAula[dia][hora-CtrlDomini.getPlaEstudis().getHoraInici()][2] = "P";
                                break;
                        }
                    }
                    else {
                        horariAula[dia][hora-CtrlDomini.getPlaEstudis().getHoraInici()][0] = null;
                        horariAula[dia][hora-CtrlDomini.getPlaEstudis().getHoraInici()][1] = null;
                        horariAula[dia][hora-CtrlDomini.getPlaEstudis().getHoraInici()][2] = null;
                    }
                }
            }
            Pair<String, String[][][]> elementHorari = new Pair<String, String[][][]>(aula, horariAula);
            horariText.add(elementHorari);
        }



        return horariText;
    }


}
