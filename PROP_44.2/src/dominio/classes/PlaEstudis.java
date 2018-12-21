package dominio.classes;

public class PlaEstudis {


    private PlaEstudis() {}

    private static PlaEstudis instance = new PlaEstudis();

    public static PlaEstudis getInstance() {
        return instance;
    }


    private static ConjuntAssignatures cjtAssignatures = new ConjuntAssignatures();
    private static ConjuntAules cjtAules = new ConjuntAules();

    private static int horaInici = -1;
    private static int horaFi = -1;
    private static int horaCanviFranja = -1;

    /**
     * Restablim els atributs per poder carregar un altre set de dades
     */
    public static void reset() {
        cjtAssignatures = new ConjuntAssignatures();
        cjtAules = new ConjuntAules();

        horaInici = -1;
        horaFi = -1;
        horaCanviFranja = -1;
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


    public static boolean isNull() {
        return horaInici == -1 && horaFi == -1 && horaCanviFranja == -1;
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


    /**
     * Obtenim un conjunt d'aules
     * @post retornem un ConjuntAules
     */
    public static ConjuntAules getConjuntAules() {
        return cjtAules;
    }

    /**
     * Obtenim un conjunt d'assignatures
     * @post retornem un ConjuntAssignatures
     */
    public static ConjuntAssignatures getConjuntAssignatures() {
        return cjtAssignatures;
    }

    public static void setCjtAssignatures(ConjuntAssignatures cjt) {
        cjtAssignatures = cjt;
    }

    public static void setCjtAules(ConjuntAules cjt) {
        cjtAules = cjt;
    }
}
