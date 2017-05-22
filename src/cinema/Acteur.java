package cinema;

import java.util.HashMap;



/**
 *
 * @author culeta
 */
public class Acteur implements java.io.Serializable {
    
    private String                nomActeur;
    private HashMap<String, Role> roles = new HashMap<>(); // String = nom de film
    
    
    public Acteur(String nomActeur) {
        setNomActeur(nomActeur);
    }
    
    
    private void setNomActeur(String nomActeur) {
        this.nomActeur = nomActeur;
    }
    
    
    public String getNomActeur() {
        return nomActeur;
    }
    
    
    public void addrole(Role role) {
        roles.put(role.getFilm().getNomFilm(), role);
    }
    
    
    public HashMap<String, Role> getRoles() {
        return roles;
    }
    
}
