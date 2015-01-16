package xyz.will.blackjack;

import java.util.Scanner;

public class StringUtil {

	private static Scanner scanner = new Scanner(System.in);
	
	public static String toTitleCase(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
	}
	
	public static void printHands(Hand player, Hand dealer) {
		System.out.println("You have: "       + player + (Game.easyMode? " (" + player.getScore() + ")" : ""));
		System.out.println("The dealer has: " + dealer + (Game.easyMode? " (" + dealer.getScore() + ")" : ""));
	}
	
	public static boolean askYesNo(String message)
    {
		System.out.println(message + " (y/n)");
		
        String answer = ""; 

        while(answer.length() != 1)
        {
            answer = scanner.nextLine();
            
            if(answer.length() != 1)
                System.out.println("That's not a valid input!");
        }
        
        return answer.charAt(0) == 'y';
    }
	
	// http://www.unicode.org/charts/PDF/U1F0A0.pdf Woo spec sheets are fun! =D
	public static String toUnicodeCard(Rank rank, Suit suit) {
		int codePoint = (int) 0x1F000;
		codePoint += suit.getUnicodeOffset();
		codePoint += rank.getUnicodeOffset();
		return new String(Character.toChars(codePoint));
	}
	
}
