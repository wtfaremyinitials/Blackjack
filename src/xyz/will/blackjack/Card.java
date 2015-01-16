package xyz.will.blackjack;

public class Card {

	private Rank rank;
	private Suit suit;
	
	public Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}
	
	public Rank getRank() {
		return rank;
	}
	
	public Suit getSuit() {
		return suit;
	}
	
	public int getValue() {
		return rank.getValue();
	}
	
	public String toString() {
		if(Game.unicodeMode)
			return StringUtil.toUnicodeCard(rank, suit);
		return StringUtil.toTitleCase(rank.toString()) + " of " + suit.toString().toLowerCase();
	}
	
}
