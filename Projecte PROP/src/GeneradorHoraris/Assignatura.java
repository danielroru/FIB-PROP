package GeneradorHoraris;

public class Assignatura {
	
	// Atributs
	private int id;
	private String nom;


	private int nHoresT;
	private int nHoresL;
	private int nHoresP;

	// Número de grups
	private int nGrupsT;
	private int nGrupsL;
	private int nGrupsP;

	// Grups de tardes
	private int nGrupsTarda;

	// Agrupació de blocs
	private int horesBlocT;
	private int horesBlocL;
	private int horesBlocP;

	// Mètodes

	// Constructores
	
	public Assignatura() {

	}
	
	public Assignatura(int id, String nom, int nHoresT, int nHoresL, int nHoresP,
					   int nGrupsT, int nGrupsL, int nGrupsP, int nGrupsTarda,
					   int horesBlocT, int horesBlocL, int horesBlocP) {
		this.id = id;
		this.nom = nom;

		// Quantitat d'hores
		this.nHoresT = nHoresT;
		this.nHoresL = nHoresL;
		this.nHoresP = nHoresP;

		// Quantitat de grups
		this.nGrupsT = nGrupsT;
		this.nGrupsL = nGrupsL; // Respecte el número de grups
		this.nGrupsP = nGrupsP; // Respecte el número de grups

		// Agrupació de les hores de classe amb blocs
		this.horesBlocT = horesBlocT;
		this.horesBlocL = horesBlocL;
		this.horesBlocP = horesBlocP;
	}
	
	// Consultores
	
	public int getId() {
		return this.id;
	}
	
	public String getNom() {
		return this.nom;
	}


	public int getnHoresT() {
		return this.nHoresT;
	}
	
	public int getnHoresL() {
		return this.nHoresL;
	}

	public int getnHoresP() {
		return this.nHoresP;
	}


	public int getnGrupsT() {
		return this.nGrupsT;
	}

	public int getnGrupsL() {
		return this.nGrupsL;
	}

	public int getnGrupsP() {
		return this.nGrupsP;
	}

	//Modificadores
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setHTeo(int HTeo) {
		this.nHoresT = HTeo;
	}
	
	public void setHLab(int HLab) {
		this.nHoresL = HLab;
	}
	
	public void setHProb(int HProb) {
		this.nHoresP = HProb;
	}
	
}
