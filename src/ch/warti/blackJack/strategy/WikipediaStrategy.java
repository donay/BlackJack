package ch.warti.blackJack.strategy;

import ch.warti.blackJack.Card;
import ch.warti.blackJack.Hand;
import ch.warti.blackJack.strategy.hand.HardHandStrategyImpl;
import ch.warti.blackJack.strategy.hand.SoftHandStrategyImpl;
import ch.warti.blackJack.strategy.split.SplitStrategyImpl;

public class WikipediaStrategy extends StrategyUtil implements Strategy {

	private HardHandStrategyImpl hhStrategy;
	private SoftHandStrategyImpl shStrategy;
	private SplitStrategyImpl splitStrategy;

	public WikipediaStrategy() {
		super();
		hhStrategy = new HardHandStrategyImpl();
		shStrategy = new SoftHandStrategyImpl();
		splitStrategy = new SplitStrategyImpl();
	}

	@Override
	public boolean shouldHit(Hand hand, Card dealerCard) {
			if (isHardHand(hand)) {
				return shouldHitOnHardHand(hand, dealerCard);
			} else {
				return shouldHitOnSoftHand(hand, dealerCard);
			}
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

	public boolean shouldSplit(Hand hand, Card dealerCard) {
		return splitStrategy.shouldSplit(hand, dealerCard);
	}

	

}
