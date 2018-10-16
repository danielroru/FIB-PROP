package GeneradorHoraris;

public class Nivell {
	
	// Atributs
	
	private int id;
	private String nom;
	private int nAssignatura;
	
	// Mètodes
	
	// Constructores
	
	public Nivell() {
		this.id = 0;
		this.nom = "Hola";
		this.nAssignatura = 3;
	}
	
	public Nivell(String nom, int id, int nAssignatura) {
		this.id = id;
		this.nom = nom;
		this.nAssignatura = nAssignatura;
	}
	
	// Consultores
	
	public int getId() {
		return this.id;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public int getNAssignatura() {
		return this.nAssignatura;
	}
	
	// Modificadores
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setNAssignatura(int nAssignatura) {
		this.nAssignatura = nAssignatura;
	}
}
