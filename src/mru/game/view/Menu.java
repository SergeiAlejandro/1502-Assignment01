package mru.game.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import mru.game.controller.GameManager;
import mru.game.model.CardDeck;
import mru.game.model.Player;
import mru.game.model.PuntoBancoGame;

public class Menu {
	
	Scanner kbd = new Scanner(System.in);
	GameManager createdNewGameManager;
	PuntoBancoGame mainGame;
	
	/*
	 * Constructor
	 * 
	 * To initialize things
	 * 
	 */
	public Menu(GameManager gameMgr) {
		
		createdNewGameManager = gameMgr;
		mainGame = new PuntoBancoGame(new CardDeck());
		
	}
	
	
	/**
	 * This class will be used to show the menus and sub menus to the user
	 * It also prompts the user for the inputs and validates them 
	 */
    public void showMenu() {
    	
        System.out.println("\nSelect one of these options: ");
        System.out.println();
        System.out.println("\t(P) Play game");
        System.out.println("\t(S) Search");
        System.out.println("\t(E) Exit");
        System.out.println();
        System.out.print("Enter a choice: ");
        
    }
    
    
    /**
     * Sub-Menu
     * 
     */
    public void subMenu() {
    	
        System.out.println("\nSelect one of these options: ");
        System.out.println();
        System.out.println("\t(T) Top player (Most number of wins)");
        System.out.println("\t(N) Looking for a Name");
        System.out.println("\t(B) Back to Main Menu");
        System.out.println();
        System.out.print("Enter a choice: ");
        
        try {
			processSubMenu();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
    }
    
    
    /**
     * game-Sub-Menu
     * 
     */
    public void gameSubMenu() {
    	
        System.out.println("\nWhat do you want to bet on? ");
        System.out.println();
        System.out.println("\t(P) Player Wins");
        System.out.println("\t(B) Banker Wins");
        System.out.println("\t(T) Tie Game");
        System.out.println();
        System.out.print("Enter your choice: ");
        
	
    }
    
    
    /*
     * Process Menu
     * 
     * This checks what the user has chosen 
     * and processes the method chosen in the choice
     * It loops until user exits program
     */
	public void processMenu() throws FileNotFoundException {
		
		String answer;
		char option;
		Scanner kbd = new Scanner(System.in);
		
		answer = kbd.next();
		option = answer.toUpperCase().charAt(0);
		
//		while(option != 'A') {
			
			switch(option) {

			case 'P':
				// Create deck
					// Shuffle cards
					// deck stays the same through entire game
				
				// Set bet limit to account balance (if  bal == 0, return to main menu)
				// When program ends, save amd print data to file.
				// all user inputs must be validated 
				
				mainGame.run(); // runs punto banco game
				gameSubMenu(); // shows the menu
				processGameSubMenu(); // user input does process
				
				// delete this later, dont need
				System.exit(option);
				
			break;
				
			case 'S':
				subMenu();
			
			break;
			
			case 'E':
				createdNewGameManager.printFile();
				System.out.println("Thank you for playing!");
				System.out.println("Goodbye.");
				System.exit(option);
				
			break;
					
			default:
				System.out.println("Invalid Option");
			}
			
			showMenu();
			System.out.print("\nPlease enter a choice: ");
			answer = kbd.next();
			option = answer.toUpperCase().charAt(0);
			
		//}
		
		kbd.close();
	}
	
	
    /*//
     * Process Menu
     * 
     * This checks what the user has chosen 
     * and processes the method chosen in the choice
     * It loops until user exits program
     */
	public void processSubMenu() throws FileNotFoundException {
		
		String answer;
		char option;
		Scanner kbd = new Scanner(System.in);
		
		answer = kbd.next();
		option = answer.toUpperCase().charAt(0);
		
		while(option != '@') {
			
			switch(option) {

			case 'T':
				System.out.println();
				createdNewGameManager.getTopPlayers();
				
			break;
				
			case 'N':
				System.out.println("");
				System.out.print("What is your name: ");
				
				String nameSearchParam = kbd.next();
				createdNewGameManager.searchName(nameSearchParam);

			break;
			
			case 'B':
				showMenu();
				
			break;
			
			case 'E':
				createdNewGameManager.printFile();
				System.out.println("Thank you for playing!");
				System.out.println("Goodbye.");
				// we should probably fix this later *****************************
				//System.exit(option);
			break;
					
			default:
				System.out.println("Invalid Option");
			}
			
			showMenu();
			processMenu();
			
		}
		
		kbd.close();
		
	}
	
	
    /*//
     * Process Game Menu
     * 
     * This checks what the user has chosen 
     * and processes the method chosen in the choice
     * It loops until user exits program
     */
	public void processGameSubMenu() throws FileNotFoundException {
		
		String answer;
		char option;
		//boolean keepRunning = true;
		Scanner kbd = new Scanner(System.in);
		
		answer = kbd.next();
		option = answer.toUpperCase().charAt(0);
		
		//while(true) {
			
			switch(option) {

			case 'P': // betting on the player winning
				System.out.println("you are here: Player Wins");
				mainGame.betAmmount();
				
				
				//keepRunning = false;
			break;
				
			case 'B': // betting on the banker winning
				System.out.println("you are here: Banker Wins");
				mainGame.betAmmount();

				
				//keepRunning = false;
			break;
			
			case 'T': // betting on a tie game.
				System.out.println("you are here: Tie Game");
				mainGame.betAmmount();
				
				
				//keepRunning = false;
			break;
					
			default:
				System.out.println("Invalid Option");
			}
			
//			showMenu();
//			processMenu();
			
		//}
		
			kbd.close();
		
	}
	
}
