package xyz.will.blackjack;

/*
	A enumeration of possible card ranks
*/
public enum Rank {

	ACE   (11, 0x1),
	TWO   (2,  0x2),
	THREE (3,  0x3),
	FOUR  (4,  0x4),
	FIVE  (5,  0x5),
	SIX   (6,  0x6),
	SEVEN (7,  0x7),
	EIGHT (8,  0x8),
	NINE  (9,  0x9),
	TEN   (10, 0xA),
	JACK  (10, 0xB),
	QUEEN (10, 0xD),
	KING  (10, 0xE);

	private int value;	// The value of a card
	private int offset; // The unicode code point offset of the card

	// Constructor for a Rank
	private Rank(int value, int offset) {
		this.value  = value;
		this.offset = offset;
	}

	// Get the value of a card
	public int getValue() {
		return value;
	}

	// Get the Unicode offset of a card
	public int getUnicodeOffset() {
		return offset;
	}

}
