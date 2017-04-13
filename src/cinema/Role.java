/**
 *
 */
package cinema;

/**
 * @author nihil
 *
 */
public class Role implements java.io.Serializable {

    private String nomRole;
    private Film film;
    private Acteur acteur;

    // -------------------Constructors------------------------
    /**
     * @author nihil
     *
     * @param nomRole
     * @param film
     */
    public Role(String nomRole, Film film, Acteur acteur) {
        setNomRole(nomRole);
        setFilm(film);
        setActeur(acteur);
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
     * @param nomRole the nomRole to set
     */
    private void setNomRole(String nomRole) {
        this.nomRole = nomRole;
    }

    /**
     * @param film the film to set
     */
    private void setFilm(Film film) {
        this.film = film;
    }

    /**
     * @param acteur the acteur to set
     */
    private void setActeur(Acteur acteur) {
        this.acteur = acteur;
    }

}
