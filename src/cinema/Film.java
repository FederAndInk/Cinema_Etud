/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;



/**
 *
 * @author culeta
 */
public class Film implements java.io.Serializable, Comparable<Film> {
    
    private String		    nomFilm;
    private String		    realisateur;
    private static final DateFormat DF	    = new SimpleDateFormat("dd/mm/yyyy", Locale.FRANCE);
    private static final DateFormat DF_SHOW = new SimpleDateFormat("d MMMM, yyyy", Locale.FRANCE);
    private Date		    dateSortie;
    private HashMap<String, Role>   roles;
    
    
    public Film(String nomFilm, Acteur acteur, String role, String realisateur, Date dateSortie) {
	setRoles(new HashMap<>());
	setNomFilm(nomFilm);
	setRealisateur(realisateur);
	setDateSortie(dateSortie);
	
	addRole(new Role(this, role, acteur));
    }
    
    
    // ----------------------Methods-----------------------------
    
    public void addRole(Role role) {
	getRoles().put(role.getNomRole(), role);
	role.getActeur().addRole(role);
    }
    
    
    /**
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(Film o) {
	return getNomFilm().compareTo(o.getNomFilm());
    }
    
    
    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return getNomFilm() + " par " + getRealisateur() + " sortie en salle le " + DF_SHOW.format(getDateSortie());
    }
    
    
    // -------------------Getters&Setters------------------------
    
    public String getNomFilm() {
	return nomFilm;
    }
    
    
    private void setNomFilm(String nomFilm) {
	this.nomFilm = nomFilm;
    }
    
    
    /**
     * @return the realisateur
     */
    public String getRealisateur() {
	return realisateur;
    }
    
    
    /**
     * @param realisateur
     * the realisateur to set
     */
    private void setRealisateur(String realisateur) {
	this.realisateur = realisateur;
    }
    
    
    /**
     * @return the dateSortie
     */
    public Date getDateSortie() {
	return dateSortie;
    }
    
    
    /**
     * @param dateSortie
     * the dateSortie to set
     */
    private void setDateSortie(Date dateSortie) {
	this.dateSortie = dateSortie;
    }
    
    
    /**
     * @return the roles
     */
    public HashMap<String, Role> getRoles() {
	return roles;
    }
    
    
    /**
     * @param roles
     * the roles to set
     */
    public void setRoles(HashMap<String, Role> roles) {
	this.roles = roles;
    }
    
}
