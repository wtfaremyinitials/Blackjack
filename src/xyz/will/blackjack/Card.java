package xyz.will.blackjack;

/*
	A class to represent a card
*/
public class Card {

	private Rank rank; // The rank of the card
	private Suit suit; // The suit of the card

	// Constructor for creating a card
	public Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}

	// Gets the rank of a card
	public Rank getRank() {
		return rank;
	}

	// Gets the rank of a card
	public Suit getSuit() {
		return suit;
	}

	// Gets the value of a card
	public int getValue() {
		return rank.getValue();
	}

	// Convert a card to a String
	public String toString() {
		if(Game.unicodeMode)
			return StringUtil.toUnicodeCard(rank, suit);
		return StringUtil.toTitleCase(rank.toString()) + " of " + suit.toString().toLowerCase();
	}

}
