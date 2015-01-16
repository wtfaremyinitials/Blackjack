package xyz.will.blackjack;

public enum Suit {

	CLUBS    (0xD0),
	DIAMONDS (0xC0),
	HEARTS   (0xB0),
	SPADES   (0xA0);
	
	private int offset;
	
	private Suit(int offset) {
		this.offset = offset;
	}
	
	public int getUnicodeOffset() {
		return offset;
	}
	
}
