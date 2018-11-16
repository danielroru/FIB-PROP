import java.util.*;

public class PlaEstudis {

    private static PlaEstudis instance = new PlaEstudis();

    private static ConjuntAssignatures cjtAssignatures = new ConjuntAssignatures();
    private static ConjuntAules cjtAules = new ConjuntAules();

    private static int horaInici;
    private static int horaFi;
    private static int horaCanviFranja;


    private PlaEstudis(){
    }

    public static PlaEstudis getInstance() {
        return instance;
    }

    // Consultores
    public static int getHoraInici() {
        return horaInici;
    }
    public static int getHoraFi() {
        return horaFi;
    }
    public static int getHoraCanviFranja() {
        return horaCanviFranja;
    }


    // Modificadores
    public static void setHoraInici(int hora) {
        horaInici = hora;
    }
    public static void setHoraFi(int hora) {
        horaFi = hora;
    }
    public static void setHoraCanviFranja(int hora) {
        horaCanviFranja = hora;
    }


    // Conjunt Aules

    public static void afegirAula(Aula a) {
        cjtAules.afegirAula(a);
    }

    public static ConjuntAules getConjuntAules() {
        return cjtAules;
    }

    // Conjunt Assignatures

    public static void afegirAssignatura(Assignatura a) {
        cjtAssignatures.afegirAssignatura(a);
    }

    public static ConjuntAssignatures getConjuntAssignatures() {
        return cjtAssignatures;
    }
}
