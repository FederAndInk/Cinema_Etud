package cinema;

import java.io.Serializable;

/**
 *
 * @author culeta
 */

public class Acteur implements java.io.Serializable {
	
	private String nomActeur;

	public Acteur(String nomActeur) {
		this.setNomActeur(nomActeur);
	}

	private void setNomActeur(String nomActeur) {
		this.nomActeur = nomActeur;		
	}
        
        public String getNomActeur() {
		return nomActeur ;		
	}

        
}
