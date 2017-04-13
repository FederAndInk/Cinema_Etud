/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema;

import java.util.HashMap;

/**
 *
 * @author culeta
 */
public class Film implements java.io.Serializable {

    private String nomFilm;
    private String realisateur;
    private String dateSortie;
    private HashMap<String, Role> roles = new HashMap<>(); // String = nom de role

    public Film(String nomFilm, String realisateur, String dateSortie) {
        setDateSortie(dateSortie);
        setNomFilm(nomFilm);
        setRealisateur(realisateur);
    }

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
     * @param realisateur the realisateur to set
     */
    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    /**
     * @return the dateSortie
     */
    public String getDateSortie() {
        return dateSortie;
    }

    /**
     * @param dateSortie the dateSortie to set
     */
    public void setDateSortie(String dateSortie) {
        this.dateSortie = dateSortie;
    }

    public void addrole(Role role) {
        roles.put(role.getNomRole(), role);
    }

    public HashMap<String, Role> getRoles() {
        return roles;
    }

}
