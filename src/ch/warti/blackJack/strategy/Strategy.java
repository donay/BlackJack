package ch.warti.blackJack.strategy;

import ch.warti.blackJack.strategy.hand.HandStrategy;
import ch.warti.blackJack.strategy.split.SplitStrategy;

public interface Strategy extends HandStrategy, SplitStrategy {
	
}
