package xyz.will.blackjack;

public class Game {

	public static boolean easyMode;
	public static boolean unicodeMode;
	
	private Deck deck;
	
	private Hand dealer;
	private Hand player;
	
	public void play() {
		deck = new Deck();
		
		deck.shuffle();
		
		dealer = new Hand(deck);
		player = new Hand(deck);
		
		StringUtil.printHands(player, dealer);
		
		while(StringUtil.askYesNo("Would you like to hit?")) {
			player.hit(deck);
			
			StringUtil.printHands(player, dealer);
			
			if(player.getScore() > 21) {
				System.out.println("You lose!");
				return;
			}
		}
		
		while(dealer.getScore() <= 17) {
			dealer.hit(deck);
			
			if(dealer.getScore() > 21) {
				System.out.println("Dealer loses!");
				return;
			}
		}
		
		StringUtil.printHands(player, dealer);
		
		if(player.getScore() > 21)
			System.out.println("You lose!");
		else if(player.getScore() > 21)
			System.out.println("Dealer loses!");
		else if(player.getScore() == dealer.getScore())
			System.out.println("You tie");
		else if(player.getScore() > dealer.getScore())
			System.out.println("You win!");
		else if(player.getScore() < dealer.getScore())
			System.out.println("Dealer wins!");
	}
	
	public static void main(String[] args) {
		easyMode    = StringUtil.askYesNo("Would you like to play on easy mode?");
		unicodeMode = StringUtil.askYesNo("Would you like to use Unicode mode?");
		
		new Game().play();
		while(StringUtil.askYesNo("Play again?"))
			new Game().play();
	}
	
}
