package dominio.classes;

public class UAH implements Comparable<UAH> {

    // Atributs

    private int hora;
    private Enumeracio.Dia dia;
    private Sessio sessio = new Sessio();
    private Aula aula = new Aula();

    // Mètodes

    // Constructores

    public UAH() {
    }

    public UAH (Sessio sessio, Aula aula, int hora, Enumeracio.Dia dia) {
        this.sessio = sessio;
        this.aula = aula;
        this.hora = hora;
        this.dia = dia;
    }

    public UAH (UAH uah) {
        this.sessio = uah.getSessio();
        this.aula = uah.getAula();
        this.hora = uah.getHora();
        this.dia = uah.getDia();
    }

    // Consultores


    public Sessio getSessio() {
        return sessio;
    }

    public void setSessio(Sessio sessio) {
        this.sessio = sessio;
    }

    public boolean teSessio() {
        return this.sessio.getTipus() != null;
    }

    public void eliminaSessio() {
        this.sessio = new Sessio();
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public int getHora() {
        return this.hora;
    }

    public Enumeracio.Dia getDia() {
        return dia;
    }

    // Modificadores

    public void setHora(int hora) {
        this.hora = hora;
    }

    public void setDia(Enumeracio.Dia dia) {
        this.dia = dia;
    }

    public int compareTo(UAH uah1) {

        int compareAula = (this.aula.getId()).compareTo(uah1.getAula().getId());
        int compareHora = ((Integer)this.getHora()).compareTo((Integer)uah1.getHora());
        int compareDia = (this.dia).compareTo(uah1.getDia());

        // 3-level comparison using if-else block
        if(compareAula == 0) {
            return ((compareHora == 0) ? compareDia : compareHora);
        }
        else {
            return compareAula;
        }
    }

}
