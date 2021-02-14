package mru.game.model;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import mru.game.view.Menu;

public class PuntoBancoGame {
	
	/**
	 * In this class you implement the game
	 * You should use CardDeck class here
	 * See the instructions for the game rules
	 */

	CardDeck cardDeck;
	Scanner kbd = new Scanner(System.in);
	ArrayList <Player> playerList;
	
	/*
	 * Constructor
	 */
	public PuntoBancoGame(CardDeck cDeck) {
		
		cardDeck = cDeck;
		playerList = new ArrayList <Player>();

	}
	
	/*
	 * Run method
	 */
	public void run() throws FileNotFoundException {
		
		System.out.println("You are here (Punto Banco Game)");
		System.out.println();
		System.out.print("What is your name: ");
		String nameSearchParam = kbd.next();
		askName(nameSearchParam);
		
	}
	
	
	public void askName(String nameSeached) {

		String firstName;
		int numWins;
		double balance;
		String searchParam;
		int listLength;
		boolean foundPerson = false;
		
		

		searchParam = nameSeached.substring(0,1).toUpperCase() + nameSeached.substring(1);
		listLength = playerList.size();


		int i = 0;
		while (i < listLength && !foundPerson) {

			if (playerList.get(i).getName().equalsIgnoreCase(searchParam)) {

				firstName = playerList.get(i).getName();
				balance = playerList.get(i).getBalance();

				System.out.println();
				System.out.println("*******************************************************************");
				System.out.printf("***%-21s---$%,-20.2f***%n", firstName, balance);
				System.out.println("*******************************************************************");
				foundPerson = true;

				System.out.print("\nPress Enter to continue...");

				// Checks if they entered "Enter"
				String pressedEnter = kbd.nextLine();

				if (pressedEnter.equals("")) {
					System.out.println();
				}
				else {
					pressedEnter = null;
				}

			}
			i++;
		}
		
		if (!foundPerson) {
			System.out.println("Name does not exist.");
			
		}
	}
	
	
}
