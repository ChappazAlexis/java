package fr.it_aka.machine_a_cafe;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import fr.it_aka.machine_a_cafe.business.Dosette;
import fr.it_aka.machine_a_cafe.business.TypeDeCafe;


public class App {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        Random random = new Random();
	
	        Dosette dosetteAConsommer = new Dosette();
	
	        int choix = 0;
	
	        // On déclare une collection de types de café
	        ArrayList<TypeDeCafe> typesDeCafe = new ArrayList<>();
	
	        // On déclare une collection de dosettes
	        ArrayList<Dosette> dosettes = new ArrayList<>();
	
	        TypeDeCafe colombie = new TypeDeCafe("Café Colombien", 0.5f);
	        TypeDeCafe perou = new TypeDeCafe("Café Péruvien", 0.4f);
	        TypeDeCafe bresil = new TypeDeCafe("Café Brésilien", 0.4f);
	        TypeDeCafe kenya = new TypeDeCafe("Café Kenyan", 0.5f);
	        System.out.println(colombie);
	        dosetteAConsommer.setTypeDeCafe(colombie);
	        System.out.println(dosetteAConsommer);
	}
}
