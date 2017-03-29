package cinema;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;



/**
 *
 * @author culeta
 */

public class Appli {
    
    private HashMap<String, Acteur> lesActeurs;
    private HashMap<String, Film>   lesFilms;
    
    
    // -------------------Constructors------------------------
    
    public Appli() {
	setActeurs(new HashMap<String, Acteur>());
	setFilms(new HashMap<String, Film>());
    }
    
    
    // ----------------------Methods-----------------------------
    
    private void addActeur(Acteur a, String nomActeur) {
	getActeurs().put(nomActeur, a);
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
	
	Scanner sc = new Scanner(System.in); // TODO can we make this as a field ?
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
	
	Scanner sc = new Scanner(System.in);
	String inp;
	String film = "";
	String realisateur;
	String role;
	Acteur acteur;
	Date date;
	String dateS;
	DateFormat df = new SimpleDateFormat("dd/mm/yyyy", Locale.FRANCE);
	Film filmTemp;
	boolean loop = false;
	// --------------------------acteur
	do {
	    if (loop) {
		System.out.println("acteur inexistant :(");
	    } // end if
	    System.out.println("Saisissez un acteur, entrer pour abandonner : ");
	    inp = sc.nextLine();
	    System.out.println(inp.trim());
	    loop = true;
	} while ((acteur = getActeur(inp)) == null && inp.length() > 0);
	loop = false;
	// --------------------------film
	if (inp.length() > 0 && getActeur(inp) != null) {
	    do {
		if (loop) {
		    System.out.println("film déjà existant :(");
		} // end if
		System.out.println("Saisissez un film, entrer pour abandonner : ");
		film = sc.nextLine();
		loop = true;
	    } while ((filmTemp = getFilm(film)) != null && film.length() > 0);
	    // --------------------------role real date
	    if (film.length() > 0 && inp.length() > 0) {
		System.out.println("Saisissez un role : ");
		role = sc.nextLine();
		
		System.out.println("Saisissez un realisateur : ");
		realisateur = sc.nextLine();
		do {
		    System.out.println("Saisissez la date de sortie du film (jj/mm/aaaa) : ");
		    dateS = sc.nextLine();
		    try {
			date = df.parse(dateS);
			loop = false;
			addFilm(new Film(film, acteur, role, realisateur, date), film);
		    } catch (ParseException e) {
			System.out.println("Date invalide");
			loop = true;
		    }
		} while (loop);
	    }
	} // end if
	
    }
    
    
    /**
     * Enregistrement d'un autre acteur pour un film
     * Un message de confimation est affiché à l'issue de la création.
     * Un message d'erreur est affiché pour chaque cas d'erreur (film non enregistré, acteur inexistant, acteur déjà affecté au film
     * role déjà attribué)
     */
    public void ajouterActeurFilm() {
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Saisissez un film : ");
	Film film = getFilm(sc.nextLine());
	if (film == null) {
	    System.out.println("Le film est inexisant :(");
	} else {
	    
	    System.out.println("Saisissez un acteur : ");
	    Acteur acteur = getActeur(sc.nextLine());
	    if (acteur == null) {// ---------------------acteur
		System.out.println("L'acteur est inexistant :(");
	    } else {
		
		if (acteur.getRoles().containsKey(film.getNomFilm())) {
		    System.out.println("L'acteur joue déjà dans le film :(");
		} else {// --------------------role
		    
		    System.out.println("Saisissez un role : ");
		    String role = sc.nextLine();
		    if (film.getRoles().containsKey(role)) {
			System.out.println("Le role est déjà pris :(");
		    } else {// -------------toutes les conditions sont bonnes
			film.addRole(new Role(film, role, acteur));
			System.out.println(acteur.getNomActeur() + " à bien été ajouté au film " + film.getNomFilm()
				+ " il joue dans le role de " + role);
		    } // end if
		} // end if
	    }
	} // end if
    }
    
    
    /**
     * Affiche tous les films avec le réalisateur, année de sortie,les acteurs et leur rôle dans chacun des films
     */
    public void afficherFilms() {
	for (Iterator<Entry<String, Film>> iterator = getFilms().entrySet().iterator(); iterator.hasNext();) {
	    Film film = iterator.next().getValue();
	    System.out.println(film);
	    for (Role role : film.getRoles().values()) {
		System.out.println("  -> " + role.getNomRole() + " interpreté par " + role.getActeur().getNomActeur());
	    }
	} // end for
    }
    
    
    /**
     * Affiche tous les acteurs avec le rôle qu'ils ont joué dans chacun de leur film ainsi que réalisateur et année de sortie du film.
     */
    public void afficherActeurs() {
	for (Acteur acteur : getActeurs().values()) {
	    System.out.println(acteur.getNomActeur() + " à joué dans ");
	    for (Role role : acteur.getRoles().values()) {
		System.out.println("  -> " + role.getFilm() + " dans le role de " + role.getNomRole());
	    }
	} // end for
    }
    
    
    // -------------------Getters&Setters------------------------
    
    public HashMap<String, Acteur> getActeurs() {
	return lesActeurs;
    }
    
    
    private Acteur getActeur(String nomActeur) {
	return getActeurs().get(nomActeur);
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
}
