package Dominio;

public class PlaEstudis {

    ////////////////////////////////////////////////////////////////////
    ///// ATRIBUTS
    ////////////////////////////////////////////////////////////////////

    private int horaFi;
    private int horaCanviFranja;
    private int horaInici;

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

    public int getHoraInici() {
        return horaInici;
    }

    public int getHoraFi() {
        return horaFi;
    }

    public int getHoraCanviFranja() {
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
