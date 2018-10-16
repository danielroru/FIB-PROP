package GeneradorHoraris;

public class Aula {

	// Atributs
	
	private int id;
	private int capacitat;
	private boolean accesOrdinadors;
	private boolean disponible; 
	
	// Mètodes
	
	// Constructores
	
	public Aula() {
		this.id = 0;
		this.capacitat = 0;
		this.accesOrdinadors = false;
		this.disponible = true;
	}
	
	public Aula(int id, int capacitat, boolean accesOrdinadors, boolean disponible) {
		this.id = id;
		this.capacitat = capacitat;
		this.accesOrdinadors = accesOrdinadors;
		this.disponible = disponible;
	}
	
	// Consultores
	
	public int getId() {
		return this.id;
	}
	
	public int getCapacitat() {
		return this.capacitat;
	}
	
	public boolean getAccesOrdinadors() {
		return this.accesOrdinadors;
	}
	
	public boolean getDisponible() {
		return this.disponible;
	}
	
	// Modificadores
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setCapacitat(int capacitat) {
		this.capacitat = capacitat;
	}
	
	public void setAccesOrdinadors(boolean accesOrdinadors) {
		this.accesOrdinadors = accesOrdinadors;
	}
	
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
}
