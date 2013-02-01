package ch.warti.blackJack.strategy.split;

import ch.warti.blackJack.Card;
import ch.warti.blackJack.Hand;

public interface SplitStrategy {
	public boolean shouldSplit(Hand hand, Card dealerCard);
}
