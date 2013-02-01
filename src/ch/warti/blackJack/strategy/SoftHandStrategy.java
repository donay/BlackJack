package ch.warti.blackJack.strategy;

import ch.warti.blackJack.Card;
import ch.warti.blackJack.Hand;

public class SoftHandStrategy extends Strategy implements HandStrategy{
	int[] dealerCardRule1 = {-1,10,9};
		
	public SoftHandStrategy() {
	}
	
	@Override
	public boolean shouldHit(Hand hand, Card dealerCard) {
		if (countPoints(hand) >= 19) return false;
		if (countPoints(hand) == 18 && hand.size() >= 3 && isDealerCardIn(dealerCard, dealerCardRule1)) return true;
		if (countPoints(hand) <= 17 && hand.size() >= 3) return true;
		
		return false;
	}
	
	@Override
	public boolean shouldDouble(Hand hand, Card dealerCard) {		
				
		return false;
	}

	@Override
	public boolean shouldSplit(Hand hand, Card dealerCard) {
		// TODO Auto-generated method stub
		return false;
	}
}
