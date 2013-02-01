package ch.warti.blackJack.strategy;

import ch.warti.blackJack.Card;
import ch.warti.blackJack.Hand;

public interface HandStrategy {
	public boolean shouldHit(Hand hand, Card dealerCard);
	public boolean shouldDouble(Hand hand, Card dealerCard);
	public boolean shouldSplit(Hand hand, Card dealerCard);

}
