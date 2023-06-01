package fr.it_aka.poker.business;

/**
 * Cette classe représente le concept de couleur (coeur, pique, etc.)
 * 
 * @author admin
 *
 */
public class Couleur {

	// Attributs (glaçage)
	private String nom;


	// Constructeur(s)
	// si plusieurs constructeurs, on parle de surcharge de constructeurs (overload)
	/**
	 * Cette méthode est un constructeur pour constuire un objet de type Couleur
	 * Elle a en paramètre le nom de la couleur qui va servir à constuire le nouvel objet
	 * 
	 * @param nom
	 */
	public Couleur(String nom) {
		super();
		this.nom = nom;
	}

	
	// Getters/setters
	// getter : une méthode pour récupérer une valeur de l'objet
	// setter : une méthode pour définir une valeur de l'objet
	
	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}

	
	// toString
	// méthode qui servira à afficher l'objet
		@Override
	public String toString() {
		return "Couleur [nom=" + nom + "]";
	}
	
	
}
