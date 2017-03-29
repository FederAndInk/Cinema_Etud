/**
 * 
 */
package cinema;

import java.io.Serializable;



/**
 * @author nihil
 *
 */
public class Role implements Comparable<Role>, Serializable {
    private Film   film;
    private String nomRole;
    private Acteur acteur;
    
    // -------------------Constructors------------------------
    
    
    /**
     * @author nihil
     *
     * @param nomRole
     * @param film
     */
    protected Role(Film film, String nomRole, Acteur acteur) {
	setFilm(film);
	setNomRole(nomRole);
	setActeur(acteur);
    }
    
    
    // ----------------------Methods-----------------------------
    
    /**
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(Role o) {
	return getNomRole().compareTo(o.getNomRole());
    }
    
    
    // -------------------Getters&Setters------------------------
    /**
     * @return the nomRole
     */
    public String getNomRole() {
	return nomRole;
    }
    
    
    /**
     * @return the film
     */
    public Film getFilm() {
	return film;
    }
    
    
    /**
     * @return the acteur
     */
    public Acteur getActeur() {
	return acteur;
    }
    
    
    /**
     * @param nomRole
     * the nomRole to set
     */
    private void setNomRole(String nomRole) {
	this.nomRole = nomRole;
    }
    
    
    /**
     * @param film
     * the film to set
     */
    private void setFilm(Film film) {
	this.film = film;
    }
    
    
    /**
     * @param acteur
     * the acteur to set
     */
    private void setActeur(Acteur acteur) {
	this.acteur = acteur;
    }
    
}
