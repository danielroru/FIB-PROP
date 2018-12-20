package dominio.classes;

import javafx.util.Pair;

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

    /**
     * Constructora per defecte
     */
    public Horari() {
        assignacio = new HashMap<>();
        horari = new HashMap<>();
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

    public void mapejaHorari() {

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

    public void setHorari(Map<String, Matriu> horari) {
        this.horari = horari;
    }

    // String[Aula][Dia][Hora][Assig]
    public ArrayList<Pair<String, String[][][]>> passarString() {

        int nAules = horari.keySet().size();
        int nDies = 5;
        int nHores = PlaEstudis.getHoraFi() - PlaEstudis.getHoraInici();
        int nAssig = 3;


        // Como lo puedo declarar ¿?
        // Problema:
        //
        //      · Necesito info de la Matriz por Assignatura.
        //      · Pair<String, String[][][]> <- Como se declara ¿?

        String[][][] horariAula = new String[nDies][nHores][nAssig];
        ArrayList<Pair<String, String[][][]>> horariText = new ArrayList<Pair<String, String[][][]>>();

        int i = 0;
        for (String aula : horari.keySet()) {

            for (int hora = PlaEstudis.getHoraInici(); hora < PlaEstudis.getHoraFi(); ++hora) {
                for (int dia = 0; dia < nDies; ++dia) {

                    if(horari.get(aula).getCasella(dia, hora) != null) {
                        horariAula[dia][hora-PlaEstudis.getHoraInici()][0] = horari.get(aula).getCasella(dia, hora).getNomAssig();
                        horariAula[dia][hora-PlaEstudis.getHoraInici()][1] = String.valueOf(horari.get(aula).getCasella(dia, hora).getNumGrup());
                        horariAula[dia][hora-PlaEstudis.getHoraInici()][2] = "?";
                        switch (horari.get(aula).getCasella(dia, hora).getTipus()) {
                            case TEORIA:
                                horariAula[dia][hora-PlaEstudis.getHoraInici()][2] = "T";
                                break;
                            case LABORATORI:
                                horariAula[dia][hora-PlaEstudis.getHoraInici()][2] = "L";
                                break;
                            case PROBLEMES:
                                horariAula[dia][hora-PlaEstudis.getHoraInici()][2] = "P";
                                break;
                        }
                    }
                    else {
                        horariAula[dia][hora-PlaEstudis.getHoraInici()][0] = null;
                        horariAula[dia][hora-PlaEstudis.getHoraInici()][1] = null;
                        horariAula[dia][hora-PlaEstudis.getHoraInici()][2] = null;
                    }
                }
            }

            Pair<String, String[][][]> elementHorari = new Pair<String, String[][][]>(aula, horariAula);
            horariText.add(elementHorari);
            ++i;

        }


        return horariText;
    }
}