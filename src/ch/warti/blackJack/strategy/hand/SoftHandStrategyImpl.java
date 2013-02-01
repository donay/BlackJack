package ch.warti.blackJack.strategy.hand;

import ch.warti.blackJack.Card;
import ch.warti.blackJack.Hand;
import ch.warti.blackJack.strategy.StrategyUtil;

public class SoftHandStrategyImpl extends StrategyUtil implements HandStrategy{
	int[] dealerCardRule1 = {-1,10,9};
		
	public SoftHandStrategyImpl() {
	}
	
	@Override
	public boolean shouldHit(Hand hand, Card dealerCard) {
		if (countPoints(hand) >= 19) return false;
		if (countPoints(hand) == 18 && hand.size() >= 3 && isCardIn(dealerCard, dealerCardRule1)) return true;
		if (countPoints(hand) <= 17 && hand.size() >= 3) return true;
		
		return false;
	}
	
	@Override
	public boolean shouldDouble(Hand hand, Card dealerCard) {		
				
		return false;
	}
}
