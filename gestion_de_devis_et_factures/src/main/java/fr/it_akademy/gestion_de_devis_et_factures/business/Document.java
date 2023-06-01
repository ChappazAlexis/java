package fr.it_akademy.gestion_de_devis_et_factures.business;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * La classe Document est abstraite, on ne pourra par conséquent
 * pas créer d'instance de type Document
 * 
 * @author admin
 *
 */
public abstract class Document {

	protected Client client;
	protected List<Ligne> lignes;
	protected LocalDateTime dateDeCreation;

	// Constructeur par défaut
	protected Document() {
		lignes = new ArrayList<>();
		dateDeCreation = LocalDateTime.now();
	}
	
	// Constructeur avec un paramètre de type Client
	protected Document(Client client) {
		this();
		//Le this ci-dessous lève l'ambiguité (entre le paramètre et l'attribut)
		this.client = client;
		// On ajoute le document en cours de création (this) à la liste des documents du client donné en paramètre
		client.getDocuments().add(this);
	}

	protected Document(Client client, LocalDateTime dateDeCreation) {
		this(client);
		// le mot clé this sert ici à lever l'ambiguité
		this.dateDeCreation = dateDeCreation;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Ligne> getLignes() {
		return lignes;
	}

	public void setLignes(List<Ligne> lignes) {
		this.lignes = lignes;
	}

	public LocalDateTime getDateDeCreation() {
		return dateDeCreation;
	}

	public void setDateDeCreation(LocalDateTime dateDeCreation) {
		this.dateDeCreation = dateDeCreation;
	}

	public float getTotal() {
		float total = 0;
		// On parcourt la liste des lignes du document
		for (Ligne ligne : lignes) {
			float remise = 0;
			if (ligne.getRemise()!=null) {
				remise = ligne.getRemise();
			}
			total += ligne.getArticle().getPrix()*ligne.getQuantite()*(1-remise);
		}
		return total;
	}
	
	@Override
	public String toString() {
		return "Document [client=" + client + ", lignes=" + lignes + ", dateDeCreation=" + dateDeCreation + "]";
	}
	
}