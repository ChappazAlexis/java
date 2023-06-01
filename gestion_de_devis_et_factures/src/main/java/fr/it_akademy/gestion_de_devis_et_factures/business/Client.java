package fr.it_akademy.gestion_de_devis_et_factures.business;

import java.util.ArrayList;
import java.util.List;

public class Client {

	private Long id;
	private String nom;
	private static Long compteur = 0L;
	private List<Document> documents;
	private Ville ville;
	
	public Client(String nom) {
		super();
		id = ++compteur;
		this.nom = nom;
		documents = new ArrayList<>();
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

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", documents=" + documents + "]";
	}
	
}