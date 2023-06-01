package fr.it_akademy.poker.business;

public class Carte implements Comparable<Carte> {

	private int valeur;
	private String nom;
	private Couleur couleur;
	
	// Constructeur
	public Carte(Couleur couleur, int valeur) {
		this.valeur = valeur;
		this.couleur = couleur;
		switch (valeur) {
		case 11:
			nom = "Valet";
			break;
		case 12:
			nom = "Dame";
			break;
		case 13:
			nom = "Roi";
			break;
		case 14:
			nom = "As";
			break;
		default:
			nom = String.valueOf(valeur);
			break;
		}
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public Couleur getCouleur() {
		return couleur;
	}


	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}

	@Override
	public String toString() {
		return nom + " de " + couleur.getNom();
	}

	@Override
	public int compareTo(Carte autreCarte) {
		// d'abord on trie les cartes sur la couleur puis sur la valeur
		if (getCouleur().equals(autreCarte.getCouleur())) {
			// les cartes sont de même couleur, on s'intéresse à la valeur des cartes
			return Integer.valueOf(getValeur()).compareTo(autreCarte.getValeur());
		}
		return getCouleur().compareTo(autreCarte.getCouleur());
	}
		
}
