package fr.it_akademy.poker.business;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Joueur implements Comparable<Joueur>, Cloneable, Serializable {

	private static final long serialVersionUID = 1L;
	
	// Attributs
	private Long id;
	private String pseudo;
	private float solde;
	private LocalDate dateDeNaissance;
	private Ville ville;
	private List<Carte> main = new ArrayList<>();
	
	// Constante
	private static final float SOLDE_INITIAL = 50f;
	
	// Variable de classe
	// commune à tous les objets de la classe
	private static Long compteur = 0L;
	
	// Constructeurs
	public Joueur() {
		id = ++compteur;
		solde = SOLDE_INITIAL;
	}
	
	public Joueur(String pseudo) {
		this();
		this.pseudo = pseudo;
	}

	public Joueur(String pseudo, Ville ville) {
		this(pseudo);
		this.ville = ville;
	}

	public Joueur(String pseudo, float solde, Ville ville) {
		this(pseudo, ville);
		this.solde = solde;
	}

	// Getters/Setters
	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public float getSolde() {
		return solde;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}

	public LocalDate getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(LocalDate dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	/**
	 * Les cartes que le joueur a dans sa main
	 * 
	 * @return une liste d'objets de type Carte
	 */
	public List<Carte> getMain() {
		return main;
	}

	public void setMain(List<Carte> main) {
		this.main = main;
	}

	
	@Override
	public Joueur clone() throws CloneNotSupportedException {
		return (Joueur) super.clone();
	}

	@Override
	public String toString() {
		return "Joueur [pseudo=" + pseudo + ", solde=" + solde + ", dateDeNaissance=" + dateDeNaissance + ", ville="
				+ ville + ", main=" + main + "]" + super.hashCode();
	}

	@Override
	public int compareTo(Joueur autreJoueur) {
		return getPseudo().compareTo(autreJoueur.getPseudo());
	}
	
	
}
