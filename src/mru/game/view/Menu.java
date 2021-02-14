package mru.game.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import mru.game.controller.GameManager;
import mru.game.model.Player;
import mru.game.model.PuntoBancoGame;

public class Menu {
	
	Scanner kbd = new Scanner(System.in);
	GameManager manager;
	
	
	/*
	 * Constructor
	 */
	public Menu(GameManager gameMgr) {

		manager = gameMgr;

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
				System.out.println("Punto Blanco was selected");
				//PuntoBancoGame test1 = new PuntoBancoGame();
				
			break;
				
			case 'S':
				subMenu();
				
			break;
			
			case 'E':
				manager.printFile();
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
				manager.getTopPlayers();
				
			break;
				
			case 'N':
				System.out.println();
				System.out.print("What is your name: ");
				
				String nameSearchParam = kbd.next();
				manager.searchName(nameSearchParam);

			break;
			
			case 'B':
				showMenu();
				
			break;
			
			case 'E':
				manager.printFile();
				System.out.println("Thank you for playing!");
				System.out.println("Goodbye.");
				System.exit(option);
					
			default:
				System.out.println("Invalid Option");
			}
			
			showMenu();
			processMenu();
			
		}
		
		kbd.close();
		
	}
}
