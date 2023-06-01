package fr.it_aka.poker.business;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Joueur {

	// Attributs
	private String pseudo;
	private float solde;
	private LocalDate dateDeNaissance;
	private Ville ville;
	private List<Carte> main = new ArrayList<>();
	
	// Constructeurs
	public Joueur(String pseudo) {
		this.pseudo = pseudo;
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
	public String toString() {
		return "Joueur [pseudo=" + pseudo + ", solde=" + solde + ", dateDeNaissance=" + dateDeNaissance + ", ville="
				+ ville + ", main=" + main + "]";
	}
	
	
}
