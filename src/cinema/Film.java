/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema;

import java.util.Date;

/**
 *
 * @author culeta
 */
public class Film implements java.io.Serializable {

    private String nomFilm;
    private String realisateur;
    private Date dateSortie;

    public Film(String nomFilm) {
        this.setNomFilm(nomFilm);
    }

    public String getNomFilm() {
        return nomFilm;
    }

    private void setNomFilm(String nomFilm) {
        this.nomFilm = nomFilm;
    }

}
