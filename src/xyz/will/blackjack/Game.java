package xyz.will.blackjack;

/*
	A class to represent the game
*/
public class Game {

	public static boolean easyMode; // Whether or not scores are shown to the player
	public static boolean unicodeMode; // Whether or not cards are displayed as Unicode characters

	private Deck deck; // The deck of cards in use

	private Hand dealer; // The dealer's hand
	private Hand player; // The player's hand

	// Plays a game
	public void play() {
		deck = new Deck(); // Create a deck

		deck.shuffle(); // Shuffle the deck

		dealer = new Hand(deck); // Create a hand for the player
		player = new Hand(deck); // Create a hand for the dealer

		StringUtil.printHands(player, dealer); // Print both hands

		while(StringUtil.askYesNo("Would you like to hit?")) { // While the player still wants to hit, hit
			player.hit(deck); // Hit

			StringUtil.printHands(player, dealer); // Print both hands again

			if(player.getScore() > 21) { // If the player goes over 21, they lose
				System.out.println("You lose!");
				return;
			}
		}

		while(dealer.getScore() <= 17) { // While the dealer has less than 17, hit
			dealer.hit(deck); // Hit

			if(dealer.getScore() > 21) { // If the dealer goes over 21, they lose
				System.out.println("Dealer loses!");
				return;
			}
		}

		// Print both hands at the end of the game
		StringUtil.printHands(player, dealer);

		if(player.getScore() > 21) // If the player went over 21, they lose
			System.out.println("You lose!");
		else if(player.getScore() > 21) // If the dealer went over 21, they lose
			System.out.println("Dealer loses!");
		else if(player.getScore() == dealer.getScore())
			System.out.println("You tie"); // If the player and the dealer had the same score, they tie
		else if(player.getScore() > dealer.getScore())
			System.out.println("You win!"); // If you got a higher score, you win
		else if(player.getScore() < dealer.getScore())
			System.out.println("Dealer wins!"); // If they dealer got a higher score, they win
	}

	// Start the game executable
	public static void main(String[] args) {
		easyMode    = StringUtil.askYesNo("Would you like to play on easy mode?"); // Ask if the user wants easy mode
		unicodeMode = StringUtil.askYesNo("Would you like to use Unicode mode?");  // Ask if the user wants unicode mode

		new Game().play(); // Create a game and play it
		while(StringUtil.askYesNo("Play again?")) // While the user wants to continue playing, create new games
			new Game().play();
	}

}
