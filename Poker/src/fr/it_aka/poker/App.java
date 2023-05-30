package fr.it_aka.poker;

import java.util.ArrayList;
import java.util.List;

import fr.it_aka.poker.business.Couleur;
import fr.it_aka.poker.business.Carte;

public class App {
	public static void main(String[] args) {
		List<Couleur> couleurs = new ArrayList<>();
		couleurs = List.of(new Couleur("Coeur"), new Couleur("Pique"), new Couleur("Carreau"), new Couleur("Trèfle"));
		System.out.println(couleurs);
		
		
		List<Carte> cartes = new ArrayList<>();
		// On parcourt la liste de couleurs (foreach)
		for (Couleur couleur : couleurs) {
		  // On crée 13 cartes de chaque couleur
		  // for avec les 3 "tions" : initialisation (i=2), condition (i<=14), incrémentation (i++)
		  for (int i = 2; i <=14; i++) {
		    cartes.add(new Carte(i, couleur));
		  }
		}
		
		System.out.println(cartes);
	}
}
