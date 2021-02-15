package mru.game.model;

import java.util.ArrayList;

import mru.game.controller.GameManager;

public class CardInHand {
	
	ArrayList <CardDeck> cardDeckCopy = new ArrayList <CardDeck>();
	ArrayList <Card> playerCards = new ArrayList <Card>();
	ArrayList <Card> bankerCards = new ArrayList <Card>();
	
	
	
	int totalPlayerPoints;
	int totalBankerPoints;

	CardDeck newCardDeck;
	Card singleCard;
	
	// Constructor
	public CardInHand() {

		newCardDeck = CardDeck();
	}
	
	// 2 cards in hand
	// check who has highest number
	// sum up all cards then get the mod
	
	// face up = they know the value (suit and rank)
	// draw 2 more cards... all cards are printed on screen
	
	
	
	public void dealPlayerCard(){
		// pull random card 1 from cardDeck
		// add selected card to playerHand
		// Remove card from cardDeck
	}
	
	public void dealBankCard(){
		// pull random card from cardDeck
			//generate random number (this will be the index we pull)
		// add selected card to bankHand
		// Remove card from cardDeck
	}
	
	// adds up the value of all cards in players hand
	public int totalPlayerPoints(){
		int totalPPoints = 0;
		
		return totalPPoints;
	}
	
		// adds up the value of all cards in banker's hand
	public int totalBankerPoints(){
		int totalBPoints = 0;
		
		return totalBPoints;
	}
	
	// Running the game itself
	public void playGame(){
		// prepping deck for game
		// createDeck();
		// shuffleDeck();
		
		// Dealing cards
		dealPlayerCard();
		dealBankCard();
		dealPlayerCard();
		dealBankCard();
		
		//total points up
		totalPlayerPoints = totalPlayerPoints();
		totalBankerPoints = totalBankerPoints();
		
		// number 5
		if ((totalPlayerPoints == 8 || totalPlayerPoints == 9) || (totalBankerPoints == 8 || totalBankerPoints == 9)){
			determineWinner();
		}
		
		// number 6
		boolean playerdrawcard = true;
		
		if (totalPlayerPoints < 6 ){
			dealPlayerCard();
			playerdrawcard = false;
			determineWinner();
		}
		
		// number 7
		// A
		if (playerdrawcard = false){
			if  (totalBankerPoints < 6){
				// banker draws another card
				dealBankCard();
			}
			if(totalBankerPoints >= 6 && totalBankerPoints <= 7){
				// banker stands
			}
			determineWinner();
		}
		// B
		//if (Player.getRank)
		
		
	}
	
	
	/**
	 * 
	 * @return - Who wins in the end
	 */
	public String determineWinner(){
		String gameResult;

		if(totalPlayerPoints > totalBankerPoints) {
			gameResult = "Player Wins";
			System.out.println(cardDeckCopy);
		}
		else if(totalPlayerPoints < totalBankerPoints) {
			gameResult = "Banker Wins";
		}
		else 
			gameResult = "Tie Game";

		return gameResult;
	}
	 
}
