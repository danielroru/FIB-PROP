package GeneradorHoraris;

public class Centre {
	
	// Atributs
	private int id;
	private int nNivell;
	private int nAula;
	
	// Mètodes
	
	// Constructores
	public Centre() {
		this.id = 0;
		this.nNivell = 0;
		this.nAula = 0;
	}
	
	public Centre(int id, int nNivell, int nAula) {
		this.id = id;
		this.nNivell = nNivell;
		this.nAula = nAula;
	}
	
	// Consultores
	
	public int getId() {
		return id;
	}
	
	public int getNNivell() {
		return nNivell;
	}
	
	public int getNAula() {
		return nAula;
	}
	
	// Modificadores
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void getNNivell(int nNivell) {
		this.nNivell = nNivell;
	}
	
	public void getNAula(int nAula) {
		this.nAula = nAula;
	}
	
	// Otros Métodos
	
	public void crearAula() {
		++nAula;
	}
	
	public void crearNivell() {
		++nNivell;
	}
	
	public void eliminarAula() {
		--nAula;
	}
	
	public void eliminarNivell() {
		--nNivell;
	}
	
}
