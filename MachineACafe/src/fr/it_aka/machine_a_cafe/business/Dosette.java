package fr.it_aka.machine_a_cafe.business;

import java.util.*;

/**
 * 
 */
public class Dosette {

    private Long id;

    private static Long compteur;
    
    private TypeDeCafe typeDeCafe;
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TypeDeCafe getTypeDeCafe() {
		return typeDeCafe;
	}

	public void setTypeDeCafe(TypeDeCafe typeDeCafe) {
		this.typeDeCafe = typeDeCafe;
	}

	public Dosette() {
    }

	@Override
	public String toString() {
		return "Dosette [id=" + id + ", typeDeCafe=" + typeDeCafe + "]";
	}
}