package ch.warti.blackJack.strategy.split;

import ch.warti.blackJack.Card;
import ch.warti.blackJack.CardType;
import ch.warti.blackJack.Hand;
import ch.warti.blackJack.strategy.StrategyUtil;

public class SplitStrategyImpl extends StrategyUtil implements SplitStrategy{
	
	int[] cardRule1 = {2,3,7};
	int[] dealerCardRule1 = {2,3,4,5,6,7};
	
	int[] cardRule2 = {4};
	int[] dealerCardRule2 = {5,6};
	
	int[] cardRule3 = {6};
	int[] dealerCardRule3 = {2,3,4,5,6};
	
	int[] cardRule4 = {8};
	int[] dealerNotCardRule4 = {10,-1};
	
	int[] cardRule5 = {9};
	int[] dealerNotCardRule5 = {7,10,-1};
	
	@Override
	public boolean shouldSplit(Hand hand, Card dealerCard) {
		//is splitting valid?
		if (hand.size()!=2) return false;
		if (hand.get(0).getValue() != hand.get(1).getValue()) return false;
		
		//check split
		Card card = hand.get(0);
		if (dealerCard.getType() == CardType.ACE) return false;
		if (isCardIn(card, cardRule1) && isCardIn(dealerCard, dealerCardRule1)) return true;
		if (isCardIn(card, cardRule2) && isCardIn(dealerCard, dealerCardRule2)) return true;
		if (isCardIn(card, cardRule3) && isCardIn(dealerCard, dealerCardRule3)) return true;
		if (isCardIn(card, cardRule4) && !isCardIn(dealerCard, dealerNotCardRule4)) return true;
		if (isCardIn(card, cardRule5) && !isCardIn(dealerCard, dealerNotCardRule5)) return true;
		
		return false;
	}
}
