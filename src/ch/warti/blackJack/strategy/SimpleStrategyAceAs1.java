package ch.warti.blackJack.strategy;

import java.util.List;

import ch.warti.blackJack.Card;
import ch.warti.blackJack.Hand;

public class SimpleStrategyAceAs1 extends SimpleStrategy {

	public SimpleStrategyAceAs1(int drawTo, int stayOn) {
		super(drawTo, stayOn);
	}

	@Override
	public boolean shouldHit(Hand hand, Card dealerCard) {
			if (countPoints(hand) <= drawTo) return true;
			return false;
	}
	
	@Override
	public int useAceValueAs(int currentPoints, Card ace, List<Card> aces) {
		return 1;
	}

}
