package mru.game.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import mru.game.controller.GameManager;
import mru.game.model.Player;
import mru.game.model.PuntoBancoGame;

public class Menu extends GameManager{
	/**
	 * This class will be used to show the menus and sub menus to the user
	 * It also prompts the user for the inputs and validates them 
	 */
    public static void showMenu() {
    	
        System.out.println("\nSelect one of these options:");
        System.out.println();
        System.out.println("\t(P) Play game");
        System.out.println("\t(S) Search");
        System.out.println("\t(E) Exit");
        System.out.println();
        System.out.println("Enter a choice:");
        
    }
    
    /*
     * Process Menu
     * 
     * This checks what the user has chosen 
     * and processes the method chosen in the choice
     * It loops until user exits program
     */
	public static void processMenu() throws FileNotFoundException {
		
		String answer;
		char option;
		Scanner kbd = new Scanner(System.in);
		
		answer = kbd.next();
		option = answer.toUpperCase().charAt(0);
		
		while(option != 'E') {
			
			switch(option) {

			case 'P':
				System.out.println("Punto Blanco was selected");
				//PuntoBancoGame test1 = new PuntoBancoGame();
				
			break;
				
			case 'S':
				System.out.println("Search was selected");
				
			break;
					
			default:
				System.out.println("Invalid Option");
			}
			
			showMenu();
			System.out.print("\nPlease enter a choice: ");
			answer = kbd.next();
			option = answer.toUpperCase().charAt(0);
			
		}
		
		kbd.close();
		
	}
}
