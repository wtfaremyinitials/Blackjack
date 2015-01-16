package xyz.will.blackjack;

import java.util.ArrayList;

public class Hand {

	private ArrayList<Card> cards;
	
	private Hand(Card card1, Card card2) {
		cards = new ArrayList<Card>();
		
		cards.add(card1);
		cards.add(card2);
	}
	
	public Hand(Deck deck) {
		this(deck.pop(), deck.pop());
	}
	
	public void hit(Deck deck) {
		cards.add(deck.pop());
	}
	
	public int getScore() {
		int sum = 0;
		for(Card c : cards)
			sum += c.getValue();
		return sum;
	}
	
	public String toString() {
		String str = "";
		for(Card c : cards)
			str += c.toString() + (Game.unicodeMode?"":", ");
		if(!Game.unicodeMode)
			str = str.substring(0, str.length() - 2);
		return str;
	}
	
}
