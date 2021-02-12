package mru.game.model;

public class Player {
	
	/**
	 * This class represent each player record in the Database
	 * It is basically a model class for each record in the txt file
	 */
	// Variables -------------------------
	String name;
	double balance;
	int numOfWins;
	
	// Constructor ------------------------
	public Player(String name, double balance, int numOfWins) {
		this.name = name;
		this.balance = balance;
		this.numOfWins = numOfWins;
	}
	
	// Setters ----------------------------
	public void setName(String name) {
		this.name = name;
	}
	
	public void setId(double balance) {
		this.balance = balance;
	}
	
	public void setNumOfWins(int numOfWins) {
		this.numOfWins = numOfWins;
	}
	
	// Getters ----------------------------
	public String getName() {
		return name;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public int getNumOfWins() {
		return numOfWins;
	}
	
	// toString
	public String toString() {
		return String.format("Name: %s Balance: %f Number of Wins: %d", name, balance, numOfWins);
	}
	 
}
