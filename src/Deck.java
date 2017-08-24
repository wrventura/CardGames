import java.util.*;
public class Deck {
	private ArrayList<Card> deck;
	public Deck(){
		deck = new ArrayList<Card>();
		for(Suit a : Suit.values())
			for(Value b : Value.values())
				deck.add(new Card(b,a));
	}
	public Card draw(){
		return deck.remove((int)(Math.random() * deck.size()));
	}
	public int size(){
		return deck.size();
	}
	public boolean isEmpty(){
		return deck.isEmpty();
	}
}
