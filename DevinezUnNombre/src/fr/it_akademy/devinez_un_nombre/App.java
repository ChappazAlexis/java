package fr.it_akademy.devinez_un_nombre;

import java.util.Random;
// Scanner fait partie du package java.util
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        // Partie déclarative
        Random random = new Random();
        int nbADeviner = 0;
        int nbSaisi = 0;
        int nbEssais = 0;
        Scanner scanner = new Scanner(System.in);

        // Partie traitement
        nbADeviner = random.nextInt(100) + 1;
        
        // On reste dans la boucle tant que le nombre saisi est différent du nombre à deviner
        while (nbSaisi!=nbADeviner) {
            // nbEssais = nbEssais + 1;
            nbEssais++;
            System.out.print(nbEssais + ") Veuillez saisir un nombre entre 1 et 100 : ");
            // On affecte à nbSaisi ce que l'utilisateur a saisi au clavier
            nbSaisi = scanner.nextInt();
            if (nbSaisi > nbADeviner) {
                System.out.println("Plus petit");
            } else if (nbSaisi < nbADeviner) {
                System.out.println("Plus grand");
            }
            else {
                System.out.println("Bravo ! Vous avez trouvé en " + nbEssais + " essai");
            }            
        }
    }

}