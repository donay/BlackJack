package ch.warti.blackJack.strategy;

import ch.warti.blackJack.Card;
import ch.warti.blackJack.Hand;

public class HardHandStrategy extends Strategy implements HandStrategy {
	int[] dealerCardHitRule1 = {-1,10,9,8,7};
	int[] dealerCardHitRule2 = {6,5,4};
	int[] dealerCardHitRule3 = {3,2};
	
	int[] dealerCardDoubleRule1 = {6,5,4,3};
	int[] dealerCardDoubleRule2 = {-1,10};
	
	public HardHandStrategy() {
		super();
	}
	
	@Override
	public boolean shouldHit(Hand hand, Card dealerCard) {		
		if (isDealerCardIn(dealerCard, dealerCardHitRule1)) return shouldHitOnRule1(hand);
		if (isDealerCardIn(dealerCard, dealerCardHitRule2)) return shouldHitOnRule2(hand);
		if (isDealerCardIn(dealerCard, dealerCardHitRule3)) return shouldHitOnRule3(hand);
		
		return false; //never reached, rules cover Cards from -1 to 10
	}
	
		
	private boolean shouldHitOnRule1(Hand hand) {
		if (countPoints(hand)==16) return true;
		return false;
	}
	
	private boolean shouldHitOnRule2(Hand hand) {
		if (countPoints(hand)==11) return true;
		return false;
	}
	
	private boolean shouldHitOnRule3(Hand hand) {
		if (countPoints(hand)==12) return true;
		return false;
	}
	
	@Override
	public boolean shouldDouble(Hand hand, Card dealerCard) {		
		if (countPoints(hand) <= 8) return false;	
		if (countPoints(hand) >= 12) return false;
		if (isHandOutOf2CardsWithoutAnyAce(hand)) {
			return shouldDoubleOnDealerCardRules(hand, dealerCard);
		}
		return false;
	}

	private boolean shouldDoubleOnDealerCardRules(Hand hand, Card dealerCard) {
		if (isDealerCardDoubleRule1(hand, dealerCard)) return true;
		if (isDealerCardDoubleRule2(hand, dealerCard)) return true;
		return false;
	}
	
	private boolean isHandOutOf2CardsWithoutAnyAce (Hand hand) {
		return (hand.getAces().size() == 0 && hand.size() == 2);
	}
	

	private boolean isDealerCardDoubleRule1(Hand hand, Card dealerCard) {
		return (countPoints(hand) == 9 && 
				isDealerCardIn(dealerCard, dealerCardDoubleRule1));
	}

	private boolean isDealerCardDoubleRule2(Hand hand, Card dealerCard) {
		return ((countPoints(hand) == 10 || countPoints(hand) == 11) && 
				!isDealerCardIn(dealerCard, dealerCardDoubleRule2));
	}


	@Override
	public boolean shouldSplit(Hand hand, Card dealerCard) {
		// TODO Auto-generated method stub
		return false;
	}
}
