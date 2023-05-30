package fr.it_aka.poker.business;


import java.util.*;

public class Couleur {

    private String nom;

    public Couleur(String nom) {
        super();
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Couleur [nom=" + nom + "]";
    }
    
}