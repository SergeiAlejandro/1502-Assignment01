package mru.game.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import mru.game.model.Player;
import mru.game.view.Menu;

public class GameManager {

	/* In this class you will need these methods:
	 *************** A constructor
	 *************** A method to load the txt file into an arraylist 
	 *************** (if it exists, so you check if the txt file exists first)
	 *************** A save method to store the arraylist into the the txt file 
	 *************** A method to search for a player based their name
	 *************** A method to find the top players
	 * Depending on your designing technique you may need and you can add more methods here 
	 */

	ArrayList <Player> playerList;
	Scanner kbd = new Scanner(System.in);
	
	
	/*
	 * Constructor 
	 * 
	 * IDK what this does
	 */
	public GameManager() {
		
		playerList = new ArrayList <Player>();
		
		fileChecker();
		
	}
		
	
	/*
	 * Run method
	 */
	public void run() throws FileNotFoundException {
		
		Menu firstMenu = new Menu(this);
		firstMenu.showMenu();
					
		Menu secondMenu = new Menu(this);
		secondMenu.processMenu();
		
	}
	
	
	/**
	 * Checks if file exist
	 * 
	 * @param 
	 * 
	 * @return 
	 */
	public void fileChecker() {

		try {
			File inFile = new File ("res/CasinoInfo.txt");
			File newFile = new File ("res/CasinoInfo.txt");

			if(newFile.exists()) { 
				loadTextFile(newFile);
				System.out.println("File has been loaded.");
			}
			else {
				loadTextFile(inFile);
				System.out.println("File not found. File created.");
			}

			topPlayersSort();
			

		} catch (Exception e) {
			System.out.println(e);
			System.out.println("An error has occured. Try Again.");

		}

	}

	
	/**
	 * Load File - Loads the text file into the ArrayList
	 * 
	 * @param 
	 * 
	 * @return 
	 */
	public void loadTextFile(File filePassed) throws FileNotFoundException {

		Scanner in = new Scanner(filePassed);

		String name;
		double balance;
		int numOfWins;		
		Player individualPlayer;

		// While loop to load data from file into arrayList
		while (in.hasNext()) {
			
			name = in.next().replaceAll(",", "");
			balance = Double.parseDouble(in.next().replaceAll(",", ""));
			numOfWins = Integer.parseInt(in.next().replaceAll(",", ""));
			
			// stores info into individualPlayer
			individualPlayer = new Player(name, balance, numOfWins);
			
			// adds "individual" into the Array List (employeeList)
			playerList.add(individualPlayer);

		}
		
		// delete later, just testing
		topPlayersSort();
		
		in.close();
		
	}

	
	/**
	 * Print Players - Prints all players
	 * 
	 * @param 
	 * 
	 * @return 
	 */
    public void printList() {
		
    	System.out.println("\nNAME                 # WINS");
		
		for(Player player : playerList) {
			
			System.out.print(player + "\n");
			
		}
					
    }
	
    
	/**
	 * Top Player - Compares wins with all player and returns top wins
	 * 
	 * @param 
	 * 
	 * @return 
	 */
	public void topPlayersSort(){

		Player temp;
		int size = playerList.size();

		for(int i = 0; i < size; i++) {
			int firstPerson = playerList.get(i).getNumOfWins(); 

			for(int j = size - 1; j > i; j--) { 
				int secondPerson = playerList.get(j).getNumOfWins();

				if(firstPerson < secondPerson) {
					temp = playerList.get(i);
					playerList.set(i,playerList.get(j));
					playerList.set(j, temp);	
				}
			}
		}
	}
	
	
	/**
	 * Saves - Overwrites the text file with new updated info
	 * 
	 * @param 
	 * 
	 * @return 
	 */
	public void printFile() throws FileNotFoundException {
		
		PrintWriter outFile = new PrintWriter ("res/CasinoInfo.txt");

		Player newPlayer;
		int playerListAmount;
		int i;

		playerListAmount = playerList.size();

		i = 0;
		while (i < playerListAmount) {
			newPlayer = playerList.get(i);
			outFile.println(newPlayer.getName() + ", " + (int) newPlayer.getBalance() + ", " + (int) newPlayer.getNumOfWins());
			i++;
		}
		
		outFile.close();

	}
	
	
	/**
	 * (S) Search - Looking for a Name
	 * 
	 * @param nameSearched - Last name to search for, entered by user.
	 * 
	 * @return foundPerson - boolean, true if last name exists.
	 */
	public void searchName(String nameSeached) {

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
				numWins = playerList.get(i).getNumOfWins();
				balance = playerList.get(i).getBalance();

				System.out.println();
				System.out.printf("%41s%n", "- PLAYER INFO -");
				System.out.println("+=====================+=====================+=====================+");
				System.out.println("|NAME                 |# WINS               |BALANCE              |");
				System.out.println("+=====================+=====================+=====================+");
				System.out.printf("|%-21s|%-21d|$%,-20.2f|%n", firstName, numWins, balance);
				System.out.println("+=====================+=====================+=====================+");
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
	
	
	/*
	 * This is to get the top players from the arraylist
	 */
	public void getTopPlayers() {

		Player playerOne = playerList.get(0);
		Player playerTwo = playerList.get(1);
		
		String firstName = playerList.get(0).getName();
		int numWins = playerList.get(0).getNumOfWins();
		
		String firstName2 = playerList.get(1).getName();
		int numWins2 = playerList.get(1).getNumOfWins();
		
		System.out.println();
		System.out.printf("%30s%n", "- TOP PLAYERS -");
		System.out.println("+=====================+=====================+");
		System.out.println("|NAME                 |# WINS               |");
		System.out.println("+=====================+=====================+");
		System.out.printf("|%-21s|%-21d|%n", firstName, numWins);
		System.out.println("+---------------------+---------------------+");
		System.out.printf("|%-21s|%-21d|%n", firstName2, numWins2);
		System.out.println("+---------------------+---------------------+");
		
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
	
}