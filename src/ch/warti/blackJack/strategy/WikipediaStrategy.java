package ch.warti.blackJack.strategy;

import ch.warti.blackJack.Card;
import ch.warti.blackJack.Hand;

public class WikipediaStrategy extends Strategy implements HandStrategy {

	private HardHandStrategy hhStrategy;
	private SoftHandStrategy shStrategy;

	public WikipediaStrategy() {
		super();
		hhStrategy = new HardHandStrategy();
		shStrategy = new SoftHandStrategy();
		
	}

	@Override
	public boolean shouldHit(Hand hand, Card dealerCard) {
			if (isHardHand(hand)) {
				return shouldHitOnHardHand(hand, dealerCard);
			} else {
				return shouldHitOnSoftHand(hand, dealerCard);
			}
		
			/*if (countPoints(hand) <= drawTo) return true;
			return false;*/
	}

	private boolean shouldHitOnHardHand(Hand hand, Card dealerCard) {
		return hhStrategy.shouldHit(hand, dealerCard);
		
	}
	
	private boolean shouldHitOnSoftHand(Hand hand, Card dealerCard) {
		return shStrategy.shouldHit(hand, dealerCard);
	}
	
	public boolean shouldDouble(Hand hand, Card dealerCard) {
		if (isHardHand(hand)) {
			return shouldDoubleOnHardHand(hand, dealerCard);
		} else {
			return shouldDoubleOnSoftHand(hand, dealerCard);
		}
	}
	
	private boolean shouldDoubleOnHardHand(Hand hand, Card dealerCard) {
		return hhStrategy.shouldDouble(hand, dealerCard);
		
	}
	
	private boolean shouldDoubleOnSoftHand(Hand hand, Card dealerCard) {
		return shStrategy.shouldDouble(hand, dealerCard);
	}

	@Override
	public boolean shouldSplit(Hand hand, Card dealerCard) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
