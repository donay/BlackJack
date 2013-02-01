package ch.warti.blackJack.strategy;

import java.util.List;

import ch.warti.blackJack.Card;
import ch.warti.blackJack.Hand;

public abstract class Strategy {
	
	
	public Strategy () {

	}
	
	public int countPoints(Hand hand) {		
		int points = 0;
		points += countPointsWithoutAces(hand);  
		for (Card ace : hand.getAces()) {
			points+=this.useAceValueAs(points, ace, hand.getAces());
		}
		return points;
	}
	
	private int countPointsWithoutAces(Hand hand) {
		int points = 0;
		for (Card numberOrPic : hand.getWithoutAces())
		{
			points+=numberOrPic.getValue();
		}
		return points;
	}
	
	public int useAceValueAs(int currentPoints, Card ace, List<Card> aces) {
		aces.remove(ace);
		if ((currentPoints + 11 + (aces.size()) * 1) <= 21) {
			return 11;
		} else {
			return 1;
		}		
	}
	
	protected boolean isDealerCardIn(Card dealerCard, int[] list) {
		for (int i=0; i<list.length; i++) {
			if (dealerCard.getValue() == list[i]) return true;
		}
		return false;
		
	}
	
	public boolean isHardHand(Hand hand) {
		if (!hand.containsAces()) 
			return true;
		
		int points = countPointsWithoutAces(hand);
		for (Card ace : hand.getAces()) {
			int aceValue = useAceValueAs(points, ace, hand.getAces());
			if (aceValue == 11) {
				return false;
			}
			points+=aceValue;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}
	
	public abstract boolean shouldHit(Hand hand, Card dealerCard);
}
