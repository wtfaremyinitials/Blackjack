package xyz.will.blackjack;

import java.util.ArrayList;
import java.util.Random;

public class Deck {

	private ArrayList<Card> cards;
	private Random rand;
	
	public Deck() {
		cards = new ArrayList<Card>();
		for(Rank rank : Rank.values())
			for(Suit suit : Suit.values())
				cards.add(new Card(rank, suit));
		rand = new Random();
	}

	public void shuffle() {
		ArrayList<Card> shuffled = new ArrayList<Card>();
		
		while(cards.size() != 0)
			shuffled.add(cards.remove(rand.nextInt(cards.size())));
		
		cards = shuffled;
	}
	
	public Card pop() {
		return cards.remove(0);
	}
	
}
