package cinema;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author culeta
 */
public class Appli {

    private HashMap<String, Acteur> lesActeurs;
    private HashMap<String, Film> lesFilms;

    public Appli() {
        this.setActeurs(new HashMap<String, Acteur>());
        this.setFilms(new HashMap<String, Film>());
    }

    public HashMap<String, Acteur> getActeurs() {
        return lesActeurs;
    }

    private Acteur getActeur(String nomActeur) {
        return getActeurs().get(nomActeur);
    }

    private void addActeur(Acteur a, String nomActeur) {
        this.getActeurs().put(nomActeur, a);
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
        this.getFilms().put(nomFilm, f);
    }

    /**
     * Enregistrement d'un nouvel acteur Un message de confimation est affiché à
     * l'issue de la création. Si l'acteur existe déjà, un message d'erreur est
     * affiché
     */
    public void nouvelActeur() {

        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnregistrement d'un acteur\n");
        System.out.print("Nom de l'acteur :\t");
        String nomActeur = sc.nextLine();

        if (this.getActeur(nomActeur) == null) {
            Acteur acteur = new Acteur(nomActeur);
            this.addActeur(acteur, nomActeur);
            System.out.println("\n\tEnregistrement de l'acteur réalisé\n");
        } else {
            System.out.println("\n\tUn acteur de même nom existe déjà\n");
        }
    }

    /**
     * Enregistrement d'un nouveau film avec l'acteur principal Un message de
     * confimation est affiché à l'issue de la création. Un message d'erreur est
     * affiché pour chaque cas d'erreur (film déjà enregistré, acteur
     * inexistant)
     */
    public void nouveauFilm() {

        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnregistrement d'un nouveau film\n");
        System.out.println("Nom du film :\t");
        String nomFilm = sc.nextLine();
        System.out.println("Date de sortie du film :\t");
        String date = sc.nextLine();
        System.out.println("nom du réalisateur :\t");
        String rea = sc.nextLine();
        System.out.println("nom de l'acteur principal :\t");
        String nomactpri = sc.nextLine();
        System.out.println("role de l'acteur principal :\t");
        String roleactpri = sc.nextLine();

        if (this.getFilm(nomFilm) == null) {

            Acteur acteur = getActeur(nomactpri);
            if (acteur != null) {
                Film film = new Film(nomFilm, rea, date);
                if (this.getFilm(nomFilm) == null) {
                    Role role = new Role(roleactpri, film, acteur);
                    film.addrole(role);
                    this.addFilm(film, nomFilm);
                    System.out.println("\n Enregistrement fait\n");
                    acteur.addrole(role);
                    System.out.println("\n le role a été affecté a l'acteur");
                } else {
                    System.out.println("Le film existe deja");
                }
            } else {
                System.out.println("L'ACTEUR N'EXISTE PAS");
            }

        } else {
            System.out.println("\n\tUn film de même nom existe déjà");
        }

    }

    /**
     * Enregistrement d'un autre acteur pour un film Un message de confimation
     * est affiché à l'issue de la création. Un message d'erreur est affiché
     * pour chaque cas d'erreur (film non enregistré, acteur inexistant, acteur
     * déjà affecté au film, role déjà attribué)
     */
    public void ajouterActeurFilm() {
        Scanner sc = new Scanner(System.in);
        System.out.println("nom de l'acteur :\t");
        String nomact = sc.nextLine();
        System.out.println("Nom du film :\t");
        String nomFilm = sc.nextLine();
        System.out.println("role de l'acteur :\t");
        String roleact = sc.nextLine();
        if ((getActeur(nomact) != null) && (getFilm(nomFilm) != null)) {
            if (getFilm(nomFilm).getRoles().containsKey(roleact)) {
                System.out.println("le role est deja attribué");
            } else if (getActeur(nomact).getRoles().containsKey(nomFilm)) {
                System.out.println("l'acteur a deja un role dans le film");
            } else {
                Role role = new Role(nomFilm, getFilm(nomFilm), getActeur(nomact));
                getFilm(nomFilm).addrole(role);
                getActeur(nomact).addrole(role);
                System.out.println("c'est fait!");
            }
        } else {
            System.out.println("l'acteur ou le film n'existe pas");
        }
    }

    /**
     * Affiche tous les films avec le réalisateur, année de sortie,les acteurs
     * et leur rôle dans chacun des films
     */
    public void afficherFilms() {
        for (Film film : lesFilms.values()) {
            System.out.println("Nom du film : " + film.getNomFilm());
            System.out.println("Nom du réalisateur : " + film.getRealisateur());
            System.out.println("Date de sortie : " + film.getDateSortie().toString());
            System.out.println("les roles du film sont : ");
            for (Role role : film.getRoles().values()) {
                System.out.println(role.getNomRole() + "- joué par :" + role.getActeur().getNomActeur());
            }
        }
    }

    /**
     * Affiche tous les acteurs avec le rôle qu'ils ont joué dans chacun de leur
     * filmn ainsi que réalisateur et année de sortie du film.
     */
    public void afficherActeurs() {
        System.out.println("il y a :\n");
        for (Acteur acteur : lesActeurs.values()) {
            System.out.println(acteur.getNomActeur() + "\n");
        }

    }

}
