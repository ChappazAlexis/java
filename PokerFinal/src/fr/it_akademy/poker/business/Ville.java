package fr.it_akademy.poker.business;

public class Ville implements Comparable<Ville> {

	// Attributs
	
	// Chaque ville aura un numéro unique
	private Long id;
	private String nom;
	private String codePostal;
	private double latitude;
	private double longitude;
	
	// Variable de classe
	// Il existera une seule instance de compteur en mémoire
	// 0L : autoboxing
	//private static Double compteur = 0.0;
	private static Long compteur = 0L;
	
	// Constructeur par défaut (default constructor)
	public Ville() {
		// D'abord on incrémente le compteur puis on l'affecte
		id = ++compteur;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	@Override
	public String toString() {
		return "Ville [id=" + id + ", nom=" + nom + ", codePostal=" + codePostal + ", latitude=" + latitude
				+ ", longitude=" + longitude + "]";
	}

	@Override
	public int compareTo(Ville autreVille) {
		// On montre à Java comment comparer deux objets de type Ville : this et le paramètre autreVille
		// si le nom de la ville this est égale au nom de l'autre ville, on renvoie 0
		return getNom().compareTo(autreVille.getNom());
		//return Double.valueOf(getLatitude()).compareTo(autreVille.getLatitude());
	}
	
}
