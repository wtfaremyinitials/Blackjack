package xyz.will.blackjack;

import java.util.ArrayList;

/*
	A class that represents a Hand
*/
public class Hand {

	private ArrayList<Card> cards; // The cards in the hand

	// A constructor that takes 2 cards
	private Hand(Card card1, Card card2) {
		cards = new ArrayList<Card>(); // Create the list of cards

		cards.add(card1); // Add both cards to the list
		cards.add(card2);
	}

	// A constructor that takes a deck and removes 2 cards from it
	public Hand(Deck deck) {
		this(deck.pop(), deck.pop());
	}

	// Method to perform a hit
	public void hit(Deck deck) {
		cards.add(deck.pop()); // Take a card off the top of the deck
	}

	// Get the hand's score
	public int getScore() {
		int sum = 0;
		for(Card c : cards) // Loop over every card and add it's value to the score
			sum += c.getValue();
		return sum;
	}

	// Convert a card to a string
	public String toString() {
		String str = "";
		for(Card c : cards) // Loop over every card and add it to the string, add commas if not in unicode mode
			str += c.toString() + (Game.unicodeMode?"":", ");
		if(!Game.unicodeMode) // Remove trailing comma after list if not in Unicode mode
			str = str.substring(0, str.length() - 2);
		return str;
	}

}
