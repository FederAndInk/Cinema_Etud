package cinema;

import java.util.HashMap;
import java.util.Scanner;



/**
 *
 * @author culeta
 */

public class Appli {
    
    private HashMap<String, Acteur> lesActeurs;
    private HashMap<String, Film>   lesFilms;
    
    
    public Appli() {
	setActeurs(new HashMap<String, Acteur>());
	setFilms(new HashMap<String, Film>());
    }
    
    
    public HashMap<String, Acteur> getActeurs() {
	return lesActeurs;
    }
    
    
    private Acteur getActeur(String nomActeur) {
	return getActeurs().get(nomActeur);
    }
    
    
    private void addActeur(Acteur a, String nomActeur) {
	getActeurs().put(nomActeur, a);
    }
    
    
    public void setActeurs(HashMap<String, Acteur> lesActeurs) {
	this.lesActeurs = lesActeurs;
    }
    
    
    public void setFilms(HashMap<String, Film> lesFilms) {
	this.lesFilms = lesFilms;
    }
    
    
    public HashMap<String, Film> getFilms() {
	return lesFilms;
    }
    
    
    private Film getFilm(String nomFilm) {
	return getFilms().get(nomFilm);
    }
    
    
    private void addFilm(Film f, String nomFilm) {
	getFilms().put(nomFilm, f);
    }
    
    
    /**
     * Enregistrement d'un nouvel acteur
     * Un message de confimation est affiché à l'issue de la création.
     * Si l'acteur existe déjà, un message d'erreur est affiché
     */
    public void nouvelActeur() {
	
	Scanner sc = new Scanner(System.in);
	System.out.println("\nEnregistrement d'un acteur\n");
	System.out.print("Nom de l'acteur :\t");
	String nomActeur = sc.nextLine();
	
	if (getActeur(nomActeur) == null) {
	    Acteur acteur = new Acteur(nomActeur);
	    addActeur(acteur, nomActeur);
	    System.out.println("\n\tEnregistrement de l'acteur réalisé\n");
	} else {
	    System.out.println("\n\tUn acteur de même nom existe déjà\n");
	}
    }
    
    
    /**
     * Enregistrement d'un nouveau film avec l'acteur principal
     * Un message de confimation est affiché à l'issue de la création.
     * Un message d'erreur est affiché pour chaque cas d'erreur (film déjà enregistré, acteur inexistant)
     */
    public void nouveauFilm() {
	
    }
    
    
    /**
     * Enregistrement d'un autre acteur pour un film
     * Un message de confimation est affiché à l'issue de la création.
     * Un message d'erreur est affiché pour chaque cas d'erreur (film non enregistré, acteur inexistant, acteur déjà affecté au film
     * role déjà attribué)
     */
    public void ajouterActeurFilm() {
	
    }
    
    
    /**
     * Affiche tous les films avec le réalisateur, année de sortie,les acteurs et leur rôle dans chacun des films
     */
    public void afficherFilms() {
	
    }
    
    
    /**
     * Affiche tous les acteurs avec le rôle qu'ils ont joué dans chacun de leur filmn ainsi que réalisateur et année de sortie du film.
     */
    public void afficherActeurs() {
	
    }
    
}
