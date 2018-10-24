package GeneradorHoraris;

import java.util.*;

public class ConjuntAules {
    Set<Aula> conjuntAules = new HashSet<Aula>();

    public void afegirAula(int id, int capacitat, Aula.TipusAula tipus) {
        Aula a = new Aula(id,capacitat,tipus);
        conjuntAules.add(a);
    }

    public void eliminarAula(Aula a) {
        conjuntAules.remove(a);
    }

}
