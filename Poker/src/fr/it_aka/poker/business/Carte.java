package fr.it_aka.poker.business;


import java.util.*;

public class Carte {

    private int valeur;

    private String nom;

    private Couleur couleur;

	private Couleur Couleur;
    
    public int getValeur() {
		return valeur;
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

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}



	/**
     * Default constructor
     */
    public Carte(int valeur, Couleur couleur) {
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


	@Override
	public String toString() {
		return "Carte [valeur=" + valeur + ", nom=" + nom + ", couleur=" + couleur + "]";
	}



}