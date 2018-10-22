package GeneradorHoraris;

public class Centre {

	// Atributs
	private int horaInici;
	private int horaFi;
	private int horaCanviFranja;

	// Mètodes

	// Constructores
	public Centre() {
		this.horaInici = 8;
		this.horaFi = 20;
		this.horaCanviFranja = 14;
	}
	
	public Centre(int horaInici, int horaFi, int horaCanviFranja) {
		this.horaInici = horaInici;
		this.horaFi = horaFi;
		this.horaCanviFranja = horaCanviFranja;
	}
	
	// Consultores

	public int getHoraInici() { return horaInici; }

	public int getHoraFi() { return horaFi; }

	public int getHoraCanviFranja() { return horaCanviFranja; }


	// Modificadores
	
	public void setHoraInici(int hora) {
		this.horaInici = hora;
	}

	public void setHoraFi(int hora) {
		this.horaFi = hora;
	}

	public void setHoraCanviFranja(int hora) {
		this.horaCanviFranja = hora;
	}
	
	// Otros Métodos





}
