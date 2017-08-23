import java.util.*;
import java.io.*;

//Title: Poker Comparator
//Author: William Ventura

public class MainDriver {
	public static PokerHand getHand(Scanner input){
		Card[] cards = new Card[5];
		String value = ""; 
		String suit = "";
		Suit s = null;
		Value v = null;	
		for(int i=0; i<5; i++){
			value = input.next();
			suit = input.next();
			input.nextLine();
			switch(value){
				case "2":
					v = Value.TWO;
					break;
				case "3":
					v = Value.THREE;
					break;
				case "4":
					v = Value.FOUR;
					break;
				case "5":
					v = Value.FIVE;
					break;
				case "6":
					v = Value.SIX;
					break;
				case "7":
					v = Value.SEVEN;
					break;
				case "8":
					v = Value.EIGHT;
					break;
				case "9":
					v = Value.NINE;
					break;
				case "10":
					v = Value.TEN;
					break;
				case "J":
					v = Value.JACK;
					break;
				case "Q": 
					v = Value.QUEEN;
					break;
				case "K":
					v = Value.KING;
					break;
				case "A":
					v = Value.ACE;
					break;
			}
			switch(suit){
				case "H":
					s = Suit.HEART;
					break;
				case "D":
					s = Suit.DIAMOND;
					break;
				case "C":
					s = Suit.CLUB;
					break;
				case "S":
					s = Suit.SPADE;
					break;
			}
			cards[i] = new Card(v,s);
		}
		return new PokerHand(cards[0],cards[1],cards[2],cards[3],
							 cards[4]);
	}	
	public static void main(String[] args)throws Exception {
		File file = new File("input.txt");
		Scanner in = new Scanner(file);

		while(in.hasNext()){
			PokerHand hand1 = getHand(in);
			PokerHand hand2 = getHand(in);
			System.out.println("Hand #1 rank: " + Arrays.toString(hand1.rank().toArray()));
			System.out.println("Hand #2 rank: " + Arrays.toString(hand2.rank().toArray()));
			int result = hand1.compareTo(hand2);
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
