package fr.it_akademy.poker;

import fr.it_akademy.poker.business.*;
import fr.it_akademy.poker.util.ComparateurDeJoueursSurPseudo;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;

public class App {
	
	// On déclare une liste de couleurs
	// Cette liste va contenir des objets de type Couleur -> List<Couleur>
	// une collection est soit une liste (List) soit un ensemble (Set)
	private static List<Couleur> couleurs = new ArrayList<>();
	private static List<Carte> cartes = new ArrayList<>();
	private static List<Joueur> joueurs = new ArrayList<>();
	private static List<Ville> villes = new ArrayList<>();
	private static Scanner scanner = new Scanner(System.in);
	
	// la méthode main rend le projet exécutable
	public static void main(String[] args) {
		
//		StringBuilder stringBuilder = new StringBuilder();
//		stringBuilder.append(false);
//		stringBuilder.append('a').append(4).append("Coucou");
//		
//		String chaine = stringBuilder.toString();
//		System.out.println(chaine);
		
		System.out.println("Nombre de lignes lues : " + importerVilles());
		
		constituerJeu();
		melangerJeu();
		ajouterJoueurs();
		ajouterJoueur();
		afficherJeu();
		trierJoueurs();
		distribuerCartes();

		for (Joueur joueur : joueurs) {
			System.out.println(joueur);
			System.out.println(analyserMain(joueur));
		}

		Collections.sort(cartes);
		System.out.println(cartes);
	}

	private static void trierJoueurs() {
		Collections.sort(joueurs, new ComparateurDeJoueursSurPseudo());
	}

	/**
	 * Cette méthode renvoie la combinaison obtenue par le joueur donné en paramètre
	 * 
	 * @param joueur
	 * @return
	 */
	private static Combinaison analyserMain(Joueur joueur) {
		
		boolean estMemeCouleur = false;
		
		// comment déterminer qu'un joueur a obtenu deux cartes de même valeur (une paire) ?
		// pourquoi ne pas créer un tableau d'occurrences ?
		// si j'ai une paire de 5, dans ce tableau d'occurrences, on aura : 
		// occurrences[5]=2
		// si j'ai un brelan de 7, dans ce tableau d'occurrences, on aura : 
		// occurrences[7]=3
		int[] occurrences = new int[15]; // Tableau de 15 cases, les première et deuxième cases ne vont pas servir
		
		int a = 1;
		int b = 2;
		int c = 3;
		
		// && : et alors
		// si a>b et alors b>c
		if (a>b && b>c) {
			System.out.println("ok");
		}
		
		// Si on a une couleur en coeur : occurrencesParCouleur[0]=5
		int[] occurrencesParCouleur = new int[4];
		
		// On parcourt les cartes qui sont dans la main du joueur
		for (Carte carte : joueur.getMain()) {
			occurrences[carte.getValeur()]++;
		}

		for (int i = 0; i < occurrences.length; i++) {
			System.out.print(occurrences[i]);
		}

		System.out.println();
		
		// Nico : si le tableau contient 4 dans une de cases x
		// return Combinaison.CARRE
		
		// Michel : détection d'un FULL x
		
		// Pauline : détection d'une SUITE
		
		// Antoine : détection d'une QUINTE_FLUSH x
		
		// Alexis : détection d'une DOUBLE_PAIRE x
		
		// Corentin : détection d'une COULEUR x
		
		// Johan : détection d'une QUINTE_FLUSH_ROYALE x
		
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
			System.out.println(couleur);
			for (int i = 2; i <= 14; i++) {
				cartes.add(new Carte(couleur, i));
			}
		}
	}
	
	private static void melangerJeu() {
		Collections.shuffle(cartes);
	}
	
	/**
	 * FX demande que la méthode ait un nom qui débute par un verbe à l'infinitif
	 */
	private static void ajouterJoueur() {
		
		// on demander à l'utilisateur de saisir son pseudo puis un code postal
		// on affiche toutes les villes liées à ce code postal
		// on demande à l'utilisateur de saisir l'id de sa ville
		// on instancie un nouveau joueur en utilisant l'id de la ville et le pseudo saisi
		// on ajoute le nouveau joueur dans la liste des joueurs
		
		System.out.print("Veuillez saisir votre pseudo : ");
		String pseudo = scanner.nextLine();
		// On instancie un objet de type Joueur
		Joueur joueur = new Joueur(pseudo);
		System.out.print("Veuillez saisir un code postal : ");
		String codePostal = scanner.nextLine();
		
		List<Ville> villesCorrespondantes = new ArrayList<>();
		
		for (Ville ville : villes) {
			if (ville.getCodePostal().equals(codePostal)) {
				villesCorrespondantes.add(ville);
			}
		}
		Collections.sort(villesCorrespondantes);
		
		for (Ville ville : villesCorrespondantes) {
			System.out.println(ville.getId() + " : " + ville.getNom() + " (" + ville.getLatitude() + ")");
		}
		
		System.out.print("Entrez l'id de votre ville : ");
		Long idVille = scanner.nextLong();
		scanner.close();
		
		for (Ville ville : villes) {
			if (ville.getId().equals(idVille)) {
				joueur.setVille(ville);
			}
		}
		try {
			Joueur clone = joueur.clone();
			joueurs.add(clone);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		joueurs.add(joueur);
	}
	
	private static void ajouterJoueurs() {
		Joueur pauline = new Joueur("Pauline");
		joueurs.add(pauline);
		joueurs.add(new Joueur("Alexis"));
		joueurs.add(new Joueur("Antoine"));
		joueurs.add(new Joueur("Corentin"));
		joueurs.add(new Joueur("Johan"));
		joueurs.add(new Joueur("Michel"));
		Joueur nicolas = new Joueur("Nicolas");
		Joueur nicolas2 = nicolas;
		System.out.println(nicolas.hashCode());
		System.out.println(nicolas2.hashCode());
		try {
			Joueur cloneDeNicolas = nicolas.clone();
			System.out.println(cloneDeNicolas.hashCode());
			joueurs.add(cloneDeNicolas);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		joueurs.add(new Joueur("Nicolas"));
		
	}
	
	private static int importerVilles() {

        // Partie déclarative
        int compteur = 0;
        // On déclare un objet de type URL
        URL url = null;

        // Partie traitement
        try {
        	// On renseigne l'URL en paramètre du constructeur de la classe URL
            url = new URL("https://www.clelia.fr/villes2020.csv");
        } catch (MalformedURLException e) {
                System.out.println("Fichier CSV indisponible, raison : " + e.getMessage());
                System.exit(-1);
        }
        // On parcourt le fichier CSV en utilisant l'API Java I/O et plus particulièrement un InputStream
        // obtenu en invoquant la méthode openStream() sur l'objet url : url.openStream();
        
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

        return compteur;
	}
}
