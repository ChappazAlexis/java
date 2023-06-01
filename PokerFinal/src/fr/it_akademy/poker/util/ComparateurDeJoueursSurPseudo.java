package fr.it_akademy.poker.util;

import java.util.Comparator;

import fr.it_akademy.poker.business.Joueur;

public class ComparateurDeJoueursSurPseudo implements Comparator<Joueur> {

	@Override
	public int compare(Joueur joueur1, Joueur joueur2) {
		return joueur1.getPseudo().compareTo(joueur2.getPseudo());
	}

}
