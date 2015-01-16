package xyz.will.blackjack;

import java.util.Scanner;

/*
	A collection of String methods
*/
public class StringUtil {

	private static Scanner scanner = new Scanner(System.in); // The scanner used for yes/no questions

	// Take a String and return the same string with only the first character in uppercase
	public static String toTitleCase(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
	}

	// Print out the player and dealer's hands
	public static void printHands(Hand player, Hand dealer) {
		System.out.println("You have: "       + player + (Game.easyMode? " (" + player.getScore() + ")" : "")); // Print the player's hand with the score if in easy mode
		System.out.println("The dealer has: " + dealer + (Game.easyMode? " (" + dealer.getScore() + ")" : "")); // Print the dealer's hand with the score if in easy mode
	}

	// Ask the user a yes or no question
	public static boolean askYesNo(String message)
    {
		System.out.println(message + " (y/n)"); // Print the question

        String answer = "";

        while(answer.length() != 1) // While the user still hasn't given us an answer, read
        {
            answer = scanner.nextLine(); // Read a line

            if(answer.length() != 1)
                System.out.println("That's not a valid input!"); // Scold the user
        }

        return answer.charAt(0) == 'y'; // Check if the user said yes
    }

	// Turn a Rank and a Suit into a Unicode string
	private final int BASE_CARD_CODE_POINT = (int) 0x1F000;
	public static String toUnicodeCard(Rank rank, Suit suit) {
		// http://www.unicode.org/charts/PDF/U1F0A0.pdf Woo spec sheets are fun! =D
		int codePoint = BASE_CARD_CODE_POINT; // The base code point for a card character
		codePoint += suit.getUnicodeOffset(); // Add the suit offset
		codePoint += rank.getUnicodeOffset(); // Add the rank offset
		return new String(Character.toChars(codePoint)); // Convert the code point to a String
	}

}
