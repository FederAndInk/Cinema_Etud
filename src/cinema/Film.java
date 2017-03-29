/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author culeta
 */
public class Film implements java.io.Serializable {

    private String nomFilm;
    private String realisateur;
    private Date dateSortie;
    private ArrayList<Role> roles;

    public Film(String nomFilm, Role role) {
        this.setNomFilm(nomFilm);
        addrole(role);
    }

    public Film(String nomFilm, String realisateur, Date dateSortie, Role role) {
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
    public Date getDateSortie() {
        return dateSortie;
    }

    /**
     * @param dateSortie the dateSortie to set
     */
    public void setDateSortie(Date dateSortie) {
        this.dateSortie = dateSortie;
    }

    public void addrole(Role role) {
        roles.add(role);
    }

    public void afficheroles() {
        for (Role role : roles) {
            System.out.println(role.getNomRole());
            System.out.println(role.getActeur().getNomActeur());
        }
    }

}
