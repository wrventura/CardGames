import java.util.*;
import java.io.*;

//Title: Poker Comparator
//Author: William Ventura

public class MainDriver {
	public static void main(String[] args)throws Exception {
		int games = 5;
		Deck deck = new Deck();
		PokerHand player1 = null;
		PokerHand player2 = null;
		for(int i = 0; i < 5; i++){
			player1 = new PokerHand(deck.draw(),deck.draw(),deck.draw(),
										deck.draw(),deck.draw());
			player2 = new PokerHand(deck.draw(),deck.draw(),deck.draw(),
										deck.draw(),deck.draw());
			System.out.println("Hand #1: " + player1);
			System.out.println("Hand #1 rank: " + player1.getRank());
			System.out.println("Hand #2: " + player2);
			System.out.println("Hand #2 rank: " + player2.getRank());
			int result =player1.compareTo(player2);
			if(result > 0)
				System.out.println("Hand #1 wins!");
		    	else if(result < 0)
				System.out.println("Hand #2 wins!");
		    	else
				System.out.println("It's a draw!");
				System.out.println();
		}
	}
}
