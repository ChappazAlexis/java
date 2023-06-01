package fr.it_aka.poker;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.it_aka.poker.business.Carte;
import fr.it_aka.poker.business.Combinaison;
import fr.it_aka.poker.business.Couleur;
import fr.it_aka.poker.business.Joueur;
import fr.it_aka.poker.business.Ville;

public class App {

	// On déclare une liste de couleurs
	// Cette liste va contenir des objets de type Couleur -> List<Couleur>
	// une collection est soit une liste (List) soit un ensemble (Set)
	private static List<Couleur> couleurs = new ArrayList<>();
	private static List<Carte> cartes = new ArrayList<>();
	private static List<Joueur> joueurs = new ArrayList<>();
	private static List<Ville> villes = new ArrayList<>();
    
    // la méthode main rend le projet exécutable
    public static void main(String[] args) {
        constituerJeu();
        melangerJeu();
        ajouterJoueurs();
        afficherJeu();
        distribuerCartes();
        importerVilles();

        for (Joueur joueur : joueurs) {
            System.out.println(joueur);
            System.out.println(analyserMain(joueur));
        }

    }

	private static Combinaison analyserMain(Joueur joueur) {
		// TODO Recuperer la valeur de la main carte par carte , voir si y'a des
		// similitude
		// TODO Si similitude faire switch en focntion des resemblance des valeurs
		// afficher enumCombinaison sinon carte haute

		boolean estDoublePair = false;
		boolean estPair = false;
		boolean estBrelan = false;
		boolean estSuite = false;
		boolean estMemeCouleur = false;
		boolean estFull = false;
		boolean estCarre = false;
		boolean estQuinte = false;
		boolean estQuinteRoyale = false;

		int[] occurences = new int[15];
		int[] occurencesParCouleurs = new int[4];

		for (Carte carte : joueur.getMain()) {
			occurences[carte.getValeur()]++;
		}
		for (int i = 0; i < occurences.length; i++) {
			// pair et double pair
			if (estPair == false && occurences[i] == 2) {
				estPair = true;
			} else if (occurences[i] == 2 && estPair == true) {
				estPair = false;
				estDoublePair = true;
			}

			// brelan
			if (occurences[i] == 3) {
				estBrelan = true;
			}

			// suite

			// couleur
			for (int v = 0; v < occurencesParCouleurs.length; v++) {
				// System.out.print(occurencesParCouleurs[v]);

				if (occurencesParCouleurs[v] == 5) {
					estMemeCouleur = true;
				}

				// full
				if (estBrelan == true && estPair == true) {
					estBrelan = false;
					estPair = false;
					estFull = true;
				}

				// carre
				if (occurences[i] == 4) {
					estCarre = true;
				}

				// quinte flush
				if (occurences[14] == 1 && occurences[13] == 1 && occurences[12] == 1 && occurences[11] == 1
						&& occurences[10] == 1) {
					estQuinte = true;
				}

				// royal quinte flush
				if (estQuinte == true && estMemeCouleur == true) {
					estQuinte = false;
					estMemeCouleur = false;
					estQuinteRoyale = true;
				}

				// System.out.print(occurences[i]);
			}

			// return le résultat
			if (estPair == true) {
				return Combinaison.PAIRE;
			} else if (estDoublePair == true) {
				return Combinaison.DOUBLE_PAIR;
			} else if (estBrelan == true) {
				return Combinaison.BRELAN;
			} else if (estSuite == true) {
				return Combinaison.SUITE;
			} else if (estCarre == true) {
				return Combinaison.CARRE;
			} else if (estMemeCouleur == true) {
				return Combinaison.COULEUR;
			} else if (estQuinte == true) {
				return Combinaison.QUINTE_FLUSH;
			} else if (estQuinteRoyale == true) {
				return Combinaison.QUINTE_FLUSH_ROYALE;
			}
		}
		return Combinaison.CARTE_HAUTE;
	}

	private static void distribuerCartes() {
		for (int i = 0; i < 5; i++) {
			for (Joueur joueur : joueurs) {
				// On remet au joueur la carte au sommet de la pile de cartes
				// joueur.getMain() : renvoie la main du joueur
				joueur.getMain().add(cartes.remove(0));
			}
		}
	}

	private static void afficherJeu() {
		System.out.println(cartes);
	}

	private static void constituerJeu() {

		// On instancie une couleur
		Couleur coeur = new Couleur("Coeur");
		Couleur pique = new Couleur("Pique");
		Couleur trefle = new Couleur("Trèfle");
		Couleur carreau = new Couleur("Carreau");

		couleurs.add(coeur);
		couleurs.add(pique);
		couleurs.add(trefle);
		couleurs.add(carreau);

		// On parcourt la collection de couleurs
		// forEach
		for (Couleur couleur : couleurs) {
			// System.out.println(couleur);
			for (int i = 2; i <= 14; i++) {
				cartes.add(new Carte(couleur, i));
			}
		}
	}

	private static void melangerJeu() {
		Collections.shuffle(cartes);
	}

	private static void ajouterJoueurs() {
//		Joueur pauline = new Joueur("Pauline");
//		System.out.println(pauline);
		joueurs.add(new Joueur("Alexis"));
		joueurs.add(new Joueur("Antoine"));
		joueurs.add(new Joueur("Corentin"));
		joueurs.add(new Joueur("Fx"));
		joueurs.add(new Joueur("Johan"));
		joueurs.add(new Joueur("Michel"));
		joueurs.add(new Joueur("Nicolas"));
		joueurs.add(new Joueur("Pauline"));
	}

	private static void importerVilles() {

		// partie déclarative
		int compteur = 0;
		// on déclare un objet de type url
		URL url = null;
		// partie Traitement
		try {
			// on renseigne l'url en paramètre du constructeur de la classe URL
			url = new URL("https://www.clelia.fr/villes2020.csv");
		} catch (MalformedURLException e) {
			System.out.println("Fichier CSV indisponible, raison : " + e.getMessage());
			System.exit(-1);
		}
		// parcours le fichier CSV en utilisant l'api java I/O et plus
		// particulièrement un Inputstream en invoquant la méthode openStream()
		// sur l'objet url : urlopenStream();
		
		
		// Utilisation d'un try with resources (les ressources seront fermées par Java)
        try (Reader reader = new InputStreamReader(url.openStream(), "UTF-8");
             BufferedReader bufferedReader = new BufferedReader(reader);
        ) {

                String ligne = "";
                // On lit la première ligne du fichier CSV
                // qui correspond à l'entête
                bufferedReader.readLine();

                // Tant qu'il y a des lignes à lire dans le fichier CSV
                while ((ligne = bufferedReader.readLine()) != null) {
                        String[] elements = ligne.split(";");
                        // On récupère le nom de la ville
                        // dans la deuxième colonne
                        String nom = elements[1];
                        String codePostal = elements[2];
                        double latitude = 0;
                        double longitude = 0;
                       
                        // Certaines lignes n'ont pas de coordonnées
                        // si la ligne contient 6 données
                        // (length renvoie le nombre de cases du tableau)
                        if (elements.length == 6) {
                                String coordonnees = elements[5];
                                latitude = Double.parseDouble(coordonnees.split(",")[0]);
                                longitude = Double.parseDouble(coordonnees.split(",")[1]);
                        }
                        
                        Ville ville = new Ville();
                        ville.setNom(nom);
                        ville.setCodePostal(codePostal);
                        ville.setLongitude(longitude);
                        ville.setLatitude(latitude);
                        villes.add(ville);
                        compteur++;
                }

        } catch (IOException e) {
                System.out.println("Erreur lors de la lecture " + e.getMessage());
        }

        return;

	}
	}
}
