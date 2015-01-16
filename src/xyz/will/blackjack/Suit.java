package xyz.will.blackjack;

/*
	An enumeration of possible suits
*/
public enum Suit {

	CLUBS    (0xD0),
	DIAMONDS (0xC0),
	HEARTS   (0xB0),
	SPADES   (0xA0);

	private int offset; // The Unicode code point offset of the card

	// Constructor for a suit
	private Suit(int offset) {
		this.offset = offset;
	}

	// Get the Unicode offset of a card
	public int getUnicodeOffset() {
		return offset;
	}

}
