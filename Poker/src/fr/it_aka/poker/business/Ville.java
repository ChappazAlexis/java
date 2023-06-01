package fr.it_aka.poker.business;

import java.util.*;

/**
 * 
 */
public class Ville {

    private String nom;

    private String codePostal;

    private int nbHabitants;

    private double latitude;

    private double longitude;
    
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

	public int getNbHabitants() {
		return nbHabitants;
	}

	public void setNbHabitants(int nbHabitants) {
		this.nbHabitants = nbHabitants;
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

	/**
     * Default constructor
     */
    public Ville() {
    }

	@Override
	public String toString() {
		return "Ville [nom=" + nom + ", codePostal=" + codePostal + ", nbHabitants=" + nbHabitants + ", latitude="
				+ latitude + ", longitude=" + longitude + "]";
	}


}