package xyz.will.blackjack;

import java.util.ArrayList;
import java.util.Random;

/*
	A class that represents a full deck of cards
*/
public class Deck {

	private ArrayList<Card> cards; // The cards in the deck
	private Random rand; // The Random object for shuffle

	// Constructor
	public Deck() {
		cards = new ArrayList<Card>(); // Create a new empty list
		for(Rank rank : Rank.values()) // Iterate over all possible card types
			for(Suit suit : Suit.values())
				cards.add(new Card(rank, suit));
		rand = new Random(); // Create a random object
	}

	// Shuffles the deck
	public void shuffle() {
		ArrayList<Card> shuffled = new ArrayList<Card>(); // Create a new empty list

		while(cards.size() != 0) // Loop through entire current deck, choosing random card to add to new list
			shuffled.add(cards.remove(rand.nextInt(cards.size())));

		cards = shuffled; // Set the list to the new shuffled list
	}

	// Take a card off the top of the deck
	public Card pop() {
		return cards.remove(0);
	}

}
