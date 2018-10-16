package GeneradorHoraris;

public class Assignatura {
	
	// Atributs
	private int id;
	private String nom;
	private int nHTeo;
	private int nHLab;
	private int nHProb;

	
	// Mètodes
	
	// Constructores
	
	public Assignatura() {
		this.id = 0;
		this.nom = "Hola";
		this.nHTeo = 3;
		this.nHLab = 2;
		this.nHProb = 1;
	}
	
	public Assignatura(String nom, int id, int nHTeo, int nHLab, int nHProb) {
		this.id = id;
		this.nom = nom;
		this.nHTeo = nHTeo;
		this.nHLab = nHLab;
		this.nHProb = nHProb;
	}
	
	// Consultores
	
	public int getId() {
		return this.id;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public int getnHTeo() {
		return this.nHTeo;
	}
	
	public int getnHLab() {
		return this.nHLab;
	}
	
	public int getnHProb() {
		return this.nHProb;
	}
	
	//Modificadores
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setHTeo(int HTeo) {
		this.nHTeo = HTeo;
	}
	
	public void setHLab(int HLab) {
		this.nHLab = HLab;
	}
	
	public void setHProb(int HProb) {
		this.nHProb = HProb;
	}
	
}
