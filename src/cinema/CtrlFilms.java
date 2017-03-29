/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author culeta
 */
public class CtrlFilms {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
	        	
	    	Appli appli = new Appli();
	    	
			String choix ="0";
			do {
			System.out.println("\n***************************************************************");
			System.out.println("                 *  Mes films préférés       *");
			System.out.println("*****************************************************************");
			System.out.println("      * 1- Créer un nouvel acteur                     *");
			System.out.println("      * 2- Ajouter un film                            *");
			System.out.println("      * 3- Ajouter un acteur à un film                *");
			System.out.println("      * 4- Afficher les films                         *");
			System.out.println("      * 5- Afficher les acteurs                       *");
			
                        System.out.println("*****************************************************************");
			System.out.println("      * 0- Quitter                                              *");
			System.out.println("*****************************************************************");
			System.out.print("      Votre Choix : ");
			
                        choix = sc.nextLine();
                        switch (choix) {
				case "1": {
                                        DonneesUtilitaire.loadDB(appli); 
					appli.nouvelActeur(); 
                                        DonneesUtilitaire.updateDB(appli);
                                        break; }
				case "2": {
                                        DonneesUtilitaire.loadDB(appli); 
					appli.nouveauFilm(); 
                                        DonneesUtilitaire.updateDB(appli);
                                        break;}
				case "3": {
                                        DonneesUtilitaire.loadDB(appli); 
					appli.ajouterActeurFilm(); 
                                        DonneesUtilitaire.updateDB(appli);
                                        break;}
				case "4": {
                                        DonneesUtilitaire.loadDB(appli); 
					appli.afficherFilms(); 
                                        DonneesUtilitaire.updateDB(appli);
                                        break;}
				case "5": {
                                        DonneesUtilitaire.loadDB(appli); 
					appli.afficherActeurs(); 
                                        DonneesUtilitaire.updateDB(appli);
                                        break;}
                                case "0":
                                        return;
				default:
                                       System.out.println("Choix non valide");
                                       break;
				} // switch
                        } while (choix != "0");
			
         }         
}
