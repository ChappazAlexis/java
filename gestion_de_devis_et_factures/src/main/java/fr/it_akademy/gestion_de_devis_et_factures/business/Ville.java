package fr.it_akademy.gestion_de_devis_et_factures.business;

public class Ville {

	// KISS : Keep It Stupid Simple
	// DRY : Don't Repeat Yourself
	// YAGNI : You Are Go
	private Long id;
	
	private static Long compteur = 0L;
	
	private String codeInsee;
	private String nom;
	private String codePostal;
	private double longitude;
	private double latitude;
	private String complement;
	
	public Ville() {
		id = ++compteur;
	}
	
	public Ville(String codeInsee, String nom, String codePostal) {
		this();
		this.codeInsee = codeInsee;
		this.nom = nom;
		this.codePostal = codePostal;
	}
	
	public Ville(String codeInsee, String nom, String codePostal, String complement) {
		this(codeInsee, nom, codePostal);
		this.complement = complement;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodeInsee() {
		return codeInsee;
	}

	public void setCodeInsee(String codeInsee) {
		this.codeInsee = codeInsee;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	@Override
	public String toString() {
		return "Ville [id=" + id + ", codeInsee=" + codeInsee + ", nom=" + nom + ", codePostal=" + codePostal
				+ ", longitude=" + longitude + ", latitude=" + latitude + ", complement=" + complement + "]";
	}
		
}