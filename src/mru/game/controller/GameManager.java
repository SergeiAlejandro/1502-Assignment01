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

	ArrayList <Player> playerList = new ArrayList <Player>();
	
	// Constructor
	public GameManager() {
		
	}
	
	
	/**
	 * Checks if file exist
	 * 
	 * @param 
	 * 
	 * @return 
	 */
	public void run() throws FileNotFoundException {
		
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
		
		Menu.showMenu();
		Menu.processMenu();
		
	}

	
	/**
	 * Load File - Loads the text file
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
			
			// delete later
			//System.out.println(individualPlayer);
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

				if(firstPerson > secondPerson) {
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
			outFile.println(newPlayer.toString());
			i++;
		}
		
		printList();
		
		outFile.close();

	}
	
	
	/**
	 * (S) Search - Looking for a Name
	 * 
	 * @param nameSearched - Last name to search for, entered by user.
	 * 
	 * @return foundPerson - boolean, true if last name exists.
	 */
	public boolean searchName(String nameSearched) {
		
		String whatWasSearched;
		int listLength;
		boolean foundPerson = false;

		whatWasSearched = nameSearched.substring(0,1).toUpperCase() + nameSearched.substring(1);
		listLength = playerList.size();

		int i = 0;
		while (i < listLength && !foundPerson) {
			
			if (playerList.get(i).getName().equals(whatWasSearched)) {
				foundPerson = true;
			}
			
			i++;
			
		}
		
		return foundPerson;
		
	}


}
