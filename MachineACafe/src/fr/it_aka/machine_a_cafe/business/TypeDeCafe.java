package fr.it_aka.machine_a_cafe.business;


import java.util.*;

/**
 * 
 */
public class TypeDeCafe {

    private Long id;

    private String nom;

    private float prix;

    private static Long compteur;


    public TypeDeCafe() {
    }

    public TypeDeCafe(String nom, float prix) {
		this.nom = nom;
		this.prix= prix;
	}
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "TypeDeCafe [id=" + id + ", nom=" + nom + ", prix=" + prix + "]";
	}

}