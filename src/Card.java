public class Card implements Comparable<Card> {
	public Value value;
	public Suit suit;
	public Card(Value value, Suit suit){
		this.suit = suit;
		this.value = value;
	}
	public int compareTo(Card card) {
		return this.value.compareTo(card.value);
	}
	public String toString(){
		return value + " of " + suit;
	}
}
