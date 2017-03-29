package cinema;

import java.util.HashSet;



/**
 *
 * @author culeta
 */

public class Acteur implements java.io.Serializable {
    
    private String	  nomActeur;
    private HashSet<Role> roles;
    
    
    public Acteur(String nomActeur) {
	setNomActeur(nomActeur);
    }
    
    
    private void setNomActeur(String nomActeur) {
	this.nomActeur = nomActeur;
    }
    
    
    public String getNomActeur() {
	return nomActeur;
    }
    
}
