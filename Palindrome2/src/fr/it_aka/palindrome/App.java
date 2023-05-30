package fr.it_aka.palindrome;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
	    String motSaisi= "", motReverse="";
        char caractere;
       
       
      System.out.print("votre mot: ");
      motSaisi = scanner.next();
      motSaisi = motSaisi.toLowerCase(); // passe motSaisi en minuscule
      for (int i=0; i<motSaisi.length(); i++)
      {
    	caractere= motSaisi.charAt(i); //recup chaque caractere
        motReverse= caractere+motReverse; //ajoute le caractere dans une string
      }
      System.out.println("mot inversé = "+ motReverse);
     
      
      if (motSaisi.equals(motReverse)) {
    	  System.out.println("palindrome");
      } else {
    	  System.out.println("pas palindrome");
      }
	}
}
