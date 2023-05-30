package fr.it_akademy.horloge_de_berlin;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		
		  Scanner scanner = new Scanner(System.in);
		  // Declaration var
		  int heureSaisi = 0;
		  int minuteSaisi = 0;
		  
		  
		  // saisi heure et minute
		  System.out.println("Bienvenue sur l'horloge de Berlin");
		  System.out.println("Veuillez saisir les heures (00-23)");
		  heureSaisi = scanner.nextInt();
		  System.out.println("Veuillez saisir les minutes (01-59)");
		  minuteSaisi = scanner.nextInt();
		  
		  System.out.println("Vous avez saisi : " + heureSaisi +":"+ minuteSaisi);
		  
		  // affiche horloge de berlin
		  
		  //Affiche les heures *5
		  while(heureSaisi !=0 && heureSaisi >= 5) {
			  heureSaisi = heureSaisi - 5;
			  System.out.print("X");
		  } 
		  System.out.println(""); // saut de ligne
		  
		  while(heureSaisi !=0) {
			  heureSaisi = heureSaisi - 1;
			  System.out.print("x");
		  }
		  System.out.println(""); // saut de ligne
		  
		  // minutes
		  while(minuteSaisi !=0 && minuteSaisi >= 5) {
			  minuteSaisi = minuteSaisi - 5;
			  System.out.print("O");
		  } 
		  System.out.println(""); // saut de ligne
		  while(minuteSaisi !=0) {
			  minuteSaisi = minuteSaisi - 1;
			  System.out.print("o");
		  }
	}
}
