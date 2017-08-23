import java.util.*; 

public class PokerHand implements Comparable<PokerHand> {
	public enum Type {
		HIGH_CARD, PAIR, TWO_PAIR, THREE_OF_KIND, STRAIGHT,
		FLUSH, FULL_HOUSE, FOUR_OF_KIND, STRAIGHT_FLUSH
	}
	public ArrayList<Card> hand;
	public PokerHand(Card c1, Card c2, Card c3, Card c4, Card c5) {
		hand = new ArrayList<Card>();
		hand.add(c1);
		hand.add(c2);
		hand.add(c3);
		hand.add(c4);
		hand.add(c5);
		Collections.sort(hand);
	}
	public int compareTo(PokerHand hand2){
		ArrayList<Enum> handOne = this.getRank();
		ArrayList<Enum> handTwo = hand2.getRank();
		for(int i=0;i<handOne.size();i++){
			int temp = handOne.get(i).compareTo(handTwo.get(i)); 
				if(temp != 0)
					return temp;
		}
		return 0;
	}
/*
	public ArrayList<Enum> rank(){
		ArrayList<Enum> rank = new ArrayList<Enum>();
		Type type = getType();
		switch(type){
		case STRAIGHT_FLUSH:
			rank = straightFlushRank();
			break;
		case FOUR_OF_KIND:
			rank = fourOfKindRank();
			break;
		case FULL_HOUSE:
			rank = fullHouseRank();
			break;
		case FLUSH:
			rank = flushRank();
			break;
		case STRAIGHT:
			rank = straightRank();
			break;
		case THREE_OF_KIND:
			rank = threeOfKindRank();
			break;
		case TWO_PAIR:
			rank = twoPairRank();
			break;
		case PAIR:
			rank = pairRank();
			break;
		case HIGH_CARD:
			rank = highCardRank();
			break;
		}
		return rank;
	}
*/
	public ArrayList<Enum> pairRank(){
		ArrayList<Enum> rank = new ArrayList<Enum>();
		rank.add(Type.PAIR);
		Card first = hand.get(0);
		Card second = hand.get(1);
		Card third = hand.get(2);
		Card fourth = hand.get(3);
		Card fifth = hand.get(4);
		if(first.compareTo(second) == 0){
			rank.add(second.value);
			rank.add(fifth.value);
			rank.add(fourth.value);
			rank.add(third.value);
		}	
		else if(second.compareTo(third) == 0){
			rank.add(third.value);
			rank.add(fifth.value);
			rank.add(fourth.value);
			rank.add(first.value);
		}
		else if(third.compareTo(fourth) == 0){
			rank.add(fourth.value);
			rank.add(fifth.value);
			rank.add(second.value);
			rank.add(first.value);
		}
		else{
			rank.add(fifth.value);
			rank.add(third.value);
			rank.add(second.value);
			rank.add(first.value);
		}
		return rank;
	}
	public ArrayList<Enum> straightFlushRank(){
		ArrayList<Enum> rank = new ArrayList<Enum>();
		rank.add(Type.STRAIGHT_FLUSH);
		if(hand.get(0).value == Value.TWO &&
		   hand.get(4).value == Value.ACE)
			rank.add(Value.FIVE);
		else
			rank.add(hand.get(4).value);
		return rank;
	}	
	public ArrayList<Enum> straightRank(){
		ArrayList<Enum> rank = new ArrayList<Enum>();
		rank.add(Type.STRAIGHT);
		if(hand.get(0).value == Value.TWO &&
		   hand.get(4).value == Value.ACE)
			rank.add(Value.FIVE);
		else
			rank.add(hand.get(4).value);
		return rank;
	}
	public ArrayList<Enum> highCardRank(){
		ArrayList<Enum> rank = new ArrayList<Enum>();
		rank.add(Type.HIGH_CARD);
		for(int i=hand.size()-1;i>=0;i--)
			rank.add(hand.get(i).value);
		return rank;
	}
	public ArrayList<Enum> twoPairsRank(){
		ArrayList<Enum> rank = new ArrayList<Enum>();
		Card firstCard = hand.get(0);
		Card secondCard = hand.get(1);
		Card thirdCard = hand.get(2);
		Card fourthCard = hand.get(3);
		Card fifthCard = hand.get(4);
		rank.add(Type.TWO_PAIR);
		if(secondCard.compareTo(thirdCard) == 0){
			rank.add(fifthCard.value);
			rank.add(thirdCard.value);
			rank.add(firstCard.value);
		}
		else if(thirdCard.compareTo(fourthCard) == 0){
			rank.add(fourthCard.value);
			rank.add(secondCard.value);
			rank.add(fifthCard.value);
		}
		else{
			rank.add(fifthCard.value);
			rank.add(secondCard.value);
			rank.add(thirdCard.value);
		}
		return rank;
	}
	public ArrayList<Enum> flushRank(){
		ArrayList<Enum> rank = new ArrayList<Enum>();
		rank.add(Type.FLUSH);
		for(int i=hand.size()-1;i >= 0;i--)
			rank.add(hand.get(i).value);
		return rank;
	}	
	public ArrayList<Enum> threeOfKindRank(){
		Card firstCard = hand.get(0);
		Card secondCard = hand.get(1);
		Card fourthCard = hand.get(3);
		Card fifthCard = hand.get(4);
		ArrayList<Enum> rank = new ArrayList<Enum>();
		rank.add(Type.THREE_OF_KIND);
		if(firstCard.compareTo(secondCard) == 0){
			rank.add(firstCard.value);
			rank.add(fifthCard.value);
			rank.add(fourthCard.value);
		}
		else if(fifthCard.compareTo(fourthCard) == 0){
			rank.add(fifthCard.value);
			rank.add(secondCard.value);
			rank.add(firstCard.value);
		}
		else{
			rank.add(secondCard.value);
			rank.add(fifthCard.value);
			rank.add(firstCard.value);
		}
		return rank;
	}	
	public ArrayList<Enum> fullHouseRank(){
		Card secondCard = hand.get(1);
		Card thirdCard = hand.get(2);
		Card fourthCard = hand.get(3);
		ArrayList<Enum> rank = new ArrayList<Enum>();
		rank.add(Type.FULL_HOUSE);
		if(secondCard.compareTo(thirdCard) == 0){
			rank.add(secondCard.value);
			rank.add(fourthCard.value);
		}	
		else{
			rank.add(fourthCard.value);
			rank.add(secondCard.value);
		}
		return rank;
	}
	public ArrayList<Enum> fourOfKindRank(){
		Card firstCard = hand.get(0);
		Card secondCard = hand.get(1);
		Card lastCard = hand.get(4);
		ArrayList<Enum> rank = new ArrayList<Enum>();
		rank.add(Type.FOUR_OF_KIND);
		if(firstCard.compareTo(secondCard) ==0){
			rank.add(firstCard.value);
			rank.add(lastCard.value);
		}
		else{
			rank.add(lastCard.value);
			rank.add(firstCard.value);
		}
		return rank;
	}
	public String toString(){
		String temp = "[";
		for(int i=0; i<hand.size();i++){
			temp += hand.get(i).toString();
			if(i< hand.size()-1)
				temp += ", ";
		}
		temp += "]";
		return temp;
	}
	public boolean isStraight(){
		boolean temp = true;
		Value a = hand.get(0).value;
		if(a == Value.TWO && hand.get(4).value == Value.ACE){
			for(int i=1; i<hand.size()-1;i++){
				if(a.ordinal() != hand.get(i).value.ordinal() - 1)
					temp = false;
				a = hand.get(i).value;
			}
		}else{
			for(int i=1;i<hand.size();i++){
				if(a.ordinal() != hand.get(i).value.ordinal() - 1)
					temp = false;
				a = hand.get(i).value;
			}
		}
		return temp;
	}
	public boolean isFlush(){
		boolean temp = true;
		Suit a = hand.get(0).suit;
		for(int i=1;i<hand.size();i++)
			if(a != hand.get(i).suit)
				temp = false;
		return temp;
	}
	public ArrayList<Enum> getRank(){
		boolean straight = this.isStraight();
		boolean flush = this.isFlush();
		Map<Value,Integer> duplicates = new HashMap<Value,Integer>();
		int pairs = 0;
		int threeOfKind = 0;
		int fourOfKind = 0;
		for(int i=0;i<hand.size();i++){
			if(!duplicates.containsKey(hand.get(i).value))
				duplicates.put(hand.get(i).value,1);
			else
				duplicates.put(hand.get(i).value,duplicates.get(hand.get(i).value)+1);
		}
		for(Value a : duplicates.keySet()){
			if(duplicates.get(a) == 2)
				pairs++;
			else if(duplicates.get(a) == 3)
				threeOfKind++;
			else if(duplicates.get(a) == 4)
				fourOfKind++;
		}		
		if(straight && flush)
			return straightFlushRank();
		else if(straight)
			return straightRank();
		else if(flush)
			return flushRank();
		else if(fourOfKind == 1)
			return fourOfKindRank();
		else if(threeOfKind == 1 && pairs ==1)
			return fullHouseRank();
		else if(pairs == 2)
			return twoPairsRank();
		else if(threeOfKind == 1)
			return threeOfKindRank();
		else if(pairs == 1)
			return pairRank();
		else
			return highCardRank();
	}
}
