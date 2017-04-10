package cinema;

import java.util.HashMap;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;



/**
 *
 * @author culeta
 */

public class Acteur implements java.io.Serializable, Comparable<Acteur> {
    
    private String		  nomActeur;
    private HashMap<String, Role> roles;
    
    
    // -------------------Constructors------------------------
    /**
     * 
     * @author nihil
     *
     * @param nomActeur
     * init nomActeur
     */
    public Acteur(String nomActeur) {
	setNomActeur(nomActeur);
	setRoles(new HashMap<>());
    }
    
    
    // ----------------------Methods-----------------------------
    /**
     * 
     * @author nihil
     * Only Call in the Film class, for unidirectional calling to add an actor to a movie
     * @param role
     */
    protected void addRole(Role role) {
	try {
	    String callerClassName = new Exception().getStackTrace()[1].getClassName();
	    if (callerClassName == role.getFilm().getClass().getName()) {
		this.roles.put(role.getFilm().getNomFilm(), role);
	    } else {
		throw new IllegalAccessException(
			callerClassName + " does not have access to this method, please use Film.addRole instead");
	    } // end if
	} catch (IllegalAccessException e) {
	    e.printStackTrace();
	}
    }// end addRole
    
    
    // TODO : see if there is another way to do addRole ;)
    // protected boolean addRole(Role role) {
    // if (!role.getFilm().getRoles().contains(role)) {
    // roles.add(role);
    // return true;
    // } else {
    // return false;
    // } // end if
    // }// end addRole
    
    /**
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(Acteur arg0) {
	return getNomActeur().compareTo(arg0.getNomActeur());
    }
    
    
    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return getNomActeur();
    }
    
    
    // -------------------Getters&Setters------------------------
    @Setter
    private void setNomActeur(String nomActeur) {
	this.nomActeur = nomActeur;
    }
    
    
    /**
     * @author nihil
     *
     * @return the actor's name
     */
    @Getter
    public String getNomActeur() {
	return this.nomActeur;
    }
    
    
    /**
     * @return the roles
     */
    public HashMap<String, Role> getRoles() {
	return this.roles;
    }
    
    
    /**
     * @param roles
     * the roles to set
     */
    private void setRoles(HashMap<String, Role> roles) {
	this.roles = roles;
    }
    
}
