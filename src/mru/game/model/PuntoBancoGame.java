package mru.game.model;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import mru.game.controller.GameManager;
import mru.game.view.Menu;

public class PuntoBancoGame {
	
	/**
	 * In this class you implement the game
	 * You should use CardDeck class here
	 * See the instructions for the game rules
	 */

	CardDeck cardDeck;
	Scanner kbd = new Scanner(System.in);
	
	// FOR ARRAYLIST
	GameManager newGameManager;
	ArrayList <Player> newList = new ArrayList<Player>();
	
	/*
	 * Constructor
	 */
	public PuntoBancoGame(CardDeck cDeck) {
		
		cardDeck = cDeck;
		
		// FOR ARRAYLIST
		newGameManager = new GameManager();

	}
	
	/**
	 * Run method
	 * 
	 * @param 
	 * 
	 * @return
	 */
	public void run() throws FileNotFoundException {
		
		// FOR ARRAYLIST
		newList = newGameManager.getArrayList(); // pulls the array from playerList in GameManager
	
		System.out.print("What is your name: ");
		String nameSearchParam = kbd.next();
		askName(nameSearchParam);
		
	}
	
	
	public void askName(String nameSeached) {

		String firstName;
		//int numWins;
		double balance;
		String searchParam;
		int listLength;
		boolean foundPerson = false;
		
		

		searchParam = nameSeached.substring(0,1).toUpperCase() + nameSeached.substring(1);
		listLength = newList.size();


		int i = 0;
		while (i < listLength && !foundPerson) {

			if (newList.get(i).getName().equalsIgnoreCase(searchParam)) {

				firstName = newList.get(i).getName().toUpperCase();
				balance = newList.get(i).getBalance();

				System.out.println();
				System.out.println("*******************************************************************");
				System.out.printf("***   Welcome back %-21s--- Your balance is: $%,-20.2f***%n", firstName, balance);
				System.out.println("*******************************************************************");
				foundPerson = true;

//				System.out.print("\nPress Enter to continue...");
//
//				// Checks if they entered "Enter"
//				String pressedEnter = kbd.nextLine();
//
//				if (pressedEnter.equals("")) {
//					System.out.println();
//				}
//				else {
//					pressedEnter = null;
//				}

			}
			i++;
		}
		
		if (!foundPerson) {
			System.out.println("Name does not exist.");
	/* 
	 * Create new account with balance of $100
	 * 
	 */
			// variables
			Player newPlayer;
			double defaultBalance = 100.0;
			int defaultWins = 0;
			
			newPlayer = new Player (searchParam, defaultBalance, defaultWins);
			newList.add(newPlayer);
	
			newGameManager.topPlayersSort();
			
			
			System.out.println();
			System.out.println("*******************************************************************");
			System.out.printf("***   Welcome back %-10s --- Your balance is: $%,.2f   ***%n", searchParam, defaultBalance);
			System.out.println("*******************************************************************");
			
		}
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Bet Amount - What the player is betting
	 * 
	 * @param 
	 * 
	 * @return betAmount - returns the bet amount user entered
	 */
	public double betAmmount(){
		double betAmmount;
		
		System.out.print("\nHow much do you want to bet this round? ");
		betAmmount = kbd.nextDouble();
		
		return betAmmount;
	}
	
	
}
