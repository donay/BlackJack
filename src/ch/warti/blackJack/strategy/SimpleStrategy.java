package ch.warti.blackJack.strategy;


import ch.warti.blackJack.Card;
import ch.warti.blackJack.Hand;

public class SimpleStrategy extends Strategy {
	protected int drawTo;
	protected int stayOn;
	
	public SimpleStrategy(int drawTo, int stayOn) {
		super();
		this.drawTo = drawTo;
		this.stayOn = stayOn;
	}

	@Override
	public boolean shouldHit(Hand hand, Card dealerCard) {
			if (countPoints(hand) <= drawTo) return true;
			return false;
	}
	
	@Override
	public String toString() {
		return super.toString() + " " + this.drawTo + " " + this.stayOn;
	}

}
