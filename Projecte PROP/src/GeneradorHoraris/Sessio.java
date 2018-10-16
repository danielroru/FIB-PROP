package GeneradorHoraris;

public class Sessio {

	// Atributs
	
	private int id;
	private int nHores;
	private boolean teoria;
	private boolean laboratori;
	private boolean problemes;
	
	// Mètodes
	
	// Constructores
	
	public Sessio() {
		this.id = 0;
		this.nHores = 0;
		this.teoria = true;
		this.laboratori = false;
		this.problemes = false;
	}
	
	public Sessio(int id, int nHores, boolean teoria, boolean laboratori, boolean problemes) {
		this.id = id;
		this.nHores = nHores;
		this.teoria = teoria;
		this.laboratori = laboratori;
		this.problemes = problemes;
	}
	
	// Consultores
	
	public int getId() {
		return this.id;
	}
	
	public int getNHores() {
		return this.nHores;
	}
	
	public boolean getTeoria() {
		return this.teoria;
	}
	
	public boolean getLaboratori() {
		return this.laboratori;
	}
	
	public boolean getProblemes() {
		return this.problemes;
	}
	
	// Modificadores
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setNHores(int nHores) {
		this.nHores = nHores;
	}
	
	public void setTeoria(boolean teoria) {
		this.teoria = teoria;
	}
	
	public void setLaboratori(boolean laboratori) {
		this.laboratori = laboratori;
	}
	
	public void setProblemes(boolean problemes) {
		this.problemes = problemes;
	}
}
