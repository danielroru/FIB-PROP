package Dominio;

public class PlaEstudis {

    ////////////////////////////////////////////////////////////////////
    ///// ATRIBUTS
    ////////////////////////////////////////////////////////////////////

    private static int horaInici;
    private static int horaFi;
    private static int horaCanviFranja;


    ////////////////////////////////////////////////////////////////////
    ///// CONSTRUCTORES
    ////////////////////////////////////////////////////////////////////

    public PlaEstudis(){

    }

    public PlaEstudis(int horaInici, int horaFi, int horaCanviFranja) {
        this.horaInici = horaInici;
        this.horaFi = horaFi;
        this.horaCanviFranja = horaCanviFranja;
    }

    ////////////////////////////////////////////////////////////////////
    ///// GETTERS
    ////////////////////////////////////////////////////////////////////

    public static int getHoraInici() {
        return horaInici;
    }

    public static int getHoraFi() {
        return horaFi;
    }

    public static int getHoraCanviFranja() {
        return horaCanviFranja;
    }

    ////////////////////////////////////////////////////////////////////
    ///// SETTERS
    ////////////////////////////////////////////////////////////////////

    public void setHoraInici(int horaInici) {
        this.horaInici = horaInici;
    }

    public void setHoraFi(int horaFi) {
        this.horaFi = horaFi;
    }

    public void setHoraCanviFranja(int horaCanviFranja) {
        this.horaCanviFranja = horaCanviFranja;
    }



}
